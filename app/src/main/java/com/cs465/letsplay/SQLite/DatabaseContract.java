package com.cs465.letsplay.SQLite;


import android.provider.BaseColumns;
/**
 * Created by Piyush on 4/29/2015.
 */
public class DatabaseContract
{

    public static final  int    DATABASE_VERSION = 4;
    public static final  String DATABASE_NAME = "letsplay.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REAL_TYPE = " REAL";
    private static final String COMMA_SEP = ",";

    public DatabaseContract() {
    }

    /** Represents a User table */
    public static abstract class UserTable implements BaseColumns
    {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_USERNAME = "userName";
        public static final String COLUMN_NAME_USERID = "userId";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_GENDER = "sex";
        public static final String COLUMN_NAME_AGE = "age";
        public static final String COLUMN_NAME_PHONE_NUM = "phonenumber";
        public static final String COLUMN_NAME_TENNIS = "tennis";
        public static final String COLUMN_NAME_SOCCER = "soccer";
        public static final String COLUMN_NAME_FOOTBALL = "football";
        public static final String COLUMN_NAME_BASEBALL = "baseball";
        public static final String COLUMN_NAME_PINGPONG = "pingpong";
        //public static final String COLUMN_NAME_SNOOKER = "snooker";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_USERNAME + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_USERID + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_ADDRESS + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_GENDER + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_AGE + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_PHONE_NUM + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_TENNIS + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_SOCCER + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_FOOTBALL + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_BASEBALL + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_PINGPONG + TEXT_TYPE + COMMA_SEP +");";
                //COLUMN_NAME_SNOOKER + TEXT_TYPE +");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /** Represents a Friends table */
    public static abstract class FriendsTable implements BaseColumns
    {
        public static final String TABLE_NAME = "friends";
        public static final String COLUMN_NAME_FRIENDNAME = "friendName";
        public static final String COLUMN_NAME_FRIENDID = "friendId";
        public static final String COLUMN_NAME_SPORTSID = "sportsId";
        public static final String COLUMN_NAME_SPORTSNAME = "sportsName";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_FRIENDNAME + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_FRIENDID + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_SPORTSID + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_SPORTSNAME + TEXT_TYPE + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /** Represents a Sports table */
    public static abstract class SportsTable implements BaseColumns
    {
        public static final String TABLE_NAME = "sports";
        public static final String COLUMN_NAME_SPORTSNAME = "sportsName";
        public static final String COLUMN_NAME_SPORTSID = "sportsId";
        public static final String COLUMN_NAME_SPORTSTYPE = "sportType"; // 0 is Outdoor, 1 is indoor

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_SPORTSNAME + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_SPORTSID + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_SPORTSTYPE + TEXT_TYPE +");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /** Represents a Event table */
    public static abstract class EventTable implements BaseColumns
    {
        public static final String TABLE_NAME = "events";
        public static final String COLUMN_NAME_EVENTNAME = "eventName";
        public static final String COLUMN_NAME_EVENTID = "eventId";
        public static final String COLUMN_NAME_EVENTDETAILS = "eventdtl";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME_EVENTNAME + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_EVENTID + TEXT_TYPE + COMMA_SEP +
                COLUMN_NAME_EVENTDETAILS + TEXT_TYPE + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}
