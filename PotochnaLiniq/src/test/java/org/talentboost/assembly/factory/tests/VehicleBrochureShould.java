package org.talentboost.assembly.factory.tests;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.factory.VehicleBrochure;
import org.talentboost.assembly.vehicle_components.engine.EngineSpecifications;

public class VehicleBrochureShould {

	@Test
	public void getMapOfEnginePowerInKW_WithValidInRangeKWValueWhitoutTurbo_Succeeds() {
		VehicleBrochure vb = new VehicleBrochure();
		EngineSpecifications localEnSpec = new EngineSpecifications(false, Constants.petrolEngineSymbol);

		TreeMap<Double, EngineSpecifications> testMap;
		testMap = vb.getMapOfEnginePowerInKW();
		EngineSpecifications groupBelow = testMap.floorEntry(57.0).getValue();
		EngineSpecifications groupAbove = testMap.ceilingEntry(57.0).getValue();

		assertEquals(groupBelow.getIdOfSpecification(), groupAbove.getIdOfSpecification());
		assertEquals(groupBelow.getEngineTypeOne(), groupAbove.getEngineTypeOne());
		assertEquals(localEnSpec.getEngineTypeOne(), groupBelow.getEngineTypeOne());
		assertEquals(localEnSpec.getTurbo(), groupBelow.getTurbo());
	}

	@Test
	public void getMapOfEnginePowerInKW_WithValidKWValueWithTurbo_Succeeds() {
		VehicleBrochure vb = new VehicleBrochure();
		EngineSpecifications localEnSpec = new EngineSpecifications(true, Constants.petrolEngineSymbol);

		TreeMap<Double, EngineSpecifications> testMap;
		testMap = vb.getMapOfEnginePowerInKW();
		EngineSpecifications testSpecGiven = testMap.floorEntry((double) 71.5).getValue();

		assertEquals(testSpecGiven.getEngineTypeOne(), localEnSpec.getEngineTypeOne());
		assertEquals(testSpecGiven.getTurbo(), localEnSpec.getTurbo());
	}

	@Test
	public void getMapOfEnginePowerInKW_WithValidKWValueWithTurboElectricEngine_Succeeds() {
		VehicleBrochure vb = new VehicleBrochure();
		EngineSpecifications localEnSpec = new EngineSpecifications(false, Constants.electricEngineSymbol);

		TreeMap<Double, EngineSpecifications> testMap;
		testMap = vb.getMapOfEnginePowerInKW();
		EngineSpecifications testSpecGiven = testMap.floorEntry((double) 535).getValue();

		assertEquals(testSpecGiven.getEngineTypeOne(), localEnSpec.getEngineTypeOne());
		assertEquals(testSpecGiven.getTurbo(), localEnSpec.getTurbo());
	}

	/*@Test
	public void getMapOfEnginePowerInKW_WithInvalidKWValue_ReturnNull() {
		VehicleBrochure vb = new VehicleBrochure();

		TreeMap<Double, EngineSpecifications> testMap;
		testMap = vb.getMapOfEnginePowerInKW();
		assertEquals(null, testMap.floorEntry((double) 100).getValue());

	}*/

	@Test
	public void getMapOfEnginePowerInKW_WithValidKWValueInvalidTurbo_Fails() {
		VehicleBrochure vb = new VehicleBrochure();
		EngineSpecifications localEnSpec = new EngineSpecifications(false, Constants.petrolEngineSymbol);

		TreeMap<Double, EngineSpecifications> testMap;
		testMap = vb.getMapOfEnginePowerInKW();
		EngineSpecifications testSpecGiven = testMap.floorEntry((double) 71.5).getValue();

		assertNotEquals(testSpecGiven.getTurbo(), localEnSpec.getTurbo());
	}

	@Test
	public void getMapOfEngineDisplacement_WithValidCCValue_Succeeds() {
		VehicleBrochure vb = new VehicleBrochure();
		EngineSpecifications localEnSpec = new EngineSpecifications(Constants.petrolEngineSymbol);

		Map<Integer, EngineSpecifications> testMap;
		testMap = vb.getMapOfEngineDisplacementCC();
		EngineSpecifications testSpecGiven = testMap.get(1000);

		assertEquals(testSpecGiven.getEngineTypeOne(), localEnSpec.getEngineTypeOne());
	}
	
	@Test
	public void getMapOfEngineDisplacement_WithValidCCValueAndTwoPossibleEngines_Succeeds() {
		VehicleBrochure vb = new VehicleBrochure();
		EngineSpecifications localEnSpec = new EngineSpecifications(Constants.petrolEngineSymbol, Constants.dieselEngineSymbol);

		Map<Integer, EngineSpecifications> testMap;
		testMap = vb.getMapOfEngineDisplacementCC();
		EngineSpecifications testSpecGiven = testMap.get(2000);

		assertEquals(testSpecGiven.getEngineTypeOne(), localEnSpec.getEngineTypeOne());
		assertEquals(testSpecGiven.getEngineTypeTwo(), localEnSpec.getEngineTypeTwo());
	}
}
