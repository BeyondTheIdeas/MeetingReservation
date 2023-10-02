package com.vumscs.meetingreservation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ManagerMeetingsAdapter extends RecyclerView.Adapter<ManagerMeetingsAdapter.ManagerMeetingsViewHolder> {
    private List<Meetings> meetings;

    public ManagerMeetingsAdapter(List<Meetings> meetings) {
        this.meetings = meetings;
    }

    @NonNull
    @Override
    public ManagerMeetingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_manager_meetings_view_item, parent, false);
        return new ManagerMeetingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ManagerMeetingsViewHolder holder, int position) {
        Meetings meeting = meetings.get(position);
        holder.textTitle.setText(meeting.getTitle());
        holder.textDateTime.setText(meeting.getDateTime());
        holder.textStatus.setText(meeting.getStatus());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ManagerMeetingsViewHolder extends RecyclerView.ViewHolder{
        public TextView textTitle, textDateTime, textStatus;

        public ManagerMeetingsViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDateTime = itemView.findViewById(R.id.textDateTime);
            textStatus = itemView.findViewById(R.id.textStatus);
        }
    }
}
