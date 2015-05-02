package com.cs465.letsplay.SQLite;

import android.content.*;
import android.database.sqlite.*;

/**
 * Created by Piyush on 4/29/2015.
 */
public class DBHelper extends SQLiteOpenHelper
{

    public DBHelper(Context context)
    {
        super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DatabaseContract.UserTable.CREATE_TABLE);
        db.execSQL(DatabaseContract.FriendsTable.CREATE_TABLE);
        db.execSQL(DatabaseContract.SportsTable.CREATE_TABLE);
        db.execSQL(DatabaseContract.EventTable.CREATE_TABLE);
    }

    // Method is called during an update or delete is done of the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DatabaseContract.UserTable.DELETE_TABLE);
        db.execSQL(DatabaseContract.SportsTable.DELETE_TABLE);
        db.execSQL(DatabaseContract.FriendsTable.DELETE_TABLE);
        db.execSQL(DatabaseContract.EventTable.DELETE_TABLE);
        onCreate(db);
    }

}
