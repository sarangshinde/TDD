package com.destinationfinder.model;

import java.util.Set;

public class InputDetail {
	
	public InputDetail(int noOfGuest,Set<GuestPassionDetail> guestPassionDetails, int noOfDestinations,
			Set<DestinationDetail> destinationDetails) {
		this.noOfGuest = noOfGuest;
		this.guestPassionDetails = guestPassionDetails;
		this.noOfDestinations = noOfDestinations;
		this.destinationDetails = destinationDetails;
	}
	public int getNoOfGuest() {
		return noOfGuest;
	}
	public Set<GuestPassionDetail> getGuestPassionDetails() {
		return guestPassionDetails;
	}
	public int getNoOfDestinations() {
		return noOfDestinations;
	}
	public Set<DestinationDetail> getDestinationDetails() {
		return destinationDetails;
	}
	int noOfGuest;
	Set<GuestPassionDetail> guestPassionDetails;
	int noOfDestinations;
	Set<DestinationDetail>  destinationDetails;

}
