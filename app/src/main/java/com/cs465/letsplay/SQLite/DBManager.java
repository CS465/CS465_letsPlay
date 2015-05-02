package com.cs465.letsplay.SQLite;


import android.database.sqlite.SQLiteDatabase;
import android.database.*;
import android.content.*;
import android.util.Log;

import com.cs465.letsplay.Entities.Friends;
import com.cs465.letsplay.Entities.Sports;
import com.cs465.letsplay.Entities.User;
import com.cs465.letsplay.Entities.Events;

/**
 * Created by Piyush on 4/29/2015.
 */
public class DBManager
{
// this class should be called to communicate with the database

    private DBHelper dbHelper = null;
    private SQLiteDatabase db = null;

    public DBManager(Context context)
    {
        dbHelper = new DBHelper(context);
    }

    public User getUserInfo()
    {
        db = dbHelper.getReadableDatabase();

        User user = new User();

        // Define a projection that specifies which columns from the database
        String[] columns = { DatabaseContract.UserTable._ID,
                DatabaseContract.UserTable.COLUMN_NAME_USERNAME,
                DatabaseContract.UserTable.COLUMN_NAME_USERID, };
        Cursor c = queryDatabase(DatabaseContract.UserTable.TABLE_NAME, columns, null, null,
                null, null, null);
        if( c != null && c.moveToFirst())
        {
            Log.i("getUserInfo -->", " exist");

            user.setUserId(c.getString(c
                    .getColumnIndexOrThrow(DatabaseContract.UserTable.COLUMN_NAME_USERID)));
            user.setUsername(c.getString(c
                    .getColumnIndexOrThrow(DatabaseContract.UserTable.COLUMN_NAME_USERNAME)));
        }
        db.close();
        return user;
    }

    public Friends getFriends()
    {
        db = dbHelper.getReadableDatabase();

        Friends f = new Friends();

        // Define a projection that specifies which columns from the database
        String[] columns = { DatabaseContract.FriendsTable._ID,
                DatabaseContract.FriendsTable.COLUMN_NAME_FRIENDNAME,
                DatabaseContract.FriendsTable.COLUMN_NAME_FRIENDID, };
        Cursor c = queryDatabase(DatabaseContract.FriendsTable.TABLE_NAME, columns, null, null,
                null, null, null);
        if( c != null && c.moveToFirst())
        {
            Log.i("getUserInfo -->", " exist");

            f.setFriendId(c.getInt(c
                    .getColumnIndexOrThrow(DatabaseContract.FriendsTable.COLUMN_NAME_FRIENDID)));
            f.setFriendName(c.getString(c
                    .getColumnIndexOrThrow(DatabaseContract.FriendsTable.COLUMN_NAME_FRIENDNAME)));
        }
        db.close();
        return f;
    }

    public Sports getSports()
    {
        db = dbHelper.getReadableDatabase();

        Sports sports = new Sports();

        // Define a projection that specifies which columns from the database
        String[] columns = { DatabaseContract.SportsTable._ID,
                DatabaseContract.SportsTable.COLUMN_NAME_SPORTSNAME,
                DatabaseContract.SportsTable.COLUMN_NAME_SPORTSID,
        };
        Cursor c = queryDatabase(DatabaseContract.SportsTable.TABLE_NAME, columns, null, null,
                null, null, null);
        if( c != null && c.moveToFirst())
        {
            Log.i("getUserInfo -->", " exist");

            sports.setSportsId(c.getInt(c
                    .getColumnIndexOrThrow(DatabaseContract.SportsTable.COLUMN_NAME_SPORTSID)));
            sports.setSportsName(c.getString(c
                    .getColumnIndexOrThrow(DatabaseContract.SportsTable.COLUMN_NAME_SPORTSNAME)));
        }
        db.close();
        return sports;
    }

    // create or update a user.
    public void createUser(String name, String userId)
    {
        try {
            //db = dbHelper.getWritableDatabase();
            db = dbHelper.getReadableDatabase();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        // Define a projection that specifies which columns from the database
        String[] columns = { DatabaseContract.UserTable.COLUMN_NAME_USERNAME, };

        Cursor c = queryDatabase(DatabaseContract.UserTable.TABLE_NAME, columns, null, null,
                null, null, null);
        // check for the existence, if exists, update the user name
        if( c != null && c.moveToFirst() )
        {
            db = dbHelper.getWritableDatabase();
            Log.i("update User -->"," update");
            ContentValues values = new ContentValues();
            values.put(DatabaseContract.UserTable.COLUMN_NAME_USERNAME, name);
            db.update(DatabaseContract.UserTable.TABLE_NAME, values, null, null);
            db.close();
        }
        else
        {
            db = dbHelper.getWritableDatabase();
            Log.i("update User -->"," Insert");
            ContentValues values = new ContentValues();
            values.put(DatabaseContract.UserTable.COLUMN_NAME_USERNAME, name);
            // only insert the android device id if the it doesn't exist in the DB
            values.put(DatabaseContract.UserTable.COLUMN_NAME_USERID, userId);
            db.insert(DatabaseContract.UserTable.TABLE_NAME, null, values);
            db.close();
        }
    }

    //Method: updateUser. When user edits his/her profile, call should reach here.
    // create or update a user.
    public void updateUser(String name, String age, String baseball, String football, String pingpong,
                           String gender, String phone, String soccer, String tennis, String address)
    {
        try
        {
            db = dbHelper.getReadableDatabase();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        // Define a projection that specifies which columns from the database
        String[] columns = { DatabaseContract.UserTable.COLUMN_NAME_USERNAME, DatabaseContract.UserTable.COLUMN_NAME_ADDRESS,
                DatabaseContract.UserTable.COLUMN_NAME_AGE,
                DatabaseContract.UserTable.COLUMN_NAME_BASEBALL,
                DatabaseContract.UserTable.COLUMN_NAME_FOOTBALL,
                DatabaseContract.UserTable.COLUMN_NAME_GENDER,
                DatabaseContract.UserTable.COLUMN_NAME_PHONE_NUM,
                DatabaseContract.UserTable.COLUMN_NAME_PINGPONG,
                DatabaseContract.UserTable.COLUMN_NAME_SOCCER,
                DatabaseContract.UserTable.COLUMN_NAME_TENNIS,};

        Cursor c = queryDatabase(DatabaseContract.UserTable.TABLE_NAME, columns, null, null,
                null, null, null);
        // check for the existence, if exists, update the user name
        if( c != null && c.moveToFirst() )
        {
            db = dbHelper.getWritableDatabase();
            Log.i("update User -->"," update");
            ContentValues values = new ContentValues();

            // Commit only the changed values. Check for null strings too.
            if(name!=null)
                values.put(DatabaseContract.UserTable.COLUMN_NAME_USERNAME, name);
            if(address!=null)
                values.put(DatabaseContract.UserTable.COLUMN_NAME_ADDRESS, address);
            if(age!=null)
                values.put(DatabaseContract.UserTable.COLUMN_NAME_AGE, age);
            if(gender!=null)
                values.put(DatabaseContract.UserTable.COLUMN_NAME_GENDER, gender);
            if(tennis!=null)
                values.put(DatabaseContract.UserTable.COLUMN_NAME_TENNIS, tennis);
            if(football!=null)
                values.put(DatabaseContract.UserTable.COLUMN_NAME_FOOTBALL, football);
            if(baseball!=null)
                values.put(DatabaseContract.UserTable.COLUMN_NAME_BASEBALL, baseball);
            if(pingpong!=null)
                values.put(DatabaseContract.UserTable.COLUMN_NAME_USERNAME, pingpong);
            if(phone!=null)
                values.put(DatabaseContract.UserTable.COLUMN_NAME_PHONE_NUM, phone);

            db.update(DatabaseContract.UserTable.TABLE_NAME, values, null, null);
            db.close();
        }
    }

    private Cursor queryDatabase(String tableName, String[] columns,
                                 String selection, String[] selectionArgs, String groupBy,
                                 String having, String orderBy)
    {
        Cursor c = db.query(tableName, // The table to query
                columns, // The columns to return
                selection, // The columns for the WHERE clause
                selectionArgs, // The values for the WHERE clause
                groupBy, // don't group the rows
                having, // don't filter by row groups
                orderBy // The sort order
        );

        return c;
    }

}
