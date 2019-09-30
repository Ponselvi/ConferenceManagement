package test.com.conf;

import java.util.Calendar;

import main.java.com.conf.pojo.TimeSlot;

public class ConferenceProcessor {
	@Test
	public void testHasVacantRoom() {
		Topic topic = new Topic("CheckPositive", 55);
		Assert.assertTrue(slot.hasVacantRoom(topic));

	}
}
