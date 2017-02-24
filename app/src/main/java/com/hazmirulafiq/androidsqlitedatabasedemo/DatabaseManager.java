package com.hazmirulafiq.androidsqlitedatabasedemo;

import android.content.Context;
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


}
