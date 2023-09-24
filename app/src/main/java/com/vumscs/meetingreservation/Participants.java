package com.vumscs.meetingreservation;

public class Participants {
    String name = "";
    String id = "";
    String email = "";
    boolean isSelected = false;

    public Participants(String id, String name, String email, boolean isSelected)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isSelected = isSelected;
    }
}
