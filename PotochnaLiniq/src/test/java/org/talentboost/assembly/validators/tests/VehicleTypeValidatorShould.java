package org.talentboost.assembly.validators.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.validators.VehicleTypeValidator;
import org.talentboost.assembly.vehicle_types.Car;
import org.talentboost.assembly.vehicle_types.SUV;

public class VehicleTypeValidatorShould {

	@Test
	public void validate_ValidCarRepresentationLowerCase_ReturnTrue() {
		VehicleTypeValidator vtv = new VehicleTypeValidator();
		assertTrue(vtv.validate("car"));
	}

	@Test
	public void validate_ValidCarRepresentationUpperCase_ReturnTrue() {
		VehicleTypeValidator vtv = new VehicleTypeValidator();
		assertTrue(vtv.validate("CAR"));
	}

	@Test
	public void validate_ValidSUVRepresentationLowerCase_ReturnTrue() {
		VehicleTypeValidator vtv = new VehicleTypeValidator();
		assertTrue(vtv.validate("suv"));
	}

	@Test
	public void validate_ValidSUVRepresentationUpperCase_ReturnTrue() {
		VehicleTypeValidator vtv = new VehicleTypeValidator();
		assertTrue(vtv.validate("SUV"));
	}

	@Test
	public void validate_InvalidCarRepresentation_ReturnFalse() {
		VehicleTypeValidator vtv = new VehicleTypeValidator();
		assertFalse(vtv.validate("blah"));
	}

	@Test
	public void validate_InvalidSUVRepresentation_ReturnFalse() {
		VehicleTypeValidator vtv = new VehicleTypeValidator();
		assertFalse(vtv.validate("SUValka"));
	}

	@Test
	public void parseVehicleType_ValidCarRepresentation_SameType() {
		VehicleTypeValidator vtv = new VehicleTypeValidator();
		assertThat(vtv.parseVehicleType("car"), instanceOf(Car.class));
	}
	
	@Test
	public void parseVehicleType_ValidSUVRepresentation_SameType() {
		VehicleTypeValidator vtv = new VehicleTypeValidator();
		assertThat(vtv.parseVehicleType("suv"), instanceOf(SUV.class));
	}
}
