package org.talentboost.assembly.validators.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.validators.BodyConfigurationValidator;

public class BodyConfigurationValidatorShould {

	@Test
	public void validate_ValidBodyConfiguration_ReturnTrue() {
		BodyConfigurationValidator bcv = new BodyConfigurationValidator();
		assertTrue(bcv.validate("hatchback"));
	}
	
	@Test
	public void validate_InvalidBodyConfiguration_ReturnFalse() {
		BodyConfigurationValidator bcv = new BodyConfigurationValidator();
		assertFalse(bcv.validate("hatchback-coupe"));
	}

}
