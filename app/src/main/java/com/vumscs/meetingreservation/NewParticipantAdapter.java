package com.vumscs.meetingreservation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class NewParticipantAdapter extends ArrayAdapter<Participants> {
    private ArrayList<Participants> participantsArrayList;
    private Context context;

    public  NewParticipantAdapter(ArrayList<Participants> participants, Context context){
        super(context,R.layout.activity_participants_item,participants);


    }

    private class ViewHolder{
        TextView txtName;
//        TextView txtEmail;
        CheckBox chkBox;
    }

    @Override
    public int getCount(){
        return participantsArrayList.size();
    }

    @Override
    public Participants getItem(int position){
        return (Participants) participantsArrayList.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View result;
        ViewHolder viewHolder;

        if (convertView == null) {
            //viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_participants_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.txtName = convertView.findViewById(R.id.textViewName);
          //  viewHolder.txtEmail = convertView.findViewById(R.id.textViewEmail);
            viewHolder.chkBox = convertView.findViewById(R.id.checkBoxParticipant);
            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Participants data = participantsArrayList.get(position);

        viewHolder.txtName.setText(data.getName());
        //viewHolder.txtEmail.setText(data.toString());
        viewHolder.chkBox.setChecked(data.isSelected());

        return result;
    }
}
