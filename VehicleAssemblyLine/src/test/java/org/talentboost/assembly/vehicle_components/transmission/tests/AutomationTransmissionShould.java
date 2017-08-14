package org.talentboost.assembly.vehicle_components.transmission.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.vehicle_components.transmission.AutomaticTransmission;

public class AutomationTransmissionShould {

	@Test
	public void toString_AutoDefaultGears_PrintCorrectly() {
		AutomaticTransmission at = new AutomaticTransmission();
		
		assertEquals("Auto-4", at.toString());
	}

	@Test
	public void toString_AutoFiveGears_PrintCorrectly() {
		AutomaticTransmission at = new AutomaticTransmission(5);
		
		assertEquals("Auto-5", at.toString());
	}
}
