package com.example.administrator.hangang.search;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.hangang.R;

//어댑터를 구현해서 리스트뷰를 보여주는 플래그먼트
public class SearchFragment extends Fragment{
    ListView listview;
    SearchAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(container!=null){
            container = null;
        }
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_search,container,false);
        listview = (ListView) rootView.findViewById(R.id.s_listview);

        adapter = new SearchAdapter(getContext());

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

            }
        });

        return rootView;
    }
}