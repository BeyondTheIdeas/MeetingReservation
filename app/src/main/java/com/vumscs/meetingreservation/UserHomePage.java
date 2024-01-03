package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class UserHomePage extends AppCompatActivity {
    Button btnViewMeetings, btnLogout;
    UsersSessionManager sessionManager;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);
        btnViewMeetings = findViewById(R.id.btnViewUserMeetingPage);
        btnLogout = findViewById(R.id.btnUserLogout);
        sessionManager = new UsersSessionManager(this);
        userId = sessionManager.getUserId();
        //Toast.makeText(this,userId,Toast.LENGTH_LONG);
        btnViewMeetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnButtonClick("V");
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnButtonClick("L");
            }
        });
    }

    private void OnButtonClick(String type){
        Intent intent = new Intent();
        if(type == "V"){
            intent = new Intent(UserHomePage.this, UsersMeetingsView.class);
        }
        else if(type == "L"){
            sessionManager.clearSession();
            intent = new Intent(UserHomePage.this, LandingPage.class);
        }
        startActivity(intent);
    }
}