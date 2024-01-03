package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class UsersMeetingsView extends AppCompatActivity {
    public static ArrayList<Meetings> meetingsLst = new ArrayList<>();
    DBHandler dbHandler;
    ListView lstView;
    UsersSessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_meetings_view);
        dbHandler = new DBHandler(this);
        lstView = findViewById(R.id.lstViewUser);
        sessionManager = new UsersSessionManager(this);
        setupData();
        setupListView();
    }

    private void setupData(){
        meetingsLst = dbHandler.getMeetingsForParticipants(sessionManager.getUserId());
    }

    private void setupListView(){
        UserMeetingsItemAdapter adapter = new UserMeetingsItemAdapter(getApplicationContext(),0,meetingsLst);
        lstView.setAdapter(adapter);
    }
}