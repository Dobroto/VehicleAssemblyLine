package org.talentboost.assembly.validators.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talentboost.assembly.validators.FactoryNumberValidator;

public class FactoryNumberValidatorShould {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
	
	@Test
	public void validate_validNumber_returnTrue() {
		FactoryNumberValidator fnv = new FactoryNumberValidator();
		assertTrue(fnv.validate("3"));
	}
	
	@Test
	public void validate_validNumberCornerCase_returnTrue() {
		FactoryNumberValidator fnv = new FactoryNumberValidator();
		assertTrue(fnv.validate("9"));
	}
	
	@Test
	public void validate_unvalidNumber_returnFalse() {
		FactoryNumberValidator fnv = new FactoryNumberValidator();
		assertFalse(fnv.validate("42"));
	}
	
	@Test
	public void validate_unvalidNumberCornerCase_returnFalse() {
		FactoryNumberValidator fnv = new FactoryNumberValidator();
		assertFalse(fnv.validate("10"));
	}
	
	@Test
	public void validate_unvalidNumberNegative_returnFalse() {
		FactoryNumberValidator fnv = new FactoryNumberValidator();
		assertFalse(fnv.validate("-10"));
	}
	
	@Test 
	public void validate_unvalidFormat_returnExceptionMessage() {
		FactoryNumberValidator fnv = new FactoryNumberValidator();
		fnv.validate("ten");
		assertEquals("Please enter a number from 0 to 9.", outContent.toString().trim());
	}

}
