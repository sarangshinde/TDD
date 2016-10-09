package com.destinationfinder.services;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.destinationfinder.model.DestinationDetail;
import com.destinationfinder.model.GuestPassionDetail;
import com.destinationfinder.model.Trip;


public class GuestPassionDestinationService {

	public Trip findTrip(Set<GuestPassionDetail> guestPassionDetails,Set<DestinationDetail> destinationDetails) {
		Set<DestinationDetail> matchedDestinations = new TreeSet<>();
		for(DestinationDetail destinationDetail : destinationDetails){
			for(GuestPassionDetail guestPassionDetail : guestPassionDetails){
				Set<String> guestPassions = guestPassionDetail.getPassions();
				Set<String> availablePassions = destinationDetail.getAvailablePassions();
				for(String availablePassion : availablePassions){
					if(guestPassions.contains(availablePassion)){
						destinationDetail.addMatchedPassion(availablePassion);
					}
				}
			}
			matchedDestinations.add(destinationDetail);
			
		}
		return findTripOfMatchedDestination(matchedDestinations);
	}



	private Trip findTripOfMatchedDestination(Set<DestinationDetail> matchedDestinations) {
		List<Trip> possibleTrips= new ArrayList<>();
		DestinationDetail[] amatchedDestinations = matchedDestinations.toArray(new DestinationDetail[possibleTrips.size()]);
		for(int sourceDestination=0;sourceDestination<amatchedDestinations.length;sourceDestination++){
			for(int targetDestination=1;targetDestination<amatchedDestinations.length;targetDestination++){
				if(!amatchedDestinations[sourceDestination].getName().equalsIgnoreCase(amatchedDestinations[targetDestination].getName()))
				possibleTrips.add(makeTrip(amatchedDestinations[sourceDestination],amatchedDestinations[targetDestination]));
			}	
		}
		Collections.sort(possibleTrips);
		return possibleTrips.get(0);
	}

	private Trip makeTrip(DestinationDetail sourceDestination, DestinationDetail targetDestination) {
		Set<String> totalMatchedPassions= new TreeSet<>();
		totalMatchedPassions.addAll(sourceDestination.getMatchedPassions());
		totalMatchedPassions.addAll(targetDestination.getMatchedPassions());
		double distance = getDistanceBetween(sourceDestination,targetDestination);
		Trip trip = new Trip(sourceDestination,targetDestination,totalMatchedPassions.size(),distance);
		return trip;
	}

	private double getDistanceBetween(DestinationDetail sourceDestination,DestinationDetail targetDestination) {
		double EARTH_RADIUS=6271d;
		double sourceLatInRadians= toRadians(sourceDestination.getLattitude());
		double targetLatInRadians= toRadians(targetDestination.getLattitude());
		double sourceLongInRadians= toRadians(sourceDestination.getLongitude());
		double targetLongInRadians= toRadians(targetDestination.getLongitude());
		return Math.acos(( sin(sourceLatInRadians) * sin(targetLatInRadians) + 
				 	cos(sourceLatInRadians) * cos(targetLatInRadians) *
				 	cos(targetLongInRadians - sourceLongInRadians)  ))*EARTH_RADIUS;
	}



}
