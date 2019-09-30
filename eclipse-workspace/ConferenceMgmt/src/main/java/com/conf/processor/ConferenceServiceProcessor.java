package main.java.com.conf.processor;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Iterator;
import java.util.List;

import main.java.com.conf.config.Config;
import main.java.com.conf.pojo.ConferenceTrack;
import main.java.com.conf.pojo.Event;
import main.java.com.conf.pojo.TimeSlot;
import main.java.com.conf.pojo.Topic;
import main.java.com.conf.util.ConferenceUtil;

public class ConferenceServiceProcessor {
	
	public List<ConferenceTrack> arrangeTopics(List<Topic> topicList) {
		Event lunchEvent = new Event(Config.LUNCH_BEGIN_TIME, "Lunch", Config.LUNCH_DURATION_MINUTES);
		Event nwEvent = new Event(Config.NETWORKING_BEGIN_TIME, "Networking Event", 0);
		List<ConferenceTrack> confTrackList = new ArrayList<ConferenceTrack>(); 
		int trackCount = 0;
		
		while (topicList.size() != 0) {
			TimeSlot fnSession = new TimeSlot(Config.MORNING_DURATION_MINUTES, Config.TRACK_BEGIN_TIME);
			occupySlot(fnSession, topicList);

			TimeSlot lunchSession = new TimeSlot(Config.LUNCH_DURATION_MINUTES, Config.LUNCH_BEGIN_TIME);
			lunchSession.addEvent(lunchEvent);

			TimeSlot afternoonSession = new TimeSlot(Config.AFTERNOON_DURATION_MINUTES,
					Config.POST_LUNCH_BEGIN_TIME);
			occupySlot(afternoonSession, topicList);

			TimeSlot networkingSession = new TimeSlot(Config.NETWORKING_DURATION_MINUTES, Config.NETWORKING_BEGIN_TIME);
			networkingSession.addEvent(nwEvent);

			ConferenceTrack confTrack = new ConferenceTrack(++trackCount);
			confTrack.addSlot(fnSession);
			confTrack.addSlot(lunchSession);
			confTrack.addSlot(afternoonSession);
			confTrack.addSlot(networkingSession);
			confTrackList.add(confTrack);
		}
		return confTrackList;
	}
	
	 private void occupySlot(TimeSlot timeSlot, List<Topic> topics) {
	        Calendar currentStartTime = timeSlot.getStartTime();
	        Iterator<Topic> topicIterator = topics.iterator(); 
	        while(topicIterator.hasNext()){
	        	Topic topic = topicIterator.next();
	            if (timeSlot.hasVacantRoom(topic)) {
	            	timeSlot.addEvent(new Event(currentStartTime, topic.getTitle(), topic.getDurationInMins()));
	                currentStartTime = ConferenceUtil.getNextCalendarTime(currentStartTime, topic);
	                topicIterator.remove();
	            }
	        }
	    }
}
