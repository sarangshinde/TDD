package model;

public class Review {

	
	public Review(String passionName, String reviewBody, long timeStamp) {
		this.passionName = passionName;
		this.reviewBody = reviewBody;
		this.timeStamp = timeStamp;
	}
	public String getPassionName() {
		return passionName;
	}
	public String getReviewBody() {
		return reviewBody;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	private String passionName;
	private String reviewBody;
	private long timeStamp;

}
