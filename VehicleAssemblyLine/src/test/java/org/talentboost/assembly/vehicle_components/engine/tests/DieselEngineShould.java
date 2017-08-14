package org.talentboost.assembly.vehicle_components.engine.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.vehicle_components.engine.DieselEngine;
import org.talentboost.assembly.vehicle_components.engine.PetrolEngine;

public class DieselEngineShould {

	@Test
	public void toString_Diesel100HpTurboEuro3_PrintCorrectly() {
		DieselEngine de = new DieselEngine(null, "100", true, "euro3");

		assertEquals("D-100hpT-euro3", de.toString());
	}

	@Test
	public void toString_Diesel6L_PrintCorrectly() {
		DieselEngine de = new DieselEngine("6", null, false, null);

		assertEquals("D-6L-euro3", de.toString());
	}

}
