package main.java.com.conf.pojo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimeSlot {
		private List<Event> events = new ArrayList<>();
	    private int pendingDuration;
	    private Calendar startTime;

	
	  public List<Event> getEvents() { 
		  return events; 
	  }
	  
	  public void addEvent(Event event) { 
		  this.events.add(event);
		  this.pendingDuration =  this.pendingDuration - event.getDurationInMins();
	  }
	 

	    public Calendar getStartTime() {
	        return startTime;
	    }

	    public TimeSlot(int duration, Calendar startTime){
	        this.pendingDuration = duration;
	        this.startTime = startTime;
	    }
	   
	    public boolean hasVacantRoom(Topic topic) {
	        return pendingDuration >= topic.getDurationInMins();
	    }
}
