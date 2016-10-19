package model;

import java.util.List;

public class InputData {
	
	
	public InputData(List<String> passionsList, List<Reviewer> reviewers) {
		this.passionsList = passionsList;
		this.reviewers = reviewers;
	}
	List<String> passionsList;
	public List<String> getPassionsList() {
		return passionsList;
	}
	public List<Reviewer> getReviewers() {
		return reviewers;
	}
	List<Reviewer> reviewers;
}
