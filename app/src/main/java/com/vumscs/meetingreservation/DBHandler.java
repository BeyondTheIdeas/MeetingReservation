package com.vumscs.meetingreservation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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

    public void CreateMeeting(Meetings meetings, SQLiteDatabase db)
    {
        String query = "insert into "+meetingsTable + "(title, description, Date_Time, Status, created_by, created_date) "+
                        "values('"+meetings.getTitle()+"', '"+meetings.getTitle()+"', '"+meetings.getDateTime() + "', '"+meetings.getStatus() + "', '"+meetings.getCreatedBy() +"', datetime())";
        db.execSQL(query);
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

    public ArrayList<Meetings> getAllMeetings(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Meetings> meetimgList = new ArrayList<Meetings>();
        String[] projection = {
                "meeting_id",
                "title",
                "Date_Time"
        };
        Cursor cursor = null;
        try{
            cursor = db.query(meetingsTable, projection,null,null,null,null,"meeting_id");
            if(cursor.moveToFirst()){
                do{
                    meetimgList.add(new Meetings(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
                }
                while (cursor.moveToNext());
            }
            cursor.close();

        }
        catch (SQLException ex){
            throw ex;
        }
        return meetimgList;
    }

    public ArrayList<Participants> getAllParticipants(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor pc = db.rawQuery("SELECT * FROM "+usersTable,null);
        ArrayList<Participants> participantsArrayList = new ArrayList<>();
        if(pc.moveToFirst()){
            do{
                participantsArrayList.add(new Participants(pc.getString(0),pc.getString(1),pc.getString(2),false));


            }while (pc.moveToNext());
        }
        pc.close();
        return participantsArrayList;
    }

    public long addMeetingDetails(int meetingId, ArrayList<Participants> participants){
        long rowId = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        db.beginTransaction();
        try {
            for (Participants par : participants) {
                values.put("meeting_id", meetingId);
                values.put("user_id", par.id);
                rowId = db.insert(meetingDesctable, null, values);
            }
            db.setTransactionSuccessful();
        }
        finally {
            db.endTransaction();

        }
        return rowId;

    }

    /*public int getMaxMeetingId(){
        int meetingId = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select max(meeting_id) maxId from "+ meetingsTable;
        Cursor c = db.rawQuery(query,null);

    }*/

    DBHandler(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }
}
