package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MeetingsDetail extends AppCompatActivity {
    private RecyclerView recyclerViewParticipants;
    private List<Participants> participantList;
    private ParticipantsAdapter participantAdapter;
    private Button buttonAddParticipants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings_detail);

        recyclerViewParticipants = findViewById(R.id.recyclerViewParticipants);
        buttonAddParticipants = findViewById(R.id.buttonAddParticipants);
        participantList = new ArrayList<>();
        participantList.add(new Participants("1","Participant 1", "participant1@example.com", false));
        participantList.add(new Participants("2","Participant 2", "participant2@example.com", false));

        participantAdapter = new ParticipantsAdapter(participantList);
        recyclerViewParticipants.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewParticipants.setAdapter(participantAdapter);
    }
}
