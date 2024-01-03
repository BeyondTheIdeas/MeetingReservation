package com.vumscs.meetingreservation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class UserMeetingsItemAdapter extends ArrayAdapter<Meetings> {
    public UserMeetingsItemAdapter(@NonNull Context context, int resource, List<Meetings> meetings){
        super(context,resource,meetings);
    }

    public View getView (int position, View convertView, ViewGroup parent){
        Meetings meetings = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_meetings_view_item,parent,false);
        }
        TextView txtMeetingId = (TextView) convertView.findViewById(R.id.txtUserMeetingId);
        TextView txtMeetingName = (TextView) convertView.findViewById(R.id.txtUserMeetingName);
        TextView txtMeetingDateTime = (TextView) convertView.findViewById(R.id.txtUserMeetingDateTime);

        txtMeetingId.setText("Meeting Id: "+meetings.getId());
        txtMeetingName.setText("Meeting Title: " +meetings.getTitle());
        txtMeetingDateTime.setText("Meeting Date Time: "+meetings.getDateTimes());
        return convertView;
    }
}
