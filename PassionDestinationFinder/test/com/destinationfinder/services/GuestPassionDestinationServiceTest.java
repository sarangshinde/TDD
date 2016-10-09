package com.destinationfinder.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import com.destinationfinder.model.DestinationDetail;
import com.destinationfinder.model.GuestPassionDetail;
import com.destinationfinder.model.Trip;

public class GuestPassionDestinationServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void should_returnTrip_for_MatchingMaximumPassionsOfGuests() {
		Set<String> availablePassions = new TreeSet<>();
		availablePassions.add("beach");availablePassions.add("walking");
		availablePassions.add("wine");
		Set<String> availablePassionsn = new TreeSet<>();
		availablePassionsn.add("beach");availablePassions.add("surfing");
		availablePassionsn.add("relaxation");
		Set<String> availablePassionsnn = new TreeSet<>();
		availablePassionsnn.add("beach");availablePassionsnn.add("walking");
		DestinationDetail firstDestinationDetail = new DestinationDetail("amsterdam", 52.55d, 4.89d, 3,availablePassions);
		DestinationDetail secondDestinationDetail = new DestinationDetail("sagres", 37.12d, -8.66d, 3,availablePassionsn);
		DestinationDetail thirdDestinationDetail = new DestinationDetail("texas", 37.33d, -7.66d, 2,availablePassionsnn);
		
		Set<String> firstGuestPassion = new TreeSet<>();firstGuestPassion.add("walking");
		Set<String> secondGuestPassion = new TreeSet<>();secondGuestPassion.add("walking");
		secondGuestPassion.add("wine"); secondGuestPassion.add("surfing"); secondGuestPassion.add("beach");
		GuestPassionDetail firstGuestPassionDetail = new GuestPassionDetail(1, firstGuestPassion);
		GuestPassionDetail secondGuestPassionDetail = new GuestPassionDetail(4, secondGuestPassion);
		
		GuestPassionDestinationService guestPassionDestinationService =new GuestPassionDestinationService();
		Set<GuestPassionDetail> guestPassionDetails = new HashSet<>();
		guestPassionDetails.add(firstGuestPassionDetail);
		guestPassionDetails.add(secondGuestPassionDetail);
		Set<DestinationDetail> destinationDetails = new TreeSet<>();
		destinationDetails.add(firstDestinationDetail);
		destinationDetails.add(secondDestinationDetail);
		destinationDetails.add(thirdDestinationDetail);
		Trip matchedTrip = guestPassionDestinationService.findTrip(guestPassionDetails,destinationDetails);
		assertEquals("amsterdam texas", matchedTrip.toString());
		
	}
	

	@Test
	public void should_returnTrip_when_moreThanOneDestinationsMatchingMaximumPassionsOfGuests() {
		Set<String> availablePassions = new TreeSet<>();
		availablePassions.add("museums");availablePassions.add("canals");
		availablePassions.add("nightlife");availablePassions.add("walking");
		DestinationDetail firstDestinationDetail = new DestinationDetail("tttt", 52.374030d, 4.889690d, 4,availablePassions);
		DestinationDetail secondDestinationDetail = new DestinationDetail("asagres", 37.129665d, -8.669586d, 4,availablePassions);
		DestinationDetail thirdDestinationDetail = new DestinationDetail("biarritz", 43.480120d, -1.555580d, 4,availablePassions);
		

		
		Set<String> firstGuestPassion = new TreeSet<>();firstGuestPassion.add("walking");
		Set<String> secondGuestPassion = new TreeSet<>();
		secondGuestPassion.add("wine"); secondGuestPassion.add("surfing"); secondGuestPassion.add("beach");
		GuestPassionDetail firstGuestPassionDetail = new GuestPassionDetail(1, firstGuestPassion);
		GuestPassionDetail secondGuestPassionDetail = new GuestPassionDetail(3, secondGuestPassion);
		
		GuestPassionDestinationService guestPassionDestinationService =new GuestPassionDestinationService();
		Set<GuestPassionDetail> guestPassionDetails = new HashSet<>();
		guestPassionDetails.add(firstGuestPassionDetail);
		guestPassionDetails.add(secondGuestPassionDetail);
		
		Set<DestinationDetail> destinationDetails = new TreeSet<>();
		destinationDetails.add(firstDestinationDetail);
		destinationDetails.add(secondDestinationDetail);
		destinationDetails.add(thirdDestinationDetail);

		Trip matchedTrip = guestPassionDestinationService.findTrip(guestPassionDetails,destinationDetails);
		assertEquals("asagres biarritz", matchedTrip.toString());
		
	}

	

}
