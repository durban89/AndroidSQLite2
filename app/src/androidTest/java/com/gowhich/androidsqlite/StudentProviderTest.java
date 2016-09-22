package com.gowhich.androidsqlite;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
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
    public void insert(){
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri uri = Uri.parse("content://com.gowhich.androidsqlite.StudentProvider/student");
        ContentValues values = new ContentValues();
        values.put("name","张三");
        values.put("address","上海");
        contentResolver.insert(uri, values);
    }

}
