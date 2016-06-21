package com.event.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.event.model.Event;
import com.event.model.Participent;
import com.event.model.Sponser;

public class Registration {

	private List<Event> registerdEventList;
	private List<Participent> registerdParticipentList;
	private List<Sponser> registerdSponserList;
	private Map<Participent,List<Event>> participentsRegisterdEventListMapping;
	
	public Registration()
	{
	 registerdEventList = new ArrayList<Event>();	
	 registerdParticipentList =new ArrayList<Participent>();
	 participentsRegisterdEventListMapping =new HashMap<Participent,List<Event>>();
	
	}
	
	public boolean registerEvent(Event eventObj) {
		// TODO Auto-generated method stub
		if(registerdEventList.contains(eventObj))
		{
			return false;
		}
		else
		{
			registerdEventList.add(eventObj);
			return true;
		}
		
	}

	public boolean registerParticipent(Participent participentObj) {
		// TODO Auto-generated method stub
		if(registerdParticipentList.contains(participentObj))
		{
			return false;
		}
		else
		{
			registerdParticipentList.add(participentObj);
			return true;
		}
	}

	public boolean isParticipentRegistred(Participent participentObj)
	{
		if(registerdParticipentList.contains(participentObj))
			return true;
		else
			return false;
	}
	
	public boolean isEventRegistred(Event eventObj)
	{
		if(registerdEventList.contains(eventObj))
			return true;
		else
			return false;
	}
	
	public void addParticipentToEvent(Event eventObj,Participent participentObj)
	{
		if(!eventObj.getRegistredParticipentList().contains(participentObj))
			eventObj.getRegistredParticipentList().add(participentObj);
			
	}
	public boolean registerParticipentForEvent(Participent participentObj,
			Event eventObj) {
		// TODO Auto-generated method stub
		if(isParticipentRegistred(participentObj) && isEventRegistred(eventObj))
		{
			if(participentsRegisterdEventListMapping.containsKey(participentObj))
			{
			List<Event> eventList=participentsRegisterdEventListMapping.get(participentObj);
			eventList.add(eventObj);
			participentsRegisterdEventListMapping.put(participentObj, eventList);
			}
			else
			{
				List<Event> eventList = new ArrayList<Event>();
				eventList.add(eventObj);
				participentsRegisterdEventListMapping.put(participentObj, eventList);
			}
			addParticipentToEvent(eventObj,participentObj);
			
		return true;
		}
		else
		{
		return false;
		}
	}

	public boolean registerSponser(Sponser sponserObj) {
		// TODO Auto-generated method stub
		if(registerdSponserList.contains(sponserObj))
		{
			return false;
		}
		else
		{
			registerdSponserList.add(sponserObj);
			return true;
		}
		
	}

}
