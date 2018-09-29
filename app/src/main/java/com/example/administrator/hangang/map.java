package com.example.administrator.hangang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class map extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    MapsActivity mapsActivity;
    DrawerLayout drawerLayout;
    ActionBar actionBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);


        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        mapsActivity = new MapsActivity();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.mapfragment, mapsActivity);
        fragmentTransaction.commit();


        actionBar = getSupportActionBar();
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout) ;
        actionBar.setHomeAsUpIndicator(R.mipmap.baseline_dehaze_white_18dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");

        NavigationView navigationView = (NavigationView) findViewById(R.id.naviView);
        navigationView.setNavigationItemSelectedListener(this);//네비게이션뷰 리스너

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            if(!drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.openDrawer(GravityCompat.START);
            }else{
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.navi_home){

            Intent intent=new Intent(map.this,MainActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if (id == R.id.navi_hangang){

            Intent intent=new Intent(map.this,introduceActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_direct){

            Intent intent=new Intent(map.this,DirectionActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_theme){

            Intent intent=new Intent(map.this,ProgramActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_date){

//            Intent intent=new Intent(map.this,ProgramActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if (id == R.id.navi_reserv){

//            Intent intent=new Intent(map.this,ProgramActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_notice){

//            Intent intent=new Intent(map.this,introduceActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_cvs){

            Intent intent=new Intent(map.this,map.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }


        return false;
    }

    public void onButton1Clicked(View v){
        mapsActivity.addMarker("편의점");
    }
    public void onButton2Clicked(View v){
        mapsActivity.addMarker("화장실");
    }

}
