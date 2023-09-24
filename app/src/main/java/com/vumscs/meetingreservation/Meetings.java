package com.vumscs.meetingreservation;

import java.util.List;

public class Meetings {
    private String title;
    private String date;
    private String time;
    private List<String> participants;
    private String createdBy;

    public Meetings(String title, String date, String time, List<String> participants, String createdBy)
    {
        this.createdBy = createdBy;
        this.date = date;
        this.participants = participants;
        this.time = time;
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDate()
    {
        return date;
    }

    public String getTime()
    {
        return time;
    }

    public List<String> getParticipants()
    {
        return participants;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
