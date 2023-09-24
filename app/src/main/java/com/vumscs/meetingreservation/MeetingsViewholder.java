package com.vumscs.meetingreservation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MeetingsViewholder extends RecyclerView.ViewHolder {

    public TextView txtTitle;
    public TextView txtDate;
    public TextView txtTime;
    public TextView txtCreatedBy;
    public List<Participants> lstParticipants;

    public MeetingsViewholder(@NonNull View itemView) {
        super(itemView);
    }
}
