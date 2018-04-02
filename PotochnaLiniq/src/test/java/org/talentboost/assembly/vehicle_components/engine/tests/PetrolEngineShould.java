package org.talentboost.assembly.vehicle_components.engine.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.vehicle_components.engine.PetrolEngine;

public class PetrolEngineShould {

	@Test
	public void toString_Petrol100HpTurboEuro3_PrintCorrectly() {
		PetrolEngine pe = new PetrolEngine(null, "100", true, "euro3");

		assertEquals("B-100hpT-euro3", pe.toString());
	}

	@Test
	public void toString_Petrol6L_PrintCorrectly() {
		PetrolEngine pe = new PetrolEngine("6", null, false, null);

		assertEquals("B-6L-euro3", pe.toString());
	}

}
