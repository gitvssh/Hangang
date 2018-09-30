package com.example.administrator.hangang;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.hangang.database.DbOpenHelper;

public class ProgramActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private ActionBar actionBar;

    ImageView prg_img;
    TextView prg_title,prg_content,prg_date,prg_place,prg_participate,prg_fee;
    //색변경용 타이틀
    TextView prg_label_date,prg_label_place,prg_label_participate,prg_label_fee;

    String title,content,date,place,participate,fee;
    FrameLayout background;

    //db변수 선언
    private DbOpenHelper mDbOpenHelper;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        //인텐트에서 인덱스 얻기
        Intent intent=getIntent();
        int index=intent.getIntExtra("index",-1);



        actionBar = getSupportActionBar();  //액션바 추가
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout) ; //네비게이션뷰를 위한 드로우레이아웃
        actionBar.setHomeAsUpIndicator(R.mipmap.baseline_dehaze_white_18dp);//홈버튼 아이콘 설정
        actionBar.setDisplayHomeAsUpEnabled(true);//홈기능 활성화
        actionBar.setTitle("");//타이틀 삭제
        actionBar.setBackgroundDrawable(getDrawable(R.color.arc));//액션바 색상 변경

        NavigationView navigationView = (NavigationView) findViewById(R.id.naviView);
        navigationView.setNavigationItemSelectedListener(this);//네비게이션뷰 리스너
        navigationView.setItemBackgroundResource(R.color.white);//네비게이션 색상 조정

        //db create and open
        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();

        //인덱스로 쿼리실행
        if(index!=-1) {
            Cursor c1 = mDbOpenHelper.executeRawQuery(index);


        //레이아웃 객체 초기화
        prg_img=findViewById(R.id.prg_img);
        prg_title=findViewById(R.id.prg_title);
        prg_content=findViewById(R.id.prg_content);
        prg_date=findViewById(R.id.prg_date);
        prg_place=findViewById(R.id.prg_place);
        prg_participate=findViewById(R.id.prg_participate);
        prg_fee=findViewById(R.id.prg_fee);
        background=findViewById(R.id.prg_backgroundColorLayout);

        prg_label_date=findViewById(R.id.prg_label_date);
        prg_label_participate=findViewById(R.id.prg_label_participate);
        prg_label_place=findViewById(R.id.prg_label_place);
        prg_label_fee=findViewById(R.id.prg_label_fee);

        //쿼리문에서 컬럼값 받아와서 string값에 넣음
        if(c1!=null&&c1.moveToFirst()) {
            title = c1.getString(1);
            content = c1.getString(2);
            date = c1.getString(3);
            place = c1.getString(4);
            participate = c1.getString(5);
            fee = c1.getString(6);
            c1.close();
        }

        //이미지 처리 알고리즘
            if(index>16){
            index=index%16;
            if(index==0){
                index=16;
            }
            }
        String resName = "@drawable/prg_";
        if(index<10) {
            resName+="0"+index;
        }else{
            resName+=""+index;
        }
        String packName = this.getPackageName();

        int resID = getResources().getIdentifier(resName, "drawable", packName);
        prg_img.setBackgroundResource(resID);


        //값 설정
        prg_title.setText(title);
        prg_content.setText(content);
        prg_date.setText(date);
        prg_place.setText(place);
        prg_participate.setText(participate);
        prg_fee.setText(fee);
        }

        //index값에 따라 배경,글자색 설정
        if(index<6){
            background.setBackgroundColor(R.color.siwon);
            prg_label_date.setTextColor(R.color.siwon);
            prg_label_participate.setTextColor(R.color.siwon);
            prg_label_place.setTextColor(R.color.siwon);
            prg_label_fee.setTextColor(R.color.siwon);
        }else if(index>=6&&index<12){
            background.setBackgroundColor(R.color.gamdong);
            prg_label_date.setTextColor(R.color.gamdong);
            prg_label_participate.setTextColor(R.color.gamdong);
            prg_label_place.setTextColor(R.color.gamdong);
            prg_label_fee.setTextColor(R.color.gamdong);
        }else if(index>=12&&index<=16){
            background.setBackgroundColor(R.color.zayeon);
            prg_label_date.setTextColor(R.color.zayeon);
            prg_label_participate.setTextColor(R.color.zayeon);
            prg_label_place.setTextColor(R.color.zayeon);
            prg_label_fee.setTextColor(R.color.zayeon);
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

            Intent intent=new Intent(ProgramActivity.this,MainActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if (id == R.id.navi_hangang){

            Intent intent=new Intent(ProgramActivity.this,introduceActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        if (id == R.id.navi_direct){

            Intent intent=new Intent(ProgramActivity.this,DirectionActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_theme){

//            Intent intent=new Intent(ProgramActivity.this,ProgramActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_date){

//            Intent intent=new Intent(ProgramActivity.this,ProgramActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if (id == R.id.navi_reserv){

//            Intent intent=new Intent(ProgramActivity.this,ProgramActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_notice){

//            Intent intent=new Intent(ProgramActivity.this,introduceActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_cvs){

           Intent intent=new Intent(ProgramActivity.this,map.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }


        return false;
    }
}
