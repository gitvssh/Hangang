package com.example.administrator.hangang;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class DateBase {

    SQLiteDatabase db;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        setCreateView(R.layout.activity_main);
    }
}
