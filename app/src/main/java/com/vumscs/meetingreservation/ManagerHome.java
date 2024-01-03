package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Console;

public class ManagerHome extends AppCompatActivity {
    Button btnAddMeeting, btnViewMeeting, btnLogOut;
    ManagersSessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home);

        sessionManager = new ManagersSessionManager(this);
        btnAddMeeting = findViewById(R.id.btnAddMeetingPage);
        btnViewMeeting = findViewById(R.id.btnViewMeetingPage);
        btnLogOut = findViewById(R.id.btnLogoutManager);
        btnAddMeeting.setOnClickListener(v -> newActivity("N"));
        btnViewMeeting.setOnClickListener(v -> newActivity("V"));
        btnLogOut.setOnClickListener(v-> newActivity("L"));
    }

    private void newActivity(String type){
        Intent intent = null;
        if(type == "N"){
            intent = new Intent(ManagerHome.this,NewMeeting.class);
        }
        else if(type == "V"){
            intent = new Intent(ManagerHome.this, ManagerMeetingsView.class);
        }
        else if(type == "L"){
            sessionManager.clearSession();
            intent = new Intent(ManagerHome.this, LandingPage.class);

        }
        startActivity(intent);
    }
}