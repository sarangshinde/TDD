package com.destinationfinder.model;

public class Trip implements Comparable<Trip> {

	private DestinationDetail sourceDestination;
	public Trip(DestinationDetail sourceDestination,
			DestinationDetail targetDestination, int noOfMatchedPassions,
			double distance) {
		this.sourceDestination = sourceDestination;
		this.targetDestination = targetDestination;
		this.noOfMatchedPassions = noOfMatchedPassions;
		this.distance = distance;
	}
	private DestinationDetail targetDestination;
	public DestinationDetail getSourceDestination() {
		return sourceDestination;
	}
	public DestinationDetail getTargetDestination() {
		return targetDestination;
	}
	public int getNoOfMatchedPassions() {
		return noOfMatchedPassions;
	}
	public double getDistance() {
		return distance;
	}
	private int noOfMatchedPassions ;
	private double distance;
	
	
	
	@Override
	public int compareTo(Trip tripToCompare) {
		if(this.getNoOfMatchedPassions()==tripToCompare.getNoOfMatchedPassions())
		return Double.valueOf(this.getDistance()).compareTo(Double.valueOf(tripToCompare.getDistance()));
		else
			return Integer.valueOf(tripToCompare.getNoOfMatchedPassions()).compareTo(Integer.valueOf(this.getNoOfMatchedPassions()));
	}
	
	
  @Override
public String toString() {
	return this.sourceDestination.getName()+ " " + this.targetDestination.getName();
}
	
}
