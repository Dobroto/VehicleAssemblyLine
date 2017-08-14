package org.talentboost.assembly.validators.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.validators.CreateVehicleCommandValidator;

public class CreateVehicleCommandValidatorShould {

	@Test
	public void validate_CarA5HatchbackPetrol197HPEuro3TransmissionAuto4_ReturnTrue() {
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		assertTrue(cvcv.validate("car model=A5-hatchback engine=B-197hp-euro3 transmission=Auto-4"));
	}

	@Test
	public void validate_CarA5HatchbackPetrol100HPEuro3TransmissionAuto4_ReturnFalse() {
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		assertFalse(cvcv.validate("car model=A5-hatchback engine=B-100hp-euro3 transmission=Auto-4"));
	}
	
	@Test
	public void validate_CarA5Diesel6LTurboEuro3_ReturnTrue() {
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		assertTrue(cvcv.validate("car model=A5 engine=D-6LT-euro3"));
	}
	
	@Test
	public void validate_SuvQ2Diesel6LTurboTransmissionManual5_ReturnTrue() {
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		assertTrue(cvcv.validate("suv model=Q2 engine=D-6LT transmission=Manual-5"));
	}
	
	@Test
	public void validate_CarA4Petrol427Hp_ReturnTrue() {
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		assertTrue(cvcv.validate("car model=A4 engine=B-427hp"));
	}
	
	@Test
	public void validate_CarA4Petrol427HpEuro5_ReturnTrue() {
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		assertTrue(cvcv.validate("car model=A4 engine=B-427hp-euro5"));
	}
	
	@Test
	public void validate_CarA8Electric_ReturnTrue() {
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		assertTrue(cvcv.validate("car model=A8 engine=E"));
	}
	
	@Test
	public void validate_CarA8Electric718Hp_ReturnTrue() {
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		assertTrue(cvcv.validate("car model=A8 engine=E-718hp"));
	}
	
	@Test
	public void validate_SuvQ1Petrol97HpEuro5_ReturnTrue() {
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		assertTrue(cvcv.validate("suv model=Q1 engine=B-97hp-euro5"));
	}
	
	@Test
	public void validate_SuvA1Petrol97HpEuro5_ReturnFalse() {
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		assertFalse(cvcv.validate("suv model=A1 engine=B-97hp-euro5"));
	}
	
}
