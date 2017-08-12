package org.talentboost.assembly.validators.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.talentboost.assembly.validators.CountryValidator;

public class CountryValidatorShould {
	
	@Test
	public void validate_ValidCodeUpperCase_ReturnTrue() {
		CountryValidator cv = new CountryValidator();
		assertTrue(cv.validate("BG"));
	}

	@Test
	public void validate_InvalidCodeUpperCase_ReturnFalse() {
		CountryValidator cv = new CountryValidator();
		assertFalse(cv.validate("ZZ"));
	}
	
	@Test
	public void validate_ValidCodeLowerCase_ReturnTrue() {
		CountryValidator cv = new CountryValidator();
		assertTrue(cv.validate("bg"));
	}
	
	@Test
	public void validate_ValidCodeLowerCase_ReturnFalse() {
		CountryValidator cv = new CountryValidator();
		assertFalse(cv.validate("zz"));
	}
	
	
}
