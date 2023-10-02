package com.vumscs.meetingreservation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ManagerMeetingsViewDataSource {
    private SQLiteDatabase db;
    private DBHandler dbHandler;

    public ManagerMeetingsViewDataSource(Context context){
        dbHandler = new DBHandler(context);
    }

    public void open() throws SQLException{
        db = dbHandler.getReadableDatabase();
    }

    public void close() {
        dbHandler.close();
    }

    public List<Meetings> getAllMeetings(){
        List<Meetings> meetings = new ArrayList<>();
        String query = "select meeting_id, title, date_time, status from "+
                        "meeting where status in ('U','O')";
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Meetings meetings1 = cursorToMeetings(cursor);
            meetings.add(meetings1);
            cursor.moveToNext();
        }
        cursor.close();
        return meetings;
    }

    private Meetings cursorToMeetings(Cursor cursor)
    {
        Meetings meetings = new Meetings();
        meetings.setId(cursor.getString(0));
        meetings.setTitle(cursor.getString(1));
        meetings.setDate(cursor.getString(2));
        meetings.setStatus(cursor.getString(3));
        return meetings;

    }

}
