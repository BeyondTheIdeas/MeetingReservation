package com.vumscs.meetingreservation;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MeetingsView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ManagerMeetingsAdapter adapter;
    private ManagerMeetingsViewDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataSource = new ManagerMeetingsViewDataSource(this);
        dataSource.open();
        List<Meetings> meetings = dataSource.getAllMeetings();
        adapter = new ManagerMeetingsAdapter(meetings);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }
}
