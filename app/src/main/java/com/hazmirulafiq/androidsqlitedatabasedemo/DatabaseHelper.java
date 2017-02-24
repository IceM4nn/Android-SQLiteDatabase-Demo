package com.hazmirulafiq.androidsqlitedatabasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IceMann on 21/2/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Information
    private static final String DB_NAME = "ToDO.db";

    // database version
    private static final int DB_VERSION = 1;

    // Table Name
    static final String TABLE_NAME = "ToDoList";

    // Table from
    static final String _ID = "_id";
    static final String TITLE = "Title";
    static final String DESC = "Description";

    // Creating table query
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY, " + TITLE + " TEXT NOT NULL, " + DESC + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
