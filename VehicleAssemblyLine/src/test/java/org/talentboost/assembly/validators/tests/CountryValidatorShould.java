package org.talentboost.assembly.validators.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talentboost.assembly.validators.CountryValidator;

public class CountryValidatorShould {
	
	@Test
	public void validate_validCodeUpperCase_returnTrue() {
		CountryValidator cv = new CountryValidator();
		assertTrue(cv.validate("BG"));
	}

	@Test
	public void validate_unvalidCodeUpperCase_returnFalse() {
		CountryValidator cv = new CountryValidator();
		assertFalse(cv.validate("ZZ"));
	}
	
	@Test
	public void validate_validCodeLowerCase_returnTrue() {
		CountryValidator cv = new CountryValidator();
		assertTrue(cv.validate("bg"));
	}
	
	@Test
	public void validate_validCodeLowerCase_returnFalse() {
		CountryValidator cv = new CountryValidator();
		assertFalse(cv.validate("zz"));
	}
	
	
}
