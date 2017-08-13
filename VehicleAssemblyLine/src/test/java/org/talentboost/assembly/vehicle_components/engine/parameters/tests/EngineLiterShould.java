package org.talentboost.assembly.vehicle_components.engine.parameters.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.vehicle_components.engine.parameters.EngineLiter;

public class EngineLiterShould {

	@Test
	public void turnFromLiterToCC_RandomLiterValue_CorrectOutput() {
		EngineLiter el = new EngineLiter();
		assertEquals(2000, el.turnFromLiterToCC("2"));
	}

	@Test
	public void checkAvailability_ValidLiterValuePetrolEngineType_Succeeds() {
		EngineLiter el = new EngineLiter();
		assertTrue(el.checkAvailability("1", false, "b"));
	}
	
	@Test
	public void checkAvailability_ValidLiterValueDieselEngineType_Succeeds() {
		EngineLiter el = new EngineLiter();
		assertTrue(el.checkAvailability("3", false, "d"));
	}
	
	@Test
	public void checkAvailability_ValidLiterValueElectricEngineType_Fails() {
		EngineLiter el = new EngineLiter();
		assertFalse(el.checkAvailability("8", false, "e"));
	}
	
	@Test
	public void checkAvailability_invalidLiterValueDieselEngineType_Fails() {
		EngineLiter el = new EngineLiter();
		assertFalse(el.checkAvailability("1", false, "d"));
	}
}
