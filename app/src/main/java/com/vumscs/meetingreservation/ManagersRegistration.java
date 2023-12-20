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
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ManagersRegistration extends AppCompatActivity {
    private EditText emailText, passwordText, userNameText, phoneText;
    private Button btnRegister;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managers_registration);
        userNameText = findViewById(R.id.editTextUsername);
        emailText = findViewById(R.id.editTextEmail);
        phoneText = findViewById(R.id.editTextPhone);
        passwordText = findViewById(R.id.editTextPassword);
        btnRegister = findViewById(R.id.btnRegManager);
        dbHandler = new DBHandler(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerManager();
            }
        });
    }

    private void registerManager()
    {
        String userName = userNameText.getText().toString();
        String email = emailText.getText().toString();
        String phone = phoneText.getText().toString();
        String password = passwordText.getText().toString();

        if(userName.isEmpty())
        {
            Toast.makeText(this, "Please enter User Name", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(email.isEmpty())
        {
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        else  if(phone.isEmpty())
        {
            Toast.makeText(this, "Please enter Phone No.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(password.isEmpty())
        {
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME",userName);
        values.put("EMAIL",email);
        values.put("PHONE",phone);
        values.put("PASSWORD",password);
       try{
            long rowId = db.insert("manager",null,values);
            if(rowId !=-1)
            {
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
                // Redirect to the login activity or other appropriate action
                startActivity(new Intent(this, ManagerLogin.class));
                //finish();
            }
            else
            {
                Toast.makeText(this, "Registration failed.", Toast.LENGTH_SHORT).show();
            }
       }
       catch (SQLException ex)
       {
           Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
       }
       finally {
           db.close();
       }
    }
}
