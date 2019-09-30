package main.java.com.conf.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import main.java.com.conf.util.ConferenceUtil;

public class Config {
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm a");

	public static final String LIGHTNING = "lightning";
	public static final int TOTAL_TRACK_DURATION_MINUTES = 420;
	public static final int MORNING_DURATION_MINUTES = 180;
	public static final int AFTERNOON_DURATION_MINUTES = 240;
	public static final int LIGHTNING_DURATION_MINS = 5;
	public static final int LUNCH_DURATION_MINUTES = 60;
	public static final int NETWORKING_DURATION_MINUTES = 60;

	public static Calendar TRACK_BEGIN_TIME = ConferenceUtil.getCalendarTime(9, 0);;
	public static Calendar LUNCH_BEGIN_TIME = ConferenceUtil.getCalendarTime(12, 0);
	public static Calendar POST_LUNCH_BEGIN_TIME = ConferenceUtil.getCalendarTime(13, 0);
	public static Calendar NETWORKING_BEGIN_TIME = ConferenceUtil.getCalendarTime(17, 0);

}
