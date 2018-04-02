package org.talentboost.assembly.validators.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.validators.TransmissionValidator;

public class TransmissionValidatorShould {

	@Test
	public void checkTransmissionGears_AutomaticFourGears_ReturnTrue() {
		TransmissionValidator tv = new TransmissionValidator();
		assertTrue(tv.checkTransmissionGears("auto", "4"));
	}

	@Test
	public void checkTransmissionGears_AutomaticEightGears_ReturnTrue() {
		TransmissionValidator tv = new TransmissionValidator();
		assertTrue(tv.checkTransmissionGears("auto", "8"));
	}

	@Test
	public void checkTransmissionGears_ManualFourGears_ReturnTrue() {
		TransmissionValidator tv = new TransmissionValidator();
		assertTrue(tv.checkTransmissionGears("manual", "4"));
	}
	
	@Test
	public void checkTransmissionGears_ManualEightGears_ReturnFalse() {
		TransmissionValidator tv = new TransmissionValidator();
		assertFalse(tv.checkTransmissionGears("manual", "8"));
	}
	
	@Test
	public void checkTransmissionGears_AutoNineGears_ReturnFalse() {
		TransmissionValidator tv = new TransmissionValidator();
		assertFalse(tv.checkTransmissionGears("auto", "9"));
	}
	
	@Test
	public void validate_AutoNoGears_ReturnTrue() {
		TransmissionValidator tv = new TransmissionValidator();
		assertTrue(tv.validate("transmission=Auto"));
	}
	
	@Test
	public void validate_AutoWithFourGears_ReturnTrue() {
		TransmissionValidator tv = new TransmissionValidator();
		assertTrue(tv.validate("transmission=Auto-4"));
	}
	
	@Test
	public void validate_ManualWithFourGears_ReturnTrue() {
		TransmissionValidator tv = new TransmissionValidator();
		assertTrue(tv.validate("transmission=Manual-4"));
	}
	
	@Test
	public void validate_invalidPrefixManualWithFourGears_ReturnFalse() {
		TransmissionValidator tv = new TransmissionValidator();
		assertFalse(tv.validate("engine=Manual-4"));
	}
	
	
	
}
