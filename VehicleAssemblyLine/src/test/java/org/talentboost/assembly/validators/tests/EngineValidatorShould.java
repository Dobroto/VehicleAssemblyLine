package org.talentboost.assembly.validators.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.validators.EngineValidator;

public class EngineValidatorShould {

	@Test
	public void validate_ValidPetrolEngine_ReturnTrue() {
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=B"));
	}

	@Test
	public void validate_ValidDieselEngine_ReturnTrue() {
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=D"));
	}

	@Test
	public void validate_ValidElectricEngine_ReturnTrue() {
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=E"));
	}

	@Test
	public void validate_ValidPetrolEngineLowerCase_ReturnTrue() {
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=b"));
	}

	@Test
	public void validate_InalidEngine_ReturnFalse() {
		EngineValidator ev = new EngineValidator();
		assertFalse(ev.validate("engine=F"));
	}

	@Test
	public void validate_ValidPetrolEngineInvalidPrefix_ReturnFalse() {
		EngineValidator ev = new EngineValidator();
		assertFalse(ev.validate("transmission=B"));
	}

	@Test
	public void validate_validEngineTypeLiterTurboEuro3_ReturnTrue() {
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=B-5LT-euro3"));
	}

	@Test
	public void validate_validEngineTypeHorsePowerNoTurboEuro3_ReturnTrue() {
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=B-987hp-euro3"));
	}

	@Test
	public void validate_invalidEngineTypeHorsePowerNoTurboEuro3_ReturnFalse() {
		EngineValidator ev = new EngineValidator();
		assertFalse(ev.validate("engine=D-987hp-euro3"));
	}

	@Test
	public void validate_validEngineTypeDieselHorsePowerNoTurboEuro3_ReturnTrue() {
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=D-197hp-euro3"));
	}

	@Test
	public void validate_validEngineTypeDieselHorsePowerTurboEuro3_ReturnFalse() {
		EngineValidator ev = new EngineValidator();
		assertFalse(ev.validate("engine=D-197hpT-euro3"));
	}

	@Test
	public void validate_validEngineTypeElectricHorsePowerEuro3_ReturnFalse() {
		EngineValidator ev = new EngineValidator();
		assertFalse(ev.validate("engine=E-717hp-euro3"));
	}

	@Test
	public void validate_validEngineTypeElectricHorsePowerEuro6_ReturnTrue() {
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=E-717hp-euro6"));
	}

}
