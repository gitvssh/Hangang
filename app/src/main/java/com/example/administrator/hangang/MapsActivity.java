package com.example.administrator.hangang;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MapsActivity extends Fragment implements OnMapReadyCallback,GoogleMap.OnMyLocationButtonClickListener,ActivityCompat.OnRequestPermissionsResultCallback {

    private GoogleMap mMap;
    Location location;
    LocationManager locationManager;
    String locationProvider;
    String inputLine, responseBuilder, handlemsg;
    Boolean clicked = false;
    static String aim;

    static final LatLng DEFAULT_LOCATION = new LatLng(37.56, 126.97);
    private Marker currentMarker = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_maps,container,false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //우측 상단에 내위치 버튼
        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }else{

        }

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationProvider = locationManager.getBestProvider(new Criteria(),true);
        location = locationManager.getLastKnownLocation(locationProvider);

        setCurrentLocation(location,"시작","marker",12);

        mMap.getUiSettings().setZoomControlsEnabled(true);//줌 컨트롤

    }

    Handler handler = new Handler(){
        Bundle bun;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bun = msg.getData();
            handlemsg = bun.getString("JSONDATA");
            Log.i("핸들",handlemsg);

            try {
                JSONObject json = new JSONObject(responseBuilder);
                Log.i("JS", json.toString());
                JSONArray result = json.getJSONArray("results");
                Log.i("JSr", result.getJSONObject(0).toString());

                Log.i("반복횟수", result.length() + "");
                for (int i = 0; i < result.length(); i++) {


                    double lat = result.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lat");
                    double lng = result.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getDouble("lng");
                    Log.i("위도경도", lat + ":" + lng);
                    LatLng sydney = new LatLng(lat, lng);
                    mMap.addMarker(new MarkerOptions().position(sydney).title(result.getJSONObject(i).getString("name")));
                    Log.i("마커이름", result.getJSONObject(i).getString("name"));
                    LatLng sydney1 = new LatLng(37.49, 127);
                    mMap.addMarker(new MarkerOptions().position(sydney1).title("addMarker" + i));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng( location.getLatitude(), location.getLongitude()),15));
                }
            }catch(Exception e){}

        }
    };

    public void setCurrentLocation(Location location, String markerTitle, String markerSnippet,float zoom) {
        if ( currentMarker != null ) currentMarker.remove();

        if ( location != null) {
            //현재위치의 위도 경도 가져옴
            LatLng currentLocation = new LatLng( location.getLatitude(), location.getLongitude());

            //MarkerOptions markerOptions = new MarkerOptions();
            //markerOptions.position(currentLocation);
            //markerOptions.title(markerTitle);
            //markerOptions.snippet(markerSnippet);
            //markerOptions.draggable(true);
            //markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            //currentMarker = this.mMap.addMarker(markerOptions);

            this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,zoom));
            return;
        }

        //MarkerOptions markerOptions = new MarkerOptions();
        //markerOptions.position(DEFAULT_LOCATION);
        //markerOptions.title(markerTitle);
        //markerOptions.snippet(markerSnippet);
        //markerOptions.draggable(true);
        //markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        //currentMarker = this.mMap.addMarker(markerOptions);

        this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DEFAULT_LOCATION,zoom));
    }

    public GoogleMap getmMap(){
        return mMap;
    }

    public void addMarker(String aim){
        if(clicked){
            mMap.clear();
        }
        this.aim = aim;
        new Thread(){
            String ai=MapsActivity.aim;
            public void run(){

                String result = searchOnMap(ai,location,2000);
                Bundle bun = new Bundle();
                bun.putString("JSONDATA",result);

                Message msg = handler.obtainMessage();
                msg.setData(bun);
                handler.sendMessage(msg);

            }
        }.start();

        clicked = true;
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(getContext(), "현재 위치를 표시합니다",Toast.LENGTH_LONG).show();
        return false;
    }


    public String searchOnMap(String search,Location location,int rad){

        try {

            URL url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query="+search+"&location="+location.getLatitude()+","+location.getLongitude()+"&radius="+rad+"&key=AIzaSyDlum3uw8mceGV9Kel8YHW12oamasHj6M8");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(is,"UTF-8"));

            StringBuilder str = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                str.append(inputLine);
            }
            responseBuilder = str.toString();
            in.close();
            Log.i("받은메세지",responseBuilder==null?"공백":responseBuilder);


        }catch(MalformedURLException me){
            me.printStackTrace();
        }catch (UnsupportedEncodingException ue){
            ue.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        }finally {
            return responseBuilder;
        }

    }


}
