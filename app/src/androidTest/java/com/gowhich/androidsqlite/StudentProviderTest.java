package com.gowhich.androidsqlite;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.test.ApplicationTestCase;

import org.junit.Test;

/**
 * Created by durban126 on 16/9/22.
 */

public class StudentProviderTest extends ApplicationTestCase<Application> {
    public StudentProviderTest() {
        super(Application.class);
    }

    @Test
    public void insert() {
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri uri = Uri.parse("content://com.gowhich.androidsqlite.StudentProvider/student");
        ContentValues values = new ContentValues();
        values.put("name", "王三");
        values.put("address", "上海");
        contentResolver.insert(uri, values);
    }

    @Test
    public void delete() {
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri uri = Uri.parse("content://com.gowhich.androidsqlite.StudentProvider/student/1");
        contentResolver.delete(uri, null, null);
    }

    @Test
    public void update() {
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri uri = Uri.parse("content://com.gowhich.androidsqlite.StudentProvider/student/2");
        ContentValues values = new ContentValues();
        values.put("name", "留能");
        values.put("address", "北京");
        contentResolver.update(uri, values, null, null);
    }

    @Test
    public void query() {
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri uri = Uri.parse("content://com.gowhich.androidsqlite.StudentProvider/student/2");

        Cursor cursor = contentResolver.query(uri, null, null, null,null);
        while (cursor.moveToNext()){
            System.out.println("====>" + cursor.getString(cursor.getColumnIndex("name")));
        }
    }

}
