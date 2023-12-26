package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectParticipantsForMeeting extends AppCompatActivity {
    ListView lstView;
    NewParticipantAdapter participantsAdapter;
    DBHandler dbHandler;
    ArrayList<Participants> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_participants_for_meeting);
        lstView = findViewById(R.id.lstParticipants);
        dbHandler = new DBHandler(this);
        arrayList = dbHandler.getAllParticipants();
        participantsAdapter = new NewParticipantAdapter(arrayList,SelectParticipantsForMeeting.this);
        lstView.setAdapter(participantsAdapter);
    }
}