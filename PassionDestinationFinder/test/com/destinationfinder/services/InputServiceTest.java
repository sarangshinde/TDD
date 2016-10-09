package com.destinationfinder.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.destinationfinder.model.InputDetail;

public class InputServiceTest {

@Test
	public void should_returnInputFromStdIn_when_provided() {
		InputService inputService = new InputService();
		InputDetail inputDetail = inputService.readInput(System.in);
		assertNotNull(inputDetail);
	}


}
