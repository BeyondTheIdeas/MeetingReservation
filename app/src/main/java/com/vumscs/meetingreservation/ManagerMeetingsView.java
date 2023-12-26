package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ManagerMeetingsView extends AppCompatActivity {
    public static ArrayList<Meetings> meetingList = new ArrayList<Meetings>();
    DBHandler dbHandler;
    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_meetings_view);
        dbHandler = new DBHandler(this);
        lstView = findViewById(R.id.lstViewManager);
        setupData();
        setupListView();
    }

    public void setupData(){
        meetingList = dbHandler.getAllMeetings();
    }

    public void setupListView(){
        //lstView = (ListView) findViewById(R.id.lstViewManager);
        MeetingsItemsAdapter adapter = new MeetingsItemsAdapter(getApplicationContext(), 0, meetingList);
        lstView.setAdapter(adapter);
    }
}