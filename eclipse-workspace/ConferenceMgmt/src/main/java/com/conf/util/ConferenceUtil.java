package main.java.com.conf.util;

import java.util.Calendar;
import java.util.List;

import main.java.com.conf.pojo.Topic;

public class ConferenceUtil {
	 
    public static Calendar getCalendarTime(int hours, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
        return cal;
    }

    public static Calendar getNextCalendarTime(Calendar currentStartTime, Topic currentTopic) {
        Calendar proposedTime = Calendar.getInstance();
        proposedTime.set(Calendar.HOUR_OF_DAY, currentStartTime.get(Calendar.HOUR_OF_DAY));
        proposedTime.set(Calendar.MINUTE, currentStartTime.get(Calendar.MINUTE));
        proposedTime.add(Calendar.MINUTE, currentTopic.getDurationInMins());
        return proposedTime;
    }

}
