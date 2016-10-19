package services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import model.Reviewer;

public class ReviewerService {

	public void calculateReviewerReviewScore(Reviewer reviewer, String passion) {
		ReviewScoreCalculatorService reviewScoreCalculatorService = new ReviewScoreCalculatorService();
		double score = reviewer.getReviewsList().stream()
				.filter(review -> passion.equalsIgnoreCase(review.getPassionName()))
		        .mapToDouble(reviewScoreCalculatorService::calculateScore)
		        .sum();
		if(score>1.0)
		reviewer.addPassionScore(passion,score);
	}

	public int getExpertReviewer(String passion, List<Reviewer> reviewers) {
		
		Comparator<Reviewer> reviewScoreComparator = (review1, review2) -> Double.compare( review1.getPassionScore(passion), review2.getPassionScore(passion));
		Comparator<Reviewer> reviewerIdComparator = (review1, review2) -> Integer.compare( review2.getReviewerId(), review1.getReviewerId());
		for(Reviewer reviewer : reviewers)
			calculateReviewerReviewScore(reviewer,passion);
		Optional<Reviewer> expertReviewer=  reviewers.stream()
				   .filter(reviwer -> reviwer.hasPassionReview(passion))
				   .max(reviewScoreComparator.thenComparing(reviewerIdComparator));						 
		return expertReviewer.isPresent() ? expertReviewer.get().getReviewerId():-1;
	}

}
