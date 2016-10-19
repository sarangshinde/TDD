package services;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Review;
import model.Reviewer;

public class ReviewerServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_returnReviwersReviewScore_for_reviewerSinglePassionReview() {
		ReviewerService reviewerService = new ReviewerService();
		String passion="Skating";
		Reviewer reviewer = new Reviewer(1, Arrays.asList(new Review("Skating","Skating is good in austrelia",1467720000)),"Skating");
		reviewerService.calculateReviewerReviewScore(reviewer,passion);
		assertEquals(30d, reviewer.getPassionScore(passion),0.2);
	}

	@Test
	public void should_returnReviwersReviewScore_for_reviewerMulipleReviews() {
		ReviewerService reviewerService = new ReviewerService();
		List<Review> reviews = Arrays.asList(
									new Review("Skating","Skating is good in austrelia",1467720000),
									new Review("Skating","Skating is good in austrelia",1467720000),
									new Review("Skating","Skating is good in austrelia",1467720000)
									);
		String passion="Skating";
		Reviewer reviewer = new Reviewer(1, reviews,"Skating");
		reviewerService.calculateReviewerReviewScore(reviewer,passion);
		assertEquals(90d, reviewer.getPassionScore(passion),0.2);
	}
	

	@Test
	public void should_returnExpertReviewerId_for_singlePassion() {
		ReviewerService reviewerService = new ReviewerService();
		List<Review> reviews = Arrays.asList(
									new Review("Skating","Skating is good in austrelia",1467720000),
									new Review("Skating","Skating is good in austrelia",1467720000),
									new Review("Skating","Skating is good in austrelia",1467720000)
									);
		String passion="Skating";
		Reviewer reviewer = new Reviewer(1, reviews,"Skating");
		int expertReiveweId= reviewerService.getExpertReviewer(passion,Arrays.asList(reviewer,reviewer));
		assertEquals(1,expertReiveweId);
	}
	
	@Test
	public void should_returnMinusOne_when_noReviwerReviewGivenPassion() {
		ReviewerService reviewerService = new ReviewerService();
		List<Review> reviews = Arrays.asList(
									new Review("Skating","Skating is good in austrelia",1467720000)
									);
		String passion="Food";
		Reviewer reviewer = new Reviewer(1, reviews,"Skating");
		int expertReiveweId= reviewerService.getExpertReviewer(passion,Arrays.asList(reviewer,reviewer));
		assertEquals(-1,expertReiveweId);
	}
	
	@Test
	public void should_returnReviwerWithMinId_when_moreThan1ExpertReviwerOfPassion() {
		ReviewerService reviewerService = new ReviewerService();
		List<Review> reviews = Arrays.asList(
									new Review("Food","Food is good in austrelia",1467720000)
									);
		String passion="Food";
		Reviewer reviewer1 = new Reviewer(22, reviews,"Food");
		Reviewer reviewer2 = new Reviewer(13, reviews,"Food");
		Reviewer reviewer3 = new Reviewer(33, reviews,"Food");
		
		
		int expertReiveweId= reviewerService.getExpertReviewer(passion,Arrays.asList(reviewer1,reviewer2,reviewer3));
		assertEquals(13,expertReiveweId);
	}
	
	

	
	
}
