package services;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Review;

public class ReviewScoreCalculatorServiceTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_returnReviewScore_when_reviewContainslessThan100CharsAndTimestampInRange() {
		ReviewScoreCalculatorService reviewScoreCalculatorService =new ReviewScoreCalculatorService();
		Review review = new Review("Skating","Skating is good in austrelia",1467720000);
		double score =reviewScoreCalculatorService.calculateScore(review);
		assertEquals(30d, score,0.2);
	}
	
	@Test
	public void should_returnReviewScore_when_reviewContainslessThan100CharsAndTimestampNotInRange() {
		ReviewScoreCalculatorService reviewScoreCalculatorService =new ReviewScoreCalculatorService();
		Review review = new Review("Skating","Skating is good in austrelia",1464783400);
		double score =reviewScoreCalculatorService.calculateScore(review);
		assertEquals(20d, score,0.2);
	}
	

	@Test
	public void should_returnReviewScore_when_reviewContainsMoreThan100CharsAndTimestampNotInRange() {
		ReviewScoreCalculatorService reviewScoreCalculatorService =new ReviewScoreCalculatorService();
		Review review = new Review("Skating","Skating is good in austrelia Skating is good in austrelia"
				+ "Skating is good in austrelia Skating is good in austrelia Skating is good in austrelia"
				+ "Skating is good in austrelia Skating is good in austrelia Skating is good in austrelia",1464783400);
		double score =reviewScoreCalculatorService.calculateScore(review);
		assertEquals(30d, score,0.2);
	}
	@Test
	public void should_returnReviewScore_when_reviewContainsMoreThan100CharsAndTimestampInRange() {
		ReviewScoreCalculatorService reviewScoreCalculatorService =new ReviewScoreCalculatorService();
		Review review = new Review("Skating","Skating is good in austrelia Skating is good in austrelia"
				+ "Skating is good in austrelia Skating is good in austrelia Skating is good in austrelia"
				+ "Skating is good in austrelia Skating is good in austrelia Skating is good in austrelia",1467720000);
		double score =reviewScoreCalculatorService.calculateScore(review);
		assertEquals(40d, score,0.2);
	}


}