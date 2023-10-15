package com.vumscs.meetingreservation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static  String DB_NAME = "coursedb";

    // below int is our database version
    private static  int DB_VERSION = 1;

    private static     String usersTable = "user";
    private static     String managersTable = "manager";
    private static     String meetingsTable = "meeting";
    private static     String meetingDesctable = "meeting_desc";
    private static     String meetingActivityTable = "meeting_activity";
    private static     String feedbacksTable = "feedback";


    @Override
    public void onCreate(SQLiteDatabase db) {
        String userTable = "create table "+ usersTable + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        "NAME TEXT, EMAIL TEXT, PHONE TEXT, PASSWORD TEXT)";
        String managerTable = "create table "+managersTable+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                "NAME TEXT, EMAIL TEXT, PHONE TEXT, PASSWORD TEXT)";
        String meetingTable = "create table "+meetingsTable+"(meeting_id integer PRIMARY KEY AUTOINCREMENT, "+
                                "title TEXT, description TEXT, Date_Time DateTime, "+
                                "Status TEXT, created_by integer, created_date date) ";
        String meetingDesTable = "create table "+meetingDesctable+"(meeting_id INTEGER, user_id integer)";
        String meetingActivity = "create table "+ meetingActivityTable+"(meeting_id INTEGER, user_id INTEGER, "+
                                    "status TEXT, activity_date DATE)";
        String feedbackTable = "create table "+feedbacksTable+"(feedback_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                "comments TEXT, meeting_id integer, user_id integer) ";
        db.execSQL(userTable);
        db.execSQL(managerTable);
        db.execSQL(meetingDesTable);
        db.execSQL(meetingTable);
        db.execSQL(meetingActivity);
        db.execSQL(feedbackTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dropStatement = "DROP TABLE IF EXIST ";
        String userDrop = dropStatement + usersTable;
        String managerDrop = dropStatement + managersTable;
        String meetingDrop = dropStatement + meetingsTable;
        String meetingDescDrop = dropStatement + meetingDesctable;
        String feedbackDrop = dropStatement + feedbacksTable;

        db.execSQL(userDrop);
        db.execSQL(managerDrop);
        db.execSQL(meetingDrop);
        db.execSQL(meetingDescDrop);
        db.execSQL(feedbackDrop);
    }

    DBHandler(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }
}
