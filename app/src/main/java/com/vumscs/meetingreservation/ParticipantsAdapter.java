package com.vumscs.meetingreservation;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.ParticipantsViewHolder> {

    private List<Participants> participantList;
    private Context context;

    public ParticipantsAdapter(List<Participants> participantList) {
        this.participantList = participantList;
    }

    public ParticipantsAdapter(List<Participants> participantList, Context context){
        this.participantList = participantList;
        this.context = context;
    }

    @NonNull
    @Override
    public ParticipantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_participants_item    , parent, false);
        return new ParticipantsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ParticipantsViewHolder holder, int position) {
        final Participants participant = participantList.get(position);
        holder.checkBoxParticipant.setChecked(participant.isSelected());
        holder.textViewName.setText(participant.getName());
        holder.textViewEmail.setText(participant.getEmail());

        holder.checkBoxParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                participant.setSelected(holder.checkBoxParticipant.isChecked());
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ParticipantsViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBoxParticipant;
        private TextView textViewName;
        private TextView textViewEmail;

        public ParticipantsViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBoxParticipant = itemView.findViewById(R.id.checkBoxParticipant);
            textViewName = itemView.findViewById(R.id.textViewName);
            //textViewEmail = itemView.findViewById(R.id.textViewEmail);
        }
    }
}


