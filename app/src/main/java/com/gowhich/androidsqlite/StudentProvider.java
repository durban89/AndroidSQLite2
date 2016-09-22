package com.gowhich.androidsqlite;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gowhich.androidsqlite.db.DBHelper;

/**
 * Created by durban126 on 16/9/22.
 */

public class StudentProvider extends ContentProvider {

    private final String TAG = "StudentProvider";

    private DBHelper dbHelper = null;

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int STUDENT = 1;
    private static final int STUDENTS = 2;

    //定义匹配规则
    static {
        URI_MATCHER.addURI("com.gowhich.androidsqlite.StudentProvider", "student", STUDENT);
        URI_MATCHER.addURI("com.gowhich.androidsqlite.StudentProvider", "student", STUDENTS);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        int flag = URI_MATCHER.match(uri);
        switch(flag){
            case STUDENT:
                return "vnd.android.cursor.item/student";
            case STUDENTS:
                return "vnd.android.cursor.dir/students";

        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri resultUri = null;
        int flag = URI_MATCHER.match(uri);
        switch(flag){
            case STUDENT:
                break;
            case STUDENTS:
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                long id = database.insert("student", null, values );
                resultUri = ContentUris.withAppendedId(uri, id);
                break;
        }
        Log.i(TAG, "------>" + resultUri.toString());
        return resultUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
