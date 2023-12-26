package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import java.util.Calendar;

public class NewMeeting extends AppCompatActivity {
    EditText edTitle, edDescription, edDateTime, edTime;
    Button btnCreateMeeting, btnSelDate, btnSelTime;
    Meetings meetings;
    DBHandler dbHandler;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meeting);
        edTitle = findViewById(R.id.etTitle);
        edDescription = findViewById(R.id.etDescription);
        edDateTime = findViewById(R.id.etMeetingDate);
        btnCreateMeeting = findViewById(R.id.btnCreateMeeting);
        btnSelDate = findViewById(R.id.btnSelDate);
        edTime = findViewById(R.id.etMeetingTime);
        btnSelTime = findViewById(R.id.btnSelTime);
        dbHandler = new DBHandler(this);

        btnCreateMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                meetings = new Meetings();
                meetings.setDate(edDateTime.getText().toString());
                meetings.setTime(edTime.getText().toString());
                meetings.setTitle(edTitle.getText().toString());
                meetings.setDescription(edDescription.getText().toString());
                //meetings.getDateTime()
                addMeeting(meetings);
            }
        });

        btnSelDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        btnSelTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });


    }


    private void addMeeting(Meetings meetings){
        long insert = 0;
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", meetings.getTitle());
        values.put("description", meetings.getDescription());
        values.put("Date_Time",meetings.getDateTime());
        try {
            insert = db.insert("meeting",null,values);
            if(insert>0){
                //long dt = dbHandler.addMeetingDetails()
                long dt = dbHandler.addMeetingDetails((int)insert,dbHandler.getAllParticipants());
                if(dt>0){
                    Toast.makeText(this,"Meeting Created",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(NewMeeting.this, ManagerHome.class);
                    // i.putExtra("mid",insert);
                    startActivity(i);
                }
                else {
                    Toast.makeText(this,"Unable to Create Meeting",Toast.LENGTH_LONG).show();
                }

            }
            else {
                Toast.makeText(this,"Unable to Create Meeting",Toast.LENGTH_LONG).show();
            }
        }
        catch (SQLException ex)
        {

        }

    }

    private void showDatePicker(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edDateTime.setText(dayOfMonth+"-"+(month+1)+"-"+year);
            }
        },mYear,mMonth,mDay);
        datePickerDialog.show();
    }

    private void showTimePicker(){
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                edTime.setText(hourOfDay+":"+minute);

            }
        },mHour,mMinute,false);
        timePickerDialog.show();
    }


}