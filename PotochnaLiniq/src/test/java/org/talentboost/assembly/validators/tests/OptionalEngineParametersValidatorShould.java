package org.talentboost.assembly.validators.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.validators.OptionalEngineParametersValidator;

public class OptionalEngineParametersValidatorShould {

	@Test
	public void checkInputEngineSpecsAvailability_NoTurboValidHorsePowerValueAndParameterPetrolEngine_ReturnTrue() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertTrue(oepv.checkInputEngineSpecsAvailability(false, "73.72", "hp", "b"));
	}

	@Test
	public void checkInputEngineSpecsAvailability_WithTurboValidHorsePowerValueAndParameterPetrolEngine_ReturnTrue() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertTrue(oepv.checkInputEngineSpecsAvailability(true, "96", "hp", "b"));
	}

	@Test
	public void checkInputEngineSpecsAvailability_ValidLiterValueAndParameterDieselEngine_ReturnTrue() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertTrue(oepv.checkInputEngineSpecsAvailability(true, "3", "l", "d"));
	}

	@Test
	public void checkInputEngineSpecsAvailability_NoTurboInvalidHorsePowerValueAndValidParameterPetrolEngine_ReturnFalse() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertFalse(oepv.checkInputEngineSpecsAvailability(false, "268", "hp", "b"));
	}

	@Test
	public void validate_validEngineTypeLiterTurboEuro3_ReturnTrue() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertTrue(oepv.validate("engine=B-5LT-euro3"));
	}

	@Test
	public void validate_validEngineTypeHorsePowerNoTurboEuro3_ReturnTrue() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertTrue(oepv.validate("engine=B-987hp-euro3"));
	}

	@Test
	public void validate_invalidEngineTypeHorsePowerNoTurboEuro3_ReturnFalse() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertFalse(oepv.validate("engine=D-987hp-euro3"));
	}
	
	@Test
	public void validate_validEngineTypeDieselHorsePowerNoTurboEuro3_ReturnTrue() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertTrue(oepv.validate("engine=D-197hp-euro3"));
	}
	
	@Test
	public void validate_validEngineTypeDieselHorsePowerTurboEuro3_ReturnFalse() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertFalse(oepv.validate("engine=D-197hpT-euro3"));
	}
	
	@Test
	public void validate_validEngineTypeElectricHorsePowerEuro3_ReturnFalse() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertFalse(oepv.validate("engine=E-717hp-euro3"));
	}
	
	@Test
	public void validate_validEngineTypeElectricHorsePowerEuro6_ReturnTrue() {
		OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
		assertTrue(oepv.validate("engine=E-717hp-euro6"));
	}
	
	
	
	
	
	
	
}
