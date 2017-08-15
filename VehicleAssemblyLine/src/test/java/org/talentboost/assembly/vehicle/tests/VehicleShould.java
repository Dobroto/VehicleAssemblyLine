package org.talentboost.assembly.vehicle.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.vehicle.Vehicle;
import org.talentboost.assembly.vehicle_components.engine.DieselEngine;
import org.talentboost.assembly.vehicle_components.engine.PetrolEngine;
import org.talentboost.assembly.vehicle_components.transmission.AutomaticTransmission;
import org.talentboost.assembly.vehicle_components.transmission.ManualTransmission;

public class VehicleShould {
	
	
	@Test
	public void toString_VinModelQ2EngineD6LTTransmissionManual5_PrintCorrectly() {
		
		DieselEngine engine = new DieselEngine("6", null, false, null);
		ManualTransmission transmission = new ManualTransmission("5");
		
		Vehicle vehicle = new Vehicle.VehicleBuilder("BG212345678901235", "Q2", "HatchBack")
				.engine(engine).transmission(transmission).build();
		
		assertEquals("VIN = BG212345678901235 Model = Q2 Type = HatchBack Engine = D-6L-euro3 Transmission = Manual-5",
				vehicle.toString());
	}
	
	@Test
	public void toString_VinModelA2EnginePetrol197HPTurboEuro5TransmissionAuto4_PrintCorrectly() {
		
		PetrolEngine engine = new PetrolEngine(null, "197", true, "euro5");
		AutomaticTransmission transmission = new AutomaticTransmission("4");
		
		Vehicle vehicle = new Vehicle.VehicleBuilder("BG212345678901235", "A2", null)
				.engine(engine).transmission(transmission).build();
		
		assertEquals("VIN = BG212345678901235 Model = A2 Type = Sedan Engine = B-197hpT-euro5 Transmission = Auto-4",
				vehicle.toString());
	}
	
	
	
	
	

}
