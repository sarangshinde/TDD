package services;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.InputData;

public class InputServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_createObjectsFromInput_when_inputGiven() throws IOException {
		InputService inputService = new InputService();
		InputData inputData=inputService.createObjectsFromInput("/home/sarang/marseworkspace/GuestReview/TestInput");
		assertNotNull(inputData);
		
		
	}

}
