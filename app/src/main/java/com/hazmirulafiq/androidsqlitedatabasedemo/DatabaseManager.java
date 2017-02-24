package com.hazmirulafiq.androidsqlitedatabasedemo;

/**
 * Created by IceMann on 23/2/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DatabaseManager(Context c) {
        this.context = c;
    }

    public DatabaseManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String title, String description) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.TITLE, title);
        contentValues.put(dbHelper.DESC, description);
        database.insert(dbHelper.TABLE_NAME, null, contentValues);
    }

    public void update(int id, String title, String description) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.TITLE, title);
        contentValues.put(dbHelper.DESC, description);
        database.update(dbHelper.TABLE_NAME, contentValues, dbHelper._ID + " = " + id, null);
    }

    public void delete(int id) {
        database.execSQL("DELETE FROM " + dbHelper.TABLE_NAME + " WHERE " + dbHelper._ID + "='" + id + "'");
    }

    public Cursor fetch() {
        String[] columns = new String[]{dbHelper._ID, dbHelper.TITLE, dbHelper.DESC};
        Cursor cursor = database.query(dbHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
