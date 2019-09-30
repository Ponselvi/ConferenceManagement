package main.java.com.conf.pojo;

import java.util.Calendar;

public class Event {

    private Calendar startTime;
    private int durationInMins;
    private String title;

    public Event(Calendar startTime, String title, int durationInMins){
        this.startTime = startTime;
        this.title = title;
        this.durationInMins = durationInMins;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public int getDurationInMins() {
        return durationInMins;
    }

    public String getTitle() {
        return title;
    }

}
