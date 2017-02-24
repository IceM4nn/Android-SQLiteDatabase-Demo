package com.hazmirulafiq.androidsqlitedatabasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IceMann on 24/2/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Initialize Database Information
    private static final String DATABASE_NAME = "ToDo.db";
    // Initialize Database Version
    private static final int DATABASE_VERSION = 1;
    // Initialize Table Name
    private static final String TABLE_NAME = "ToDoList";
    // Initialize Table Column
    private static final String _ID = "_Id";
    private static final String _TITLE = "_Title";
    private static final String _DESCRIPTION = "_Description";

    // Create table query (in this query, I don't make the ID to autoincrement as it will cause the id
    // value to keep increment even when the table row is empty, and I don't want that to happen)
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + _ID
    + " INTEGER PRIMARY KEY, " + _TITLE + " TEXT NOT NULL, " + _DESCRIPTION + " TEXT);";

    // Create constructor and remove unnecessary parameter
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Override both two methods below
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
