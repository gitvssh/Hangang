package com.example.administrator.hangang;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.hangang.database.DbOpenHelper;
import com.example.administrator.hangang.search.Search;
import com.example.administrator.hangang.search.SearchAdapter;

public class SearchActivity extends AppCompatActivity {
    ListView listview;
    SearchAdapter adapter;

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
}
