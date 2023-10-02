package com.vumscs.meetingreservation;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UserLogin extends AppCompatActivity {

    EditText edEmail, edPassword;
    Button btnLogin;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        dbHandler = new DBHandler(this);
        edEmail = findViewById(R.id.emailEditText);
        edPassword = findViewById(R.id.passwordEditText);
        btnLogin.findViewById(R.id.loginButton);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();

            }
        });
    }

    private void loginUser()
    {
        String userName = edEmail.getText().toString();
        String password = edPassword.getText().toString();
        if(userName.isEmpty())
        {
            Toast.makeText(this, "Please enter User Name.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(password.isEmpty())
        {
            Toast.makeText(this, "Please enter Password.", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String[] projection = {
                "ID",
                "NAME",
                "PASSWORD"
        };
        String selection = "NAME = ? AND PASSWORD = ?";
        String[] selectionArgs = {userName, password};
        Cursor cursor = null;
        try
        {
            cursor = db.query("user",
                                    projection,
                                    selection,
                                    selectionArgs,
                                null, null, null);
            if(cursor != null && cursor.getCount() >0)
            {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
                finish();
            }
            else {
                Toast.makeText(this, "Invalid username or password.", Toast.LENGTH_SHORT).show();
            }
        }
        catch (SQLException s)
        {
            Toast.makeText(this, "Error: " + s.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            if(cursor!=null)
            {
                cursor.close();
            }
            db.close();
        }
    }
}
