package com.test.ghiny.timetracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GhinY on 04/05/2016.
 */
public class TimeListDatabaseHelper {
    //Define not accessible constant
    private static final int DATABASE_VERSION   = 3;
    private static final String DATABASE_NAME   = "timetracker.db";
    private static final String TABLE_NAME      = "timerecords";
    
    //Define constant like #define TIMETRACKER_COLUMN_ID  "_id" in C
    public static final String TIMETRACKER_COLUMN_ID = "_id";
    public static final String TIMETRACKER_COLUMN_TIME = "time";
    public static final String TIMETRACKER_COLUMN_NOTE = "notes";
    
    //openHelper to create a database by getWritableDatabase() method
    private TimeTrackerOpenHelper openHelper;
    private SQLiteDatabase database;

    public TimeListDatabaseHelper(Context context){
        openHelper  = new TimeTrackerOpenHelper(context);
        database    = openHelper.getWritableDatabase();
    }

    public void saveTimeRecord(String time, String notes){
        database.execSQL("INSERT INTO " + TABLE_NAME + " ("
                + TIMETRACKER_COLUMN_TIME + ", "
                + TIMETRACKER_COLUMN_NOTE + ")"
                + " VALUES ('"
                + time + "', '" + notes + "')");
    }
    //INSERT INTO TIMERECORDS (TIME, NOTES) 
    //VALUES ('time', 'notes');             -----in SQLite

    public Cursor getAllTimeRecords(){
        return database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    //**********************INTERNAL CLASS***************************
    private class TimeTrackerOpenHelper extends SQLiteOpenHelper{

        TimeTrackerOpenHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        public void onCreate(SQLiteDatabase database){
            database.execSQL("CREATE TABLE " + TABLE_NAME + "( "
                    + TIMETRACKER_COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + TIMETRACKER_COLUMN_TIME + " TEXT, "
                    + TIMETRACKER_COLUMN_NOTE + " TEXT )");
        }
        //CREATE TABLE "timerecords"(
        //"id" INTEGER PRIMARY KEY, 
        //"time" TEXT, "notes" TEXT
        //);                                  ------ in SQLite

        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
            database.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
            onCreate(database);
        }
        //DROP TABLE IF EXIST "timerecords";  ------ in SQLite
    }
    //*********************END OF INTERNAL CLASS*********************

}
