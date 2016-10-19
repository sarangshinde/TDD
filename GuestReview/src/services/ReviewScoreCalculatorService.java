package services;

import java.util.Calendar;
import model.Review;

public class ReviewScoreCalculatorService {

	
	
	public double calculateScore(Review review) {
		double reviewBodyScore=getReviewBodyScore(review);
		double reviewTimeScore=getReviewTimeScore(review);
		return (reviewBodyScore+reviewTimeScore);
	}

	private double getReviewTimeScore(Review review) {
		Calendar reviewTimestamp=Calendar.getInstance();
		reviewTimestamp.setTimeInMillis(review.getTimeStamp()*1000l);
		return isTimeStampWithRange(reviewTimestamp) ? 20 :	10;	
	}

	private double getReviewBodyScore(Review review) {
		return review.getReviewBody().length()<100 ? 10 : 20;	
		
	}

	private boolean isTimeStampWithRange(Calendar reviewTimestamp) {
		  Calendar endDate = Calendar.getInstance();
		  endDate.set(2016,6,15);
		  Calendar startDate = Calendar.getInstance();
		  startDate.set(2016,5,15);
		return reviewTimestamp.after(startDate) && reviewTimestamp.before(endDate);
	}

}
