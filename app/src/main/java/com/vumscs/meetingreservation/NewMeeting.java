package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import java.util.Calendar;

public class NewMeeting extends AppCompatActivity {
    EditText edTitle, edDescription, edDateTime, edTime;
    Button btnCreateMeeting, btnSelDate, btnSelTime;
    Meetings meetings;
    DBHandler dbHandler;
    private int mYear, mMonth, mDay, mHour, mMinute;
    NotificationManager notificationManager;
    NotificationChannel notificationChannel;
    Notification.Builder builder;
    private String channelId = "i.apps.notifications";

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
        //notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

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
                Intent intent = new Intent(NewMeeting.this, SelectUsersForMeeting.class);
                startActivity(intent);
                //long dt = dbHandler.addMeetingDetails()
                //long dt = dbHandler.addMeetingDetails((int)insert,dbHandler.getAllParticipants());
                /*if(dt>0){
                   // addNotification();

                    Intent i = new Intent(NewMeeting.this, ManagerHome.class);
                    //var pendingIntent = PendingIntent.getActivities(this,0, new Intent[]{i},PendingIntent.FLAG_UPDATE_CURRENT);
                    var contentViews = new RemoteViews(getPackageName(),R.layout.activity_manager_home);
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                        notificationChannel = new NotificationChannel(channelId,"New Meeting",NotificationManager.IMPORTANCE_HIGH);
                        notificationChannel.enableLights(true);
                        //notificationChannel.setLightColor();
                        notificationChannel.enableVibration(true);
                        notificationManager.createNotificationChannel(notificationChannel);
                        builder = new Notification.Builder(this,channelId).setContent(contentViews)
                                .setSmallIcon(R.drawable.ic_launcher_background)
                                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_background));
                                //.setContentIntent(pendingIntent);
                        Toast.makeText(this,"Meeting Created",Toast.LENGTH_LONG).show();
                    }
                    else{
                        builder = new Notification.Builder(this).setContent(contentViews)
                                .setSmallIcon(R.drawable.ic_launcher_background)
                                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_background));
                               // .setContentIntent(pendingIntent);
                        Toast.makeText(this,"Meeting Created",Toast.LENGTH_LONG).show();
                    }*/

                    // i.putExtra("mid",insert);
                    //startActivity(i);
                }

                else {
                    Toast.makeText(this,"Unable to Create Meeting",Toast.LENGTH_LONG).show();
                }

            //}
            /*else {
                Toast.makeText(this,"Unable to Create Meeting",Toast.LENGTH_LONG).show();
            }*/
            //notificationManager.notify(1234,builder.build());
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

    private void addNotification(){
        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Meeting Created")
                .setContentText("New Meeting Created Successfully")
                .setChannelId(channelId);

        var contentViews = new RemoteViews(getPackageName(),R.layout.activity_manager_home);
        //Intent intent = new Intent(this, ManagerMeetingsView.class);
        //PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder1.setContent(contentViews);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder1.build());
    }


}