package com.example.administrator.hangang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class SearchFragment extends Fragment{
    ListView listview;
    SearchAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(container!=null){
            container = null;
        }
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_search,container,false);
        listview = (ListView) rootView.findViewById(R.id.s_listview);

        adapter = new SearchAdapter();
        adapter.addItem((new Search("한강몽땅", "재밌어요~",R.drawable.seoulinkifestival01)));
        adapter.addItem((new Search("한강몽땅", "재밌어요~",R.drawable.seoulinkifestival01)));
        adapter.addItem((new Search("한강몽땅", "재밌어요~",R.drawable.seoulinkifestival01)));


        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Search item = (Search) adapter.getItem(position);

            }
        });

        return rootView;
    }
}