package org.talentboost.assembly.vehicle_components.transmission.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.vehicle_components.transmission.AutomaticTransmission;
import org.talentboost.assembly.vehicle_components.transmission.ManualTransmission;

public class ManualTransmissionShould {

	@Test
	public void toString_ManualDefaultGears_PrintCorrectly() {
		ManualTransmission mt = new ManualTransmission();
		
		assertEquals("Manual-4", mt.toString());
	}

	@Test
	public void toString_AutoFiveGears_PrintCorrectly() {
		ManualTransmission mt = new ManualTransmission(5);
		
		assertEquals("Manual-5", mt.toString());
	}

}
