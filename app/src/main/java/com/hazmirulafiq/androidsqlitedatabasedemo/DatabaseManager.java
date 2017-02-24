package com.hazmirulafiq.androidsqlitedatabasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by IceMann on 24/2/2017.
 */

public class DatabaseManager {
    // Call instance below
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    // Create constructor
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
        contentValues.put(dbHelper._TITLE, title);
        contentValues.put(dbHelper._DESCRIPTION, description);
        database.insert(dbHelper.TABLE_NAME,null,contentValues);
    }

    public void update(int id, String title, String description) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper._TITLE, title);
        contentValues.put(dbHelper._DESCRIPTION, description);
        database.update(dbHelper.TABLE_NAME, contentValues, dbHelper._ID + " = " + id, null);
    }

    public void delete(int id) {
        database.delete(dbHelper.TABLE_NAME,dbHelper._ID + " = " + id, null);
    }

    public Cursor fetch() {
        String[] columns = new String[] {dbHelper._ID, dbHelper._TITLE, dbHelper._DESCRIPTION};
        Cursor cursor = database.query(dbHelper.TABLE_NAME,columns,null, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
