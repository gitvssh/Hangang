package com.example.administrator.hangang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.hangang.search.Search;
import com.example.administrator.hangang.search.SearchAdapter;

public class SearchActivity extends AppCompatActivity {
    ListView listview;
    SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listview = (ListView) findViewById(R.id.s_listview);

        adapter = new SearchAdapter(getApplicationContext());

        //TODO: 여기에 인텐트로 받아온 인덱스로 SQL쿼리 날려서 어댑터에 프로그램 정보 등록해야함
        adapter.addItem((new Search("한강몽땅", "재밌어요~",R.drawable.seoulinkifestival01)));
        adapter.addItem((new Search("한강몽땅", "재밌어요~",R.drawable.seoulinkifestival01)));
        adapter.addItem((new Search("한강몽땅", "재밌어요~",R.drawable.seoulinkifestival01)));


        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Search item = (Search) adapter.getItem(position);
                //TODO: 선택된 리스트의 인덱스 인텐트로 전달해서 상세 프로그램으로 화면 이동
                Intent intent = new Intent(getApplicationContext(),ProgramActivity.class);
                startActivity(intent);
            }
        });

    }
}
