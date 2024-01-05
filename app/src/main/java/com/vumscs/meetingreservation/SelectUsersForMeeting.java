package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SelectUsersForMeeting extends AppCompatActivity {
    ListView lstView;
    ArrayList<Participants> lstParticipants = new ArrayList<>();
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_users_for_meeting);
        lstView = findViewById(R.id.lstSelectUsers);
        dbHandler = new DBHandler(this);
        setupData();
        setupView();
    }

    private void setupData(){
        lstParticipants = dbHandler.getAllParticipants();
    }

    private void setupView(){
        SelectUsersForMeetingAdapter adapter = new SelectUsersForMeetingAdapter(this,0,lstParticipants);
        lstView.setAdapter(adapter);
    }
}