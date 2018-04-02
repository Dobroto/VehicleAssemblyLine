package org.talentboost.assembly.factory.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.factory.VINCreator;

public class VINCreatorShould {

	@Test
	public void createVIN_validInput_returnStringWithLength17() {
		VINCreator vc = new VINCreator("BG", "6");
		assertEquals(17, vc.createVIN().length());
	}

}
