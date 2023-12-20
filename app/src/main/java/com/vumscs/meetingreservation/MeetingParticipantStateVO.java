package com.vumscs.meetingreservation;

public class MeetingParticipantStateVO {
    private String name;
    private boolean selected;

    public String getName(){
        return name;
    }

    public boolean isSelected(){
        return selected;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public void setName(String name){
        this.name = name;
    }

}
