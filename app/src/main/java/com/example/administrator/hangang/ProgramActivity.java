package com.example.administrator.hangang;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.hangang.database.DbOpenHelper;

public class ProgramActivity extends AppCompatActivity {

    ImageView prg_img;
    TextView prg_title,prg_content,prg_date,prg_place,prg_participate,prg_fee;

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
        String resName = "@drawable/prg_";
        if(index<10) {
            resName+="0"+index;
        }else{
            resName+=""+index;
        }
        String packName = this.getPackageName();

        int resID = getResources().getIdentifier(resName, "drawable", packName);
        prg_img.setBackgroundResource(resID);

        if(index<6){
            background.setBackgroundColor(R.color.siwon);
        }else if(index<12){
            background.setBackgroundColor(R.color.gamdong);
        }else{
            background.setBackgroundColor(R.color.zayeon);
        }


        //값 설정
        prg_title.setText(title);
        prg_content.setText(content);
        prg_date.setText(date);
        prg_place.setText(place);
        prg_participate.setText(participate);
        prg_fee.setText(fee);
        }
    }
}
