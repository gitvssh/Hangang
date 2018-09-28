package com.example.administrator.hangang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProgramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        //TODO:intent 객체에서 인덱스값 불러오고, DB설정해서 쿼리날려서 정보 불러온뒤, string값 설정하기
    }
}
