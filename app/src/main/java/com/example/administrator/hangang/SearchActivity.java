package com.example.administrator.hangang;

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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.hangang.database.DbOpenHelper;
import com.example.administrator.hangang.search.Search;
import com.example.administrator.hangang.search.SearchAdapter;

public class SearchActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    ListView listview;
    SearchAdapter adapter;
    //네비게이션 뷰 및 액션바
    private DrawerLayout drawerLayout;
    private ActionBar actionBar;
    //db변수 선언
    private DbOpenHelper mDbOpenHelper;
    private Cursor mCursor;

    //db에서 읽어온 값 저장할 변수
    String title,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listview = (ListView) findViewById(R.id.s_listview);

        //db create and open
        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();

        adapter = new SearchAdapter(getApplicationContext());

        actionBar = getSupportActionBar();  //액션바 추가
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout) ; //네비게이션뷰를 위한 드로우레이아웃
        actionBar.setHomeAsUpIndicator(R.mipmap.baseline_dehaze_white_18dp);//홈버튼 아이콘 설정
        actionBar.setDisplayHomeAsUpEnabled(true);//홈기능 활성화
        actionBar.setTitle("");//타이틀 삭제
        NavigationView navigationView = (NavigationView) findViewById(R.id.naviView);
        navigationView.setNavigationItemSelectedListener(this);//네비게이션뷰 리스너
        navigationView.setItemBackgroundResource(R.color.white);//네비게이션 색상 조정


        Intent intent=getIntent();
        int[] index=intent.getIntArrayExtra("index");


        for(int i=0;i<index.length;i++){
            mCursor=mDbOpenHelper.executeRawQuery(index[i]);
            if(mCursor!=null&&mCursor.moveToFirst()) {
                title = mCursor.getString(1);
                content=mCursor.getString(2);
                mCursor.close();
            }
            String resName = "@drawable/prg_";
            if(index[i]<10) {
                resName+="0"+index[i];
            }else{
                resName+=""+index[i];
            }
            String packName = this.getPackageName();

            int resID = getResources().getIdentifier(resName, "drawable", packName);
            adapter.addItem((new Search(title,content,resID,index[i])));
        }


        adapter.addItem((new Search("영어샘플", "재밌어요~",R.drawable.seoulinkifestival01,28)));
        adapter.addItem((new Search("일어샘플", "재밌어요~",R.drawable.seoulinkifestival01,34)));
        adapter.addItem((new Search("중어샘플", "재밌어요~",R.drawable.seoulinkifestival01,50)));


        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Search item = (Search) adapter.getItem(position);

                int index = item.getIndex();//해당 아이템의 인덱스 가져옴

                Intent intent = new Intent(getApplicationContext(),ProgramActivity.class);
                intent.putExtra("index",index);//인텐트에 해당 프로그램의 db인덱스 전달

                startActivity(intent);
            }
        });

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

            Intent intent=new Intent(SearchActivity.this,MainActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if (id == R.id.navi_hangang){

            Intent intent=new Intent(SearchActivity.this,introduceActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        if (id == R.id.navi_direct){

            Intent intent=new Intent(SearchActivity.this,DirectionActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_theme){

            Intent intent=new Intent(SearchActivity.this,ProgramActivity.class);
            startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_date){

//            Intent intent=new Intent(SearchActivity.this,ProgramActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else if (id == R.id.navi_reserv){

//            Intent intent=new Intent(SearchActivity.this,ProgramActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_notice){

//            Intent intent=new Intent(SearchActivity.this,introduceActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }else if (id == R.id.navi_cvs){
//TODO"편의시설 연결"
//            Intent intent=new Intent(SearchActivity.this,MapActivity.class);
//            startActivity(intent);
//            drawerLayout.closeDrawer(GravityCompat.START);

        }


        return false;
    }
}
