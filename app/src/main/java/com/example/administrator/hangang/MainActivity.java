package com.example.administrator.hangang;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.example.administrator.hangang.database.DbOpenHelper;
import com.example.administrator.hangang.database.Program;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ActivityCompat.OnRequestPermissionsResultCallback{
    final int[] SIWON={1,2,3,4,5};
    final int[] GAMDONG={6,7,8,9,10,11};
    final int[] ZAYEON={12,13,14,15,16};

    int language = 1;//언어설정값 1:한국어, 2:영어, 3:일본어, 4:중국어1, 5:중국어2

    //메인화면 프로그램 버튼들
    private ImageButton siwon,gamdong,zayeon;
    private FrameLayout today1,today2,today3,today4;

    private DrawerLayout drawerLayout;
    private ActionBar actionBar;


    //db변수 선언
    private DbOpenHelper mDbOpenHelper;

    //위치정보 접근권한 요청 코드
    static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 999;
    static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 998;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //위치정보 접근권한 요청
        getPermission(Manifest.permission.ACCESS_FINE_LOCATION,MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        getPermission(Manifest.permission.ACCESS_COARSE_LOCATION,MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);


        //로딩화면 실행
        startActivity(new Intent(this,LoadingActivity.class));

        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        //loadTestDatas();


        actionBar = getSupportActionBar();  //액션바 추가
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout) ; //네비게이션뷰를 위한 드로우레이아웃
        actionBar.setHomeAsUpIndicator(R.mipmap.baseline_dehaze_white_18dp);//홈버튼 아이콘 설정
        actionBar.setDisplayHomeAsUpEnabled(true);//홈기능 활성화
        actionBar.setTitle("");//타이틀 삭제
        actionBar.setBackgroundDrawable(getDrawable(R.color.arc));//액션바 색상 변경

        NavigationView navigationView = (NavigationView) findViewById(R.id.naviView);
        navigationView.setNavigationItemSelectedListener(this);//네비게이션뷰 리스너
        navigationView.setItemBackgroundResource(R.color.white);






//        actionBar.setBackgroundDrawable(new ColorDrawable());

        RollPagerView mRollViewPager = (RollPagerView)findViewById(R.id.rollpagerview);
        mRollViewPager.setAdapter(new TestLoopAdapter(mRollViewPager));
        //db create and open
        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();


        //시원한강
        siwon= findViewById(R.id.MainButton1);
        siwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),SearchActivity.class);

                intent.putExtra("index",SIWON);
                startActivity(intent);
            }
        });

        //감동한강
        gamdong= findViewById(R.id.MainButton2);
        gamdong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),SearchActivity.class);

                intent.putExtra("index",GAMDONG);
                startActivity(intent);
            }
        });

        //자연한강
        zayeon= findViewById(R.id.MainButton3);
        zayeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),SearchActivity.class);

                intent.putExtra("index",ZAYEON);
                startActivity(intent);
            }
        });

        //오늘의 행사
        today1=findViewById(R.id.main_today1);
        today1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProgramActivity.class);

                intent.putExtra("index",16);
                startActivity(intent);
            }
        });
        today2=findViewById(R.id.main_today2);
        today2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProgramActivity.class);

                intent.putExtra("index",1);
                startActivity(intent);
            }
        });
        today3=findViewById(R.id.main_today3);
        today3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProgramActivity.class);

                intent.putExtra("index",9);
                startActivity(intent);
            }
        });
        today4=findViewById(R.id.main_today4);
        today4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProgramActivity.class);

                intent.putExtra("index",15);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onResume() {
        super.onResume();

    }
       private class TestLoopAdapter extends LoopPagerAdapter {
        private int[] imgs = {
                R.drawable.mainimgslide1,
                R.drawable.mainimgslide2,
                R.drawable.mainimgslide3,
                R.drawable.mainimgslide4,
                R.drawable.mainimgslide5,
                R.drawable.mainimgslide6,

        };

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }
    }
    //액션바 메뉴 활성화
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //홈버튼 네비게이션뷰 온오프
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
    //사이드메뉴 메뉴선택 이벤트
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.navi_home){

            Intent intent=new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if (id == R.id.navi_hangang){

            Intent intent=new Intent(MainActivity.this,introduceActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_direct){

            Intent intent=new Intent(MainActivity.this,DirectionActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_theme){

            Intent intent=new Intent(MainActivity.this,ProgramActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_date){

            Intent intent=new Intent(MainActivity.this,PrepareActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if (id == R.id.navi_reserv){

            Intent intent=new Intent(MainActivity.this,PrepareActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_notice){

            Intent intent=new Intent(MainActivity.this,PrepareActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_cvs){

             Intent intent=new Intent(MainActivity.this,map.class);
             startActivity(intent);
             drawerLayout.closeDrawer(GravityCompat.START);

    }else if(id==R.id.navi_korean){//1
        if(language==1){
            return false;
        }
        language=1;

            TextView main_notice=findViewById(R.id.main_notice);
            main_notice.setText(R.string.notice);

            TextView main_btn1=findViewById(R.id.main_btn1);
            main_btn1.setText(R.string.btn1);

            TextView main_btn2=findViewById(R.id.main_btn2);
            main_btn2.setText(R.string.btn2);

            TextView main_btn3=findViewById(R.id.main_btn3);
            main_btn3.setText(R.string.btn3);

            TextView main_today=findViewById(R.id.main_today);
            main_today.setText(R.string.today);

            TextView main_han1=findViewById(R.id.main_han1);
            main_han1.setText(R.string.han1);

            TextView main_han2=findViewById(R.id.main_han2);
            main_han2.setText(R.string.han2);

            TextView main_han3=findViewById(R.id.main_han3);
            main_han3.setText(R.string.han3);

            TextView main_han4=findViewById(R.id.main_han4);
            main_han4.setText(R.string.han4);

            TextView navi_menu1=findViewById(R.id.navi_menu1);
            navi_menu1.setText(R.string.navi_menu1);

            TextView navi_home=findViewById(R.id.navi_home);
            navi_home.setText(R.string.navi_home);

            TextView navi_hangang=findViewById(R.id.navi_hangang);
            navi_hangang.setText(R.string.navi_hangang);

            TextView navi_direct=findViewById(R.id.navi_direct);
            navi_direct.setText(R.string.navi_direct);

            TextView navi_menu2=findViewById(R.id.navi_menu2);
            navi_menu2.setText(R.string.navi_menu2);

            TextView navi_theme=findViewById(R.id.navi_theme);
            navi_theme.setText(R.string.navi_theme);

            TextView navi_date=findViewById(R.id.navi_date);
            navi_date.setText(R.string.navi_date);

            TextView navi_reserv=findViewById(R.id.navi_reserv);
            navi_reserv.setText(R.string.navi_reserv);

            TextView navi_menu3=findViewById(R.id.navi_menu3);
            navi_menu3.setText(R.string.navi_menu3);

            TextView navi_notice=findViewById(R.id.navi_notice);
            navi_notice.setText(R.string.navi_notice);

            TextView navi_cvs=findViewById(R.id.navi_cvs);
            navi_cvs.setText(R.string.navi_cvs);

            TextView prg_label_date=findViewById(R.id.prg_label_date);
            prg_label_date.setText(R.string.prg_label_date);

            TextView prg_label_place=findViewById(R.id.prg_label_place);
            prg_label_place.setText(R.string.prg_label_place);

            TextView prg_label_participate=findViewById(R.id.prg_label_participate);
            prg_label_participate.setText(R.string.prg_label_participate);

            TextView prg_label_fee=findViewById(R.id.prg_label_fee);
            prg_label_fee.setText(R.string.prg_label_fee);


        }else if(id==R.id.navi_english){//2
            if(language==2){
                return false;
            }

            language=2;

            TextView main_notice=findViewById(R.id.main_notice);
            main_notice.setText(R.string.notice_2);

            TextView main_btn1=findViewById(R.id.main_btn1);
            main_btn1.setText(R.string.btn1_2);

            TextView main_btn2=findViewById(R.id.main_btn2);
            main_btn2.setText(R.string.btn2_2);

            TextView main_btn3=findViewById(R.id.main_btn3);
            main_btn3.setText(R.string.btn3_2);

            TextView main_today=findViewById(R.id.main_today);
            main_today.setText(R.string.today_2);

            TextView main_han1=findViewById(R.id.main_han1);
            main_han1.setText(R.string.han1_2);

            TextView main_han2=findViewById(R.id.main_han2);
            main_han2.setText(R.string.han2_2);

            TextView main_han3=findViewById(R.id.main_han3);
            main_han3.setText(R.string.han3_2);

            TextView main_han4=findViewById(R.id.main_han4);
            main_han4.setText(R.string.han4_2);

            TextView navi_menu1=findViewById(R.id.navi_menu1);
            navi_menu1.setText(R.string.navi_menu1_2);

            TextView navi_home=findViewById(R.id.navi_home);
            navi_home.setText(R.string.navi_home_2);

            TextView navi_hangang=findViewById(R.id.navi_hangang);
            navi_hangang.setText(R.string.navi_hangang_2);

            TextView navi_direct=findViewById(R.id.navi_direct);
            navi_direct.setText(R.string.navi_direct_2);

            TextView navi_menu2=findViewById(R.id.navi_menu2);
            navi_menu2.setText(R.string.navi_menu2_2);

            TextView navi_theme=findViewById(R.id.navi_theme);
            navi_theme.setText(R.string.navi_theme_2);

            TextView navi_date=findViewById(R.id.navi_date);
            navi_date.setText(R.string.navi_date_2);

            TextView navi_reserv=findViewById(R.id.navi_reserv);
            navi_reserv.setText(R.string.navi_reserv_2);

            TextView navi_menu3=findViewById(R.id.navi_menu3);
            navi_menu3.setText(R.string.navi_menu3_2);

            TextView navi_notice=findViewById(R.id.navi_notice);
            navi_notice.setText(R.string.navi_notice_2);

            TextView navi_cvs=findViewById(R.id.navi_cvs);
            navi_cvs.setText(R.string.navi_cvs_2);

            TextView prg_label_date=findViewById(R.id.prg_label_date);
            prg_label_date.setText(R.string.prg_label_date_2);

            TextView prg_label_place=findViewById(R.id.prg_label_place);
            prg_label_place.setText(R.string.prg_label_place_2);

            TextView prg_label_participate=findViewById(R.id.prg_label_participate);
            prg_label_participate.setText(R.string.prg_label_participate_2);

            TextView prg_label_fee=findViewById(R.id.prg_label_fee);
            prg_label_fee.setText(R.string.prg_label_fee_2);

    }else if(id==R.id.navi_japanese){//3

            if(language==3){
                return false;
            }
            language=3;
    }else if(id==R.id.navi_chinese){//4

            if(language==4){
                return false;
            }
            language=4;
    }else if(id==R.id.navi_chinese2){//5

            if(language==5){
                return false;
            }
            language=5;
    }

        return false;
    }


    public void getPermission(String permission,int request){
        // 현재 엑티버티의 사용 권한을 동적으로 요청
        if (ContextCompat.checkSelfPermission(this,
                permission)
                != PackageManager.PERMISSION_GRANTED) {

            // 설명이 필요한 경우 메시지를 발생시키는 내용을 입력
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    permission)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // 설명없이 사용자 권한을 바로 요청
                ActivityCompat.requestPermissions(this,
                        new String[]{permission},
                        request);

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    Toast.makeText(this,"권한 요청이 거부되었습니다.",Toast.LENGTH_LONG).show();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
