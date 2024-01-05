package com.vumscs.meetingreservation;

import android.content.Context;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;

public class SelectUsersForMeetingAdapter extends ArrayAdapter<Participants> {


    public SelectUsersForMeetingAdapter(@NonNull Context context, int resource, @NonNull List<Participants> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Participants participants = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.select_participants_items,parent,false);
        }
        CheckBox chk = convertView.findViewById(R.id.chkSelPart);
        TextView txtUserId = convertView.findViewById(R.id.txtSelUserId);
        TextView txtUserName = convertView.findViewById(R.id.txtSelUserName);

        chk.setSelected(participants.isSelected());
        txtUserId.setText(participants.getParticipantId());
        txtUserName.setText(participants.getName());

        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Clicked",Toast.LENGTH_LONG).show();

            }
        });

        return convertView;

    }
}
