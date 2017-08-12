package org.talentboost.assembly.validators.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.validators.ModelValidator;

public class ModelValidatorShould {
	
	
	@Test
	public void validate_ValidCarWithValidCarModel_ReturnTrue() {
		ModelValidator mv = new ModelValidator();
		assertTrue(mv.validate("car", "model=A5"));
	}

	@Test
	public void validate_ValidSUVWithValidSUVModel_ReturnTrue() {
		ModelValidator mv = new ModelValidator();
		assertTrue(mv.validate("suv", "model=Q5"));
	}
	
	@Test
	public void validate_ValidCarWithValidSUVModel_ReturnFalse() {
		ModelValidator mv = new ModelValidator();
		assertFalse(mv.validate("car", "model=Q5"));
	}
	
	@Test
	public void validate_ValidSUVWithValidCarModel_ReturnFalse() {
		ModelValidator mv = new ModelValidator();
		assertFalse(mv.validate("suv", "model=A5"));
	}
	
	@Test
	public void validate_InvalidCarWithValidCarModel_ReturnFalse() {
		ModelValidator mv = new ModelValidator();
		assertFalse(mv.validate("blah", "model=A5"));
	}
	
	@Test
	public void validate_InvalidVehicleWithInvalidVehicleModel_ReturnFalse() {
		ModelValidator mv = new ModelValidator();
		assertFalse(mv.validate("blah", "model=M4"));
	}
	
	@Test
	public void validate_ValidVehicleWithInvalidVehicleModel_ReturnFalse() {
		ModelValidator mv = new ModelValidator();
		assertFalse(mv.validate("car", "blah"));
	}
	
	@Test
	public void validate_ValidVehicleWithInvalidModelSubstring_ReturnFalse() {
		ModelValidator mv = new ModelValidator();
		assertFalse(mv.validate("car", "podel=A4"));
	}
	
	@Test
	public void validate_validVehicleAndModelAndConfType_ReturnTrue() {
		ModelValidator mv = new ModelValidator();
		assertTrue(mv.validate("car", "model=A4-hatchback"));
	}
	
	@Test
	public void validate_validVehicleAndModelAndInvalidConfType_ReturnFalse() {
		ModelValidator mv = new ModelValidator();
		assertFalse(mv.validate("car", "model=A4-tank"));
	}
	
	@Test
	public void validate_invalidVehicleAndModelAndValidConfType_ReturnFalse() {
		ModelValidator mv = new ModelValidator();
		assertFalse(mv.validate("bicycle", "model=A4-tank"));
	}
	

}
