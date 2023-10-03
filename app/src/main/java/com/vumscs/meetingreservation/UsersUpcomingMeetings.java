package com.vumscs.meetingreservation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class UsersUpcomingMeetings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_upcoming_meetings);
    }

    private class UserUpcomingMeetingViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView, dateTextView;
        Button acceptButton, rejectButton;

        public UserUpcomingMeetingViewHolder(@NonNull View itemView) {
            super(itemView);
           /* titleTextView = itemView.findViewById(R.id.titleTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            acceptButton = itemView.findViewById(R.id.acceptButton);
            rejectButton = itemView.findViewById(R.id.rejectButton); */
        }
    }
}
