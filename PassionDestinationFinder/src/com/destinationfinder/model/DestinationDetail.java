package com.destinationfinder.model;

import java.util.Set;
import java.util.TreeSet;

public class DestinationDetail implements Comparable<DestinationDetail>{

	public DestinationDetail(String name, double lattitude, double longitude,
			int noOfAvailablePassions, Set<String> availablePassions) {
		this.name = name;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.noOfAvailablePassions = noOfAvailablePassions;
		this.availablePassions = availablePassions;
	}
	String name;
	public String getName() {
		return name;
	}
	public double getLattitude() {
		return lattitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public int getNoOfAvailablePassions() {
		return noOfAvailablePassions;
	}
	public Set<String> getAvailablePassions() {
		return availablePassions;
	}
	double lattitude;
	double longitude;
	int noOfAvailablePassions;
	
	public int getNoOfMatchedPassions() {
		return this.matchedPassions.size();
	}
	
	private Set<String> matchedPassions= new TreeSet<>();
	
	public Set<String> getMatchedPassions() {
		return matchedPassions;
	}
	public void addMatchedPassion(String passion)
	{
		this.matchedPassions.add(passion);
	}
	
	Set<String> availablePassions;
	@Override
	public boolean equals(Object obj) {
		DestinationDetail objToBeCompareWith = (DestinationDetail)obj;
		return this.name.equalsIgnoreCase(objToBeCompareWith.name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	@Override
	public int compareTo(DestinationDetail matchingDestination) {
				
				 return this.name.compareTo(matchingDestination.name);		 
	}

}
