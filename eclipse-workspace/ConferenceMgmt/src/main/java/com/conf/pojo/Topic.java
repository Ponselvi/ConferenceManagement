package main.java.com.conf.pojo;

public class Topic implements Comparable<Topic>{
	private int durationInMins;
    private String title;

    public Topic(String title, int durationInMins)
    {
        this.durationInMins = durationInMins;
        this.title = title;
    }

	public int getDurationInMins() {
		return durationInMins;
	}

	public void setDurationInMins(int durationInMins) {
		this.durationInMins = durationInMins;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int compareTo(Topic topic) {
		return  this.durationInMins - topic.durationInMins;
	}
}
