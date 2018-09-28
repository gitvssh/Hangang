package com.example.administrator.hangang.database;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import static com.example.administrator.hangang.database.DataBase.CreateDB.CREATE;

public class DataBase {

    public static final class CreateDB implements BaseColumns {
        public static final String TABLENAME = "hangang";
        public static final String CREATE = "create table hangang(id integer primary key,title text,content text,date text,place text ,participate text,fee text);";

    }

}
