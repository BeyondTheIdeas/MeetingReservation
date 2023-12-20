package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPage extends AppCompatActivity {
    Button btnManager, btnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        btnManager = findViewById(R.id.btnManager);
        btnUser = findViewById(R.id.btnUser);
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runActivity("U");

            }
        });

        btnManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runActivity("M");

            }
        });


    }

    private void runActivity(String type)
    {
        Intent intent = null;
        if(type == "M")
        {
            intent = new Intent(LandingPage.this, ManagerLogin.class);
        }
        else if(type == "U")
        {
            intent = new Intent(LandingPage.this, UserLogin.class);
        }
        startActivity(intent);
    }
}