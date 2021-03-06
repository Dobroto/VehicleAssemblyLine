package org.talentboost.assembly.vehicle_components.engine.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.vehicle_components.engine.ElectricEngine;

public class ElectricEngineShould {

	@Test
	public void toString_Electric718Hp_PrintCorrectly() {
		ElectricEngine ee = new ElectricEngine(null, "718", false, null);
		assertEquals("E-718hp-euro6", ee.toString());
	}
	
	@Test
	public void toString_Electric_PrintCorrectly() {
		ElectricEngine ee = new ElectricEngine(null, "717", false, null);
		assertEquals("E-717hp-euro6", ee.toString());
	}

}
