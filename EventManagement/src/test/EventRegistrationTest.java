package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.event.model.Event;
import com.event.model.Participent;
import com.event.model.Sponser;
import com.event.service.Registration;

public class EventRegistrationTest {

	Registration registrationObj ;
	Event eventObj ;
	Participent participentObj;
	Sponser sponserObj;
	@Before
	public void setUp() throws Exception {
		registrationObj= new Registration();
		eventObj= new Event("xyz","1","KIT",new Date(),200.0f);
		participentObj = new Participent("sarang","KOP","KIT","1");
		sponserObj = new Sponser("chandu","istambul","12345678",100000.0f);
	}
	
	@Test
	public void testEventRegistration()
	{
	
		
		assertTrue(registrationObj.registerEvent(eventObj));
	}


	@Test
	public void testParticipentRegistration()
	{
		
		assertTrue(registrationObj.registerParticipent(participentObj));
	}
	
	@Test
	public void testSponserRegistration()
	{
		assertTrue(registrationObj.registerSponser(sponserObj));
	}
	
	@Test
	public void testParticipentRegistrationForEvent()
	{
		registrationObj.registerEvent(eventObj);
		registrationObj.registerParticipent(participentObj);
		assertTrue(registrationObj.registerParticipentForEvent(participentObj,eventObj));
	}

	
	//Same Test Cases and Code for SponserRegistrationForEvent can be added no need to show here
	
	
}
