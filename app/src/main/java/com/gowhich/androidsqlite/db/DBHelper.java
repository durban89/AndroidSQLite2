package com.gowhich.androidsqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by durban126 on 16/9/22.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static String name = "mydb.db";
    private static int version = 1;

    public DBHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table student (id integer primary key autoincrement), name varchar(64), address varchar(64)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
