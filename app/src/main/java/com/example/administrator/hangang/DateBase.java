package com.example.administrator.hangang;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class DateBase {

    boolean databaseCreated;
    boolean tableCreated;

    SQLiteDatabase db;

    private void createDatabase(String name){
        db = SQLiteDatabase.openOrCreateDatabase(name,  null,null);

        databaseCreated = true;
    }

    private void createTable(String name){
        db.execSQL("create table hanGang("
                + "_id text PRIMARY KEY autoincrement,"
                + "title text, "
                + "content text, "
                + "date text, "
                + "place text, "
                + "participate text, "
                + "fee text);" );

        tableCreated = true;
    }

    private void insertRecord(){


        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('1_k', '한강수상놀이터'," +
                " '카약, 카누, 패들보드, 수상자전거, 오리보트', '7.20(금)~8.19(일) 10:00~22:00(무동력은 19:00까지)', " +
                "'여의도한강공원 파라다이스 인근 수상', '현장접수, 사전예약', " +
                "'1만원~3만원(일부프로그램 초보강습비 별도, 프로그램 내용 참조)');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('2_k', '한강물싸움축제', " +
                "'한강몽땅 대표 프로그램으로 더위를 시원하게 날려버리는 물싸움 대전', '8.4(토)~8.5(일) 11:00~18:00'" +
                "'난지한강공원 젊음의광장', '사전예약, 현장접수', '1만1천원 (7세 이하 무료입장)');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('3_k', '한강몽땅 종이배경주대회', " +
                "'직접 만든 종이배를 타고 한강 위의 반환점을 돌아오는 경주대회', '8.10(금)~8.12(일) 09:00~16:30'" +
                "'잠실한강공원 내 잠실나들목 앞 둔치', '사전예약, 현장접수', '50,000원(배 1대 제작 기준)');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('4_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('5_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('6_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('7_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('8_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('9_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('10_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('11_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('12_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('13_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('14_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('15_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('16_k', '', " +
                "'', ''" +
                "'', '', '');");

        db.execSQL("insert into hanGang(_id, title, content, date, place, participate, fee) values('_e', '', " +
                "'', ''" +
                "'', '', '');");
    }
}
