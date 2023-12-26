package com.vumscs.meetingreservation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MeetingsItemsAdapter extends ArrayAdapter<Meetings> {

    public MeetingsItemsAdapter(@NonNull Context context, int resource, List<Meetings> meetings) {
        super(context, resource, meetings);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Meetings meetings = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.meetings_items,parent,false);
        }
        TextView txtMeetingId = (TextView) convertView.findViewById(R.id.txtMeetingId);
        TextView txtMeetingName = (TextView) convertView.findViewById(R.id.txtMeetingName);
        TextView txtMeetingDate = (TextView) convertView.findViewById(R.id.txtMeetingDateTime);


        txtMeetingId.setText(meetings.getId());
        txtMeetingName.setText(meetings.getTitle());
        txtMeetingDate.setText(meetings.getDateTimes());

        return convertView;
    }
}
