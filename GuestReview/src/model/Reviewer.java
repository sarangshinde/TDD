package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reviewer {
	
	int reviewerId;
	public int getReviewerId() {
		return reviewerId;
	}
	public List<Review> getReviewsList() {
		return reviewsList;
	}
	List<Review> reviewsList = new ArrayList<>();
	public Reviewer(int reviewerId, List<Review> reviewsList,String passion) {
		this.reviewerId = reviewerId;
		this.reviewsList = reviewsList;
		this.passion= passion;
	}
	String passion;
	public String getPassion() {
		return passion;
	}
	
	Map<String,Double> passionScore = new HashMap<>();
	double score;
	public double getPassionScore(String passion) {
		return this.passionScore.get(passion);
	}
	public void addPassionScore(String passion,Double score) {
		this.passionScore.put(passion, score);
	}
	
	public boolean hasPassionReview(String passion)
	{
		return this.passionScore.containsKey(passion);
	}
	
	
}
