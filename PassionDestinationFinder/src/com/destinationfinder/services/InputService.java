package com.destinationfinder.services;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.destinationfinder.model.DestinationDetail;
import com.destinationfinder.model.GuestPassionDetail;
import com.destinationfinder.model.InputDetail;

public class InputService {

	public InputDetail readInput(InputStream in) {
		Scanner input = new Scanner(in);
		int noOfGuests=Integer.parseInt(input.nextLine());
		Set<GuestPassionDetail> guestPassionDetails = getGuestPassionDetails(noOfGuests,input);
		int noOfDestinations=Integer.parseInt(input.nextLine());
		Set<DestinationDetail> destinationDetails = getDestinationDetails(noOfDestinations,input);
		InputDetail inputDetail = new InputDetail(noOfGuests,guestPassionDetails,noOfDestinations,destinationDetails);
		return inputDetail;
		
	}

	private Set<DestinationDetail> getDestinationDetails(int noOfDestinations, Scanner input) {
		Set<DestinationDetail>  destinationDetails= new TreeSet<>();
		for(int destination=0;destination<noOfDestinations;destination++){
			String[] destinationData = input.nextLine().split(" ");
			int noOfpasssions = Integer.parseInt(destinationData[3]);
			String[] passions = Arrays.copyOfRange(destinationData, 4, destinationData.length);
			Set<String> givenPassions = new TreeSet<>(Arrays.asList(passions));
			DestinationDetail destinationDetail = new DestinationDetail(destinationData[0],Float.valueOf(destinationData[1]),
												Float.valueOf(destinationData[2]),noOfpasssions,givenPassions);
			destinationDetails.add(destinationDetail);
		}
		return destinationDetails;
	}

	private Set<GuestPassionDetail>  getGuestPassionDetails(int noOfGuests,Scanner guestInput) {
		Set<GuestPassionDetail>  guestPassionDetails= new HashSet<>();
		for(int guest=0;guest<noOfGuests;guest++){
			String guestPassionData[] = guestInput.nextLine().split(" ");
			int noOfpasssions = Integer.parseInt(guestPassionData[0]);
			String[] passions = Arrays.copyOfRange(guestPassionData, 1, guestPassionData.length);
			Set<String> givenPassions = new TreeSet<>(Arrays.asList(passions));
			GuestPassionDetail guestPassionDetail =new GuestPassionDetail(noOfpasssions,givenPassions);
			guestPassionDetails.add(guestPassionDetail);
		}
		return 	guestPassionDetails;
	}

}
