package com.example.administrator.hangang.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper {


    private static final String DATABASE_NAME = "hangang.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    //SQLite헬퍼클래스 상속 내부클래스, db관리용(생성,오픈,조회)
    private class DatabaseHelper extends SQLiteOpenHelper {

        //생성자
        public DatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        //DB가 존재하지 않을때 최초 1회 호출하여 DB생성
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DataBase.CreateDB.CREATE);
            //TODO : 최초생성시 프로그램 정보 입력SQL 여기다 넣어야함

            db.execSQL("insert into hanGang(id, title, content, date, place, participate, fee) values('1', '한강수상놀이터'," +
                    " '카약, 카누, 패들보드, 수상자전거, 오리보트', '7.20(금)~8.19(일) 10:00~22:00(무동력은 19:00까지)', " +
                    "'여의도한강공원 파라다이스 인근 수상', '현장접수, 사전예약', " +
                    "'1만원~3만원(일부프로그램 초보강습비 별도, 프로그램 내용 참조)');");

            db.execSQL("insert into hanGang(id, title, content, date, place, participate, fee) values('2', '한강물싸움축제', " +
                    "'한강몽땅 대표 프로그램으로 더위를 시원하게 날려버리는 물싸움 대전', '8.4(토)~8.5(일) 11:00~18:00'," +
                    "'난지한강공원 젊음의광장', '사전예약, 현장접수', '1만1천원 (7세 이하 무료입장)');");

            db.execSQL("insert into hanGang(id, title, content, date, place, participate, fee) values('3', '한강몽땅 종이배경주대회', " +
                    "'직접 만든 종이배를 타고 한강 위의 반환점을 돌아오는 경주대회', '8.10(금)~8.12(일) 09:00~16:30'," +
                    "'잠실한강공원 내 잠실나들목 앞 둔치', '사전예약, 현장접수', '50,000원jjj(배 1대 제작 기준)');");
        }

        //DB버전 업그레이드시, 기존 DB 삭제하고 다시 만듬
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DataBase.CreateDB.TABLENAME);
            onCreate(db);
        }

    }


    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

    public DbOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        mDB.close();
    }
}
