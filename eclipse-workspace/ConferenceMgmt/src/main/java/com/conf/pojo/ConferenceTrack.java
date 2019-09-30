package main.java.com.conf.pojo;

import java.util.ArrayList;
import java.util.List;


public class ConferenceTrack {
    private List<TimeSlot> timeSlots;
    private int trackId;
    List<ConferenceTrack> tracks;
    
    public ConferenceTrack() {
        
    }
    
    public List<ConferenceTrack> getTracks() {
        return tracks;
    }

    public ConferenceTrack(int trackId) {
        this.trackId = trackId;
        timeSlots = new ArrayList<>();
    }

    public List<TimeSlot> getSlots() {
        return timeSlots;
    }

    public void addSlot(TimeSlot slot) {
        this.timeSlots.add(slot);
    }

    public int getTrackId() {
        return trackId;
    }

}
