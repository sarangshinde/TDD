package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import model.InputData;
import model.Review;
import model.Reviewer;

public class InputService {

	public InputData createObjectsFromInput(String fileName) throws IOException {
		BufferedReader inputFile = new BufferedReader(new FileReader(fileName));
		String passionAndReviews = inputFile.readLine();
		int passions=Integer.parseInt(passionAndReviews.split(" +")[0]);
		int reviews=Integer.parseInt(passionAndReviews.split(" +")[1]);
		List<String> passionsList =readPassions(passions,inputFile);
		List<Reviewer> reviewers =readReviewerReviews(reviews,passionsList,inputFile);
/*		reviewers.stream().forEach(reviewer ->
								   System.out.println(reviewer.getReviewerId() + " " + 
								   reviewer.getReviewsList().size()));*/
		return new InputData(passionsList,reviewers);

	}

	private List<Reviewer> readReviewerReviews(int reviews,List<String> passionsList,BufferedReader inputFile) throws IOException {
		
		List<Review> reviewList = null;
		Map<Integer,List<Review>> reviwerReviews = new HashMap<>();
		for(int review=0;review<reviews;review++){
			String reviwerIdandTimestamp = inputFile.readLine();
			int reviewerId = Integer.parseInt(reviwerIdandTimestamp.split(" +")[0]);
			Long timestamp = Long.parseLong(reviwerIdandTimestamp.split(" +")[1]);
			String reviewBody = inputFile.readLine().toUpperCase();
			String passion=getPassion(reviewBody,passionsList);
			if(!passion.isEmpty())
			{
			Review reviewObj =getReviews(passion,reviewBody,timestamp);
			reviewList = reviwerReviews.containsKey(reviewerId) ?
						 reviwerReviews.get(reviewerId): new ArrayList<>();				 
			reviewList.add(reviewObj);
			reviwerReviews.put(reviewerId, reviewList);
			}
			
		}
		return createReviwers(reviwerReviews);	
	}

	private List<Reviewer> createReviwers(Map<Integer, List<Review>> reviwerReviews) {
		Set<Entry<Integer, List<Review>>> entrySet = reviwerReviews.entrySet();
		return entrySet.stream()
				.filter(reviweEntrt -> reviweEntrt.getValue().size()>0)
			    .map(reviweEntrt -> 
			    		new Reviewer(reviweEntrt.getKey(),reviweEntrt.getValue(),
			    		reviweEntrt.getValue().get(0).getPassionName())
			    		)
			    .collect(Collectors.toList());
	}

	private Review getReviews(String passion, String reviewBody, Long timestamp) {
		return new Review(passion,reviewBody,timestamp);

	}
	
	 private  boolean isContain(String source, String subItem){
         String pattern = "\\b"+subItem+"\\b";
         Pattern p=Pattern.compile(pattern);
         Matcher m=p.matcher(source);
         return m.find();
    }
	private String getPassion(String reviewBody, List<String> passionsList) {
		Optional<String> passionfound =passionsList.stream()
				.filter(passion -> isContain(reviewBody,passion.toUpperCase()))
				.findFirst();
		return passionfound.isPresent()?passionfound.get().toUpperCase():"";
	}

	private List<String> readPassions(int passions,BufferedReader inputFile) throws IOException {
		List<String> passionsList = new LinkedList<>();
		for(int passion=0;passion<passions;passion++){
			passionsList.add(inputFile.readLine().toUpperCase());
		}
		return passionsList;
	}
}
