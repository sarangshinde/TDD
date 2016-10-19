package mainClass;

import java.io.IOException;
import java.util.List;

import model.InputData;
import model.Reviewer;
import services.InputService;
import services.ReviewerService;

public class MainClass {

	public static void main(String[] args) throws IOException {
		
		InputService inputService = new InputService();
		ReviewerService reviewerService = new ReviewerService();
		InputData inputData=inputService.createObjectsFromInput("/home/sarang/sarangcode/GuestReview/TestInput");	
		List<Reviewer> reviewers = inputData.getReviewers();
		inputData.getPassionsList().stream()
								   .forEach((passion)->System.out.println(reviewerService.getExpertReviewer(passion, reviewers)));
		
	}

}
