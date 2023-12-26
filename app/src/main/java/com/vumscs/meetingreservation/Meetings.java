package com.vumscs.meetingreservation;

import java.util.Date;
import java.util.List;

public class Meetings {
    private String title;
    private String date;
    private String time;
    private String status;
    private List<String> participants;
    private String createdBy;
    private String id;
    private String description;
    private String dateTime;

    public Meetings()
    {

    }

    public Meetings(String id, String title, String date, String time, List<String> participants, String createdBy, String status, String description)
    {
        this.createdBy = createdBy;
        this.date = date;
        this.participants = participants;
        this.time = time;
        this.title = title;
        this.status = status;
        this.id = id;
        this.description = description;
    }

    public Meetings(String id, String title, String dateTime){
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
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

    public String getId(){
        return id;
    }

    public String getDateTime()
    {
        String date = getDate();
        String time = getTime();
        String dateTime = date + " " + time;
        return dateTime;
    }

    public String  getDateTimes(){
        return dateTime;
    }
    public String getStatus(){ return status;}

    public List<String> getParticipants()
    {
        return participants;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getDescription(){return description;}

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
