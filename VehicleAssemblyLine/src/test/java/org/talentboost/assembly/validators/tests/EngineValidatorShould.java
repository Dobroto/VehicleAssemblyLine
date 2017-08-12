package org.talentboost.assembly.validators.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.validators.EngineValidator;

public class EngineValidatorShould {

	@Test
	public void validate_ValidPetrolEngine_ReturnTrue(){
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=B"));
	}
	
	@Test
	public void validate_ValidDieselEngine_ReturnTrue(){
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=D"));
	}
	
	@Test
	public void validate_ValidElectricEngine_ReturnTrue(){
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=E"));
	}
	
	public void validate_ValidPetrolEngineLowerCase_ReturnTrue(){
		EngineValidator ev = new EngineValidator();
		assertTrue(ev.validate("engine=b"));
	}
	
	@Test
	public void validate_InalidEngine_ReturnFalse(){
		EngineValidator ev = new EngineValidator();
		assertFalse(ev.validate("engine=F"));
	}
	
	@Test
	public void validate_ValidPetrolEngineInvalidPrefix_ReturnFalse(){
		EngineValidator ev = new EngineValidator();
		assertFalse(ev.validate("transmission=B"));
	}
	

}
