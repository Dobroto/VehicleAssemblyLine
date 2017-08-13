package org.talentboost.assembly.vehicle_components.engine.parameters.tests;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Test;
import org.talentboost.assembly.factory.VehicleBrochure;
import org.talentboost.assembly.vehicle_components.engine.EngineSpecifications;
import org.talentboost.assembly.vehicle_components.engine.parameters.HorsePower;

public class HorsePowerShould {

	@Test
	public void turnFromHpToKw_randomHp_getKw() {
		HorsePower hp = new HorsePower();
		assertEquals(0, Double.compare(74.5, hp.turnFromHpToKw("100")));
		
	}

	@Test
	public void turnFromHpToKw_secondRandomHp_getKw() {
		HorsePower hp = new HorsePower();
		assertEquals(0, Double.compare(111.75, hp.turnFromHpToKw("150")));
		
	}
	
	@Test
	public void checkAvailability_ValidHPNoTurboEgineTypePetrol_succeeds() {
		HorsePower hp = new HorsePower();
		VehicleBrochure brochure = new VehicleBrochure();
		TreeMap<Double, EngineSpecifications> enginePowerKWMap = brochure.getMapOfEnginePowerInKW();
		
		EngineSpecifications groupBelow = enginePowerKWMap.floorEntry(56.0).getValue();
		EngineSpecifications groupAbove = enginePowerKWMap.ceilingEntry(56.0).getValue();
		
		assertEquals(groupBelow.getEngineTypeOne(), "b");
		assertEquals(groupBelow.getTurbo(), false);
	}
	
	@Test
	public void checkAvailability_ValidHPWithTurboEgineTypePetrol_succeeds() {
		HorsePower hp = new HorsePower();
		VehicleBrochure brochure = new VehicleBrochure();
		TreeMap<Double, EngineSpecifications> enginePowerKWMap = brochure.getMapOfEnginePowerInKW();
		
		EngineSpecifications groupBelow = enginePowerKWMap.floorEntry(71.0).getValue();
		EngineSpecifications groupAbove = enginePowerKWMap.ceilingEntry(71.0).getValue();
		
		assertEquals(groupBelow.getEngineTypeOne(), "b");
		assertEquals(groupBelow.getTurbo(), true);
	}
	
	@Test
	public void checkAvailability_ValidHPNoTurboEgineTypePetrolAndDiesel_succeeds() {
		HorsePower hp = new HorsePower();
		VehicleBrochure brochure = new VehicleBrochure();
		TreeMap<Double, EngineSpecifications> enginePowerKWMap = brochure.getMapOfEnginePowerInKW();
		
		EngineSpecifications groupBelow = enginePowerKWMap.floorEntry(147.3).getValue();
		EngineSpecifications groupAbove = enginePowerKWMap.ceilingEntry(147.3).getValue();
		
		assertEquals(groupBelow.getEngineTypeOne(), "b");
		assertEquals(groupBelow.getEngineTypeTwo(), "d");
		assertEquals(groupBelow.getTurbo(), false);
	}
	
	@Test
	public void checkAvailability_ValidHPNoTurboEngineTypeElectric_succeeds() {
		HorsePower hp = new HorsePower();
		VehicleBrochure brochure = new VehicleBrochure();
		TreeMap<Double, EngineSpecifications> enginePowerKWMap = brochure.getMapOfEnginePowerInKW();
		
		EngineSpecifications groupBelow = enginePowerKWMap.floorEntry(535.2).getValue();
		EngineSpecifications groupAbove = enginePowerKWMap.ceilingEntry(535.2).getValue();
		
		assertEquals(groupBelow.getEngineTypeOne(), "e");
		assertEquals(groupBelow.getTurbo(), false);
	}
	

	@Test
	public void checkAvailability_invalidHPNoTurboEngineTypePetrol_fails() {
		HorsePower hp = new HorsePower();
		
		assertFalse(hp.checkAvailability("71", false, "b"));
	}
	
	@Test
	public void checkAvailability_validHPWithTurboEngineTypePetrol_succeeds() {
		HorsePower hp = new HorsePower();
		
		assertTrue(hp.checkAvailability("95.84", true, "b"));
	}
	
	@Test
	public void checkAvailability_validHPNoTurboEngineTypePetrol_succeeds() {
		HorsePower hp = new HorsePower();
		
		assertTrue(hp.checkAvailability("73.72", false, "b"));
	}
	
	@Test
	public void checkAvailability_validHPWithInvalidTurboEngineTypePetrol_fails() {
		HorsePower hp = new HorsePower();
		
		assertFalse(hp.checkAvailability("73.72", true, "b"));
	}
	
	@Test
	public void checkAvailability_validHPNoTurboEngineTypeDiesel_succeeds() {
		HorsePower hp = new HorsePower();
		
		assertTrue(hp.checkAvailability("197", false, "d"));
	}
	
	
}
