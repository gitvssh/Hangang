package com.example.administrator.hangang;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by rohyj on 2018-09-11.
 */

public class SearchAdapter extends BaseAdapter {
    ArrayList<Search> items = new ArrayList<Search>();

    @Override
    public int getCount() {
        return items.size();

    }

    public void addItem(Search item) {
        items.add(item);
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        SearchView view = new SearchView(context());
        Search item = items.get(position);
        view.setTitle(item.getTitle());
        view.setContent(item.getContent());
        view.setImage(item.getResId());

        return view;
    }

    private Context context() {
        return context();
    }


}















