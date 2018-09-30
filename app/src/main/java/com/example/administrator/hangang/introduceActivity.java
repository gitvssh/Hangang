package com.example.administrator.hangang;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class introduceActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

        actionBar = getSupportActionBar();  //액션바 추가
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout) ; //네비게이션뷰를 위한 드로우레이아웃
        actionBar.setHomeAsUpIndicator(R.mipmap.baseline_dehaze_white_18dp);//홈버튼 아이콘 설정
        actionBar.setDisplayHomeAsUpEnabled(true);//홈기능 활성화
        actionBar.setTitle("");//타이틀 삭제
        actionBar.setBackgroundDrawable(getDrawable(R.color.arc));//액션바 색상 변경

        NavigationView navigationView = (NavigationView) findViewById(R.id.naviView);
        navigationView.setNavigationItemSelectedListener(this);//네비게이션뷰 리스너
        navigationView.setItemBackgroundResource(R.color.white);
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

            Intent intent=new Intent(introduceActivity.this,MainActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if (id == R.id.navi_hangang){

            Intent intent=new Intent(introduceActivity.this,introduceActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        if (id == R.id.navi_direct){

            Intent intent=new Intent(introduceActivity.this,DirectionActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_theme){

            Intent intent=new Intent(introduceActivity.this,ProgramActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_date){

//            Intent intent=new Intent(introduceActivity.this,ProgramActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if (id == R.id.navi_reserv){

//            Intent intent=new Intent(introduceActivity.this,ProgramActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_notice){

//            Intent intent=new Intent(introduceActivity.this,introduceActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_cvs){

            Intent intent=new Intent(introduceActivity.this,map.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }


        return false;
    }
}
