package com.event.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Event {
	
	private String eventName;
	public List<Participent> getRegistredParticipentList() {
		return registredParticipentList;
	}
	private List<Participent> registredParticipentList;
	private List<Sponser> registredSponserList;
	public Event(String eventName, String eventId,
			String eventOrganizerCollage, Date eventDate, float eventFee) {
		super();
		this.eventName = eventName;
		this.eventId = eventId;
		this.eventOrganizerCollage = eventOrganizerCollage;
		this.eventDate = eventDate;
		this.eventFee = eventFee;
		registredParticipentList =new ArrayList<Participent>();
		registredSponserList=new ArrayList<Sponser>();
	}
	private String eventId;
	private String eventOrganizerCollage;
	private Date eventDate;
	private float eventFee; 

	
}
