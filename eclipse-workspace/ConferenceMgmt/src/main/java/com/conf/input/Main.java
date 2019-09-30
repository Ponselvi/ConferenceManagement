package main.java.com.conf.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import main.java.com.conf.config.Config;
import main.java.com.conf.pojo.ConferenceTrack;
import main.java.com.conf.pojo.TimeSlot;
import main.java.com.conf.pojo.Topic;
import main.java.com.conf.processor.ConferenceServiceProcessor;

public class Main {
	public static void main(String a[]) {
		Main m = new Main();
		List<Topic> topicList = null;
		String fileName = "inputTopics.txt";

		// Step 1: Read the input from file
		try {
			topicList = m.readTopics(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Step 2:Schedule the topics 
		ConferenceServiceProcessor confProcessor = new ConferenceServiceProcessor();
		List<ConferenceTrack> conferenceList = confProcessor.arrangeTopics(topicList);

		//Step 3: Print the output
		for (ConferenceTrack track : conferenceList) {
			System.out.println("Track " + track.getTrackId());
			List<TimeSlot> timeSlots = track.getSlots();
			System.out.println("");
			SimpleDateFormat sdf = Config.DATE_FORMAT;
			for (TimeSlot timeSlot : timeSlots) {
				for (main.java.com.conf.pojo.Event event : timeSlot.getEvents()) {
					System.out.println(sdf.format(event.getStartTime().getTime()) + " " + event.getTitle() + " "
							+ event.getDurationInMins());
				}
			}
			System.out.println("------------------------------------------------------------");
		}

	}

	public List<Topic> readTopics(String fileName) throws FileNotFoundException {
		FileInputStream inputStream = null;
		List<Topic> topicList = new ArrayList<>();
		
		//case:File not found
		try {
			inputStream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			System.err.println("Input file is not found : " + fileName);
			throw e;
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String inputLine;
		int inputMin;

		//Read the file to get the conference details and mins
		try {
			while ((inputLine = br.readLine()) != null) {
				if (inputLine.isEmpty())
					continue;
				String title = inputLine.substring(0, inputLine.lastIndexOf(" "));
				String minutesString = inputLine.substring(inputLine.lastIndexOf(" ") + 1);
				
				String minutes = inputLine.replaceAll("\\D+", "");
				
				if (Config.LIGHTNING.equals(minutesString)) {
					inputMin = Config.LIGHTNING_DURATION_MINS;
				} else {
					try {
						inputMin = Integer.parseInt(minutes);
					} catch (NumberFormatException e) {
						System.err.println("Error whille processing the line : " + inputLine);
						throw e;
					}
				}
				Topic oneTopic = new Topic(title, inputMin);
				topicList.add(oneTopic);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				br.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		return topicList;
	}
}
