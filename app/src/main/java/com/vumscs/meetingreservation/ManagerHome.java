package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Console;

public class ManagerHome extends AppCompatActivity {
    Button btnAddMeeting, btnViewMeeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home);

        btnAddMeeting = findViewById(R.id.btnAddMeetingPage);
        btnViewMeeting = findViewById(R.id.btnViewMeetingPage);
        btnAddMeeting.setOnClickListener(v -> newActivity("N"));
        btnViewMeeting.setOnClickListener(v -> newActivity("V"));
    }

    private void newActivity(String type){
        Intent intent = null;
        if(type == "N"){
            intent = new Intent(ManagerHome.this,NewMeeting.class);
        }
        else{
            intent = new Intent(ManagerHome.this, ManagerMeetingsView.class);
        }
        startActivity(intent);
    }
}