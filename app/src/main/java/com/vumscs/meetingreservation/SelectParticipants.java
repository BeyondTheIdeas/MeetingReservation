package com.vumscs.meetingreservation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SelectParticipants extends AppCompatActivity {
    private RecyclerView recyclerViewParticipants;
    private List<Participants> participantList;
    private ParticipantsAdapter participantAdapter;
    private Button buttonAddParticipants;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_participants);

        recyclerViewParticipants = findViewById(R.id.recyclerViewParticipants);
        buttonAddParticipants = findViewById(R.id.buttonAddParticipants);
        dbHandler = new DBHandler(this);
        participantList = dbHandler.getAllParticipants();
        participantAdapter = new ParticipantsAdapter(participantList,SelectParticipants.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SelectParticipants.this,RecyclerView.VERTICAL,false);
        recyclerViewParticipants.setLayoutManager(linearLayoutManager);

        recyclerViewParticipants.setAdapter(participantAdapter);
        /*participantList.add(new Participants("1","Participant 1", "participant1@example.com", false));
        participantList.add(new Participants("2","Participant 2", "participant2@example.com", false));
        // Add more participants as needed

        participantAdapter = new ParticipantsAdapter(participantList);
        recyclerViewParticipants.setLayoutManager(new LinearLayoutManager(this));
        //recyclerViewParticipants.setAdapter(participantAdapter);

        ArrayAdapter<Participants> adapter = new ArrayAdapter<>(this, R.layout.activity_meetings_item,participantList);
        //recyclerViewParticipants.setAdapter(adapter);*/

        buttonAddParticipants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Participants> selectedParticipants = new ArrayList<>();
                for (Participants participant : participantList) {
                    if (participant.isSelected()) {
                        selectedParticipants.add(participant);
                    }
                }
                // Handle adding selected participants to the meeting
            }
        });
    }
}
