package com.vumscs.meetingreservation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MeetingsAdapter {
    private List<Meetings> meetingList;

    public MeetingsAdapter(List<Meetings> meetingList)
    {
        this.meetingList = meetingList;
    }


}

