package com.vumscs.meetingreservation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MeetingsAdapter extends RecyclerView.Adapter<MeetingsAdapter.MeetingsViewHolder> {
    private List<Meetings> meetingList;

    public MeetingsAdapter(List<Meetings> meetingList)
    {
        this.meetingList = meetingList;
    }

    @NonNull
    @Override
    public MeetingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_meetings_item, parent, false);
        return new MeetingsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingsViewHolder holder, int position) {
        Meetings meeting = meetingList.get(position);
        holder.textViewTitle.setText(meeting.getTitle());
        holder.textViewDate.setText(meeting.getDate());
        holder.textViewTime.setText(meeting.getTime());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MeetingsViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textViewTitle;
        public TextView textViewDate;
        public TextView textViewTime;

        public MeetingsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewTime = itemView.findViewById(R.id.textViewTime);
        }
    }


}

