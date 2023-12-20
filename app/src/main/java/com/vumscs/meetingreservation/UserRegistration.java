package com.vumscs.meetingreservation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class UserRegistration extends AppCompatActivity {

    private EditText edUserName, edPhone, edPassword, edEmail;
    private Button btnRegistration, btnLogin;
    private DBHandler dbHandler;
    //Toolbar toolbar;

    //@Override
   /*public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        edUserName = findViewById(R.id.editTextUsername);
        edPassword = findViewById(R.id.editTextPassword);
        edPhone = findViewById(R.id.editTextPhone);
        edEmail = findViewById(R.id.editTextEmail);
        btnRegistration = findViewById(R.id.btnRegUser);
        btnLogin  = findViewById(R.id.btnLoginUser);
        dbHandler = new DBHandler(this);
        //toolbar = findViewById(R.id.toolbar);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

            }
        });
    }

    private void login(){
        Intent intent = new Intent(UserRegistration.this, UserLogin.class);
        startActivity(intent);
    }

    private  void registerUser()
    {
        String userName = edUserName.getText().toString();
        String phone = edPhone.getText().toString();
        String password = edPassword.getText().toString();
        String email = edEmail.getText().toString();

        if(userName.isEmpty())
        {
            Toast.makeText(this, "Please enter User Name", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(phone.isEmpty())
        {
            Toast.makeText(this, "Please enter Phone No.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(password.isEmpty())
        {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(email.isEmpty())
        {
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME",userName);
        values.put("EMAIL",email);
        values.put("PHONE",phone);
        values.put("PASSWORD",password);

        try
        {
            long rowId = db.insert("user",null,values);
            if(rowId !=-1)
            {
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
                // Redirect to the login activity or other appropriate action
                //startActivity(new Intent(this, UserLogin.class));
                Intent intent = new Intent(UserRegistration.this, UserLogin.class);
                startActivity(intent);
                //finish();
            }
            else
            {
                Toast.makeText(this, "Registration failed.", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
