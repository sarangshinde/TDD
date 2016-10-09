package com.destinationfinder.main;

import com.destinationfinder.model.InputDetail;
import com.destinationfinder.model.Trip;
import com.destinationfinder.services.GuestPassionDestinationService;
import com.destinationfinder.services.InputService;

public class MainClass {
	
	public static void main(String [] args){
		InputService inputService = new InputService();
		InputDetail readInput = inputService.readInput(System.in);
		GuestPassionDestinationService passionMatch = new GuestPassionDestinationService();
		Trip trip =passionMatch.findTrip(readInput.getGuestPassionDetails(), readInput.getDestinationDetails());
		System.out.println(trip.toString());
		
	}

}
