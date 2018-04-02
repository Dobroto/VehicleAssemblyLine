package org.talentboost.assembly.commands.tests;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.assembly.commands.CreateVehicleCommand;
import org.talentboost.assembly.vehicle_components.engine.DieselEngine;
import org.talentboost.assembly.vehicle_components.engine.ElectricEngine;
import org.talentboost.assembly.vehicle_components.engine.PetrolEngine;
import org.talentboost.assembly.vehicle_components.transmission.AutomaticTransmission;
import org.talentboost.assembly.vehicle_components.transmission.ManualTransmission;

public class CreateVehicleCommandShould {

	@Test
	public void getModelName_A5Hatchback_ReturnA5() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("A5", cvc.getModelName("model=A5-hatchback"));
	}

	@Test
	public void getModelName_A5NoModelType_ReturnA5() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("A5", cvc.getModelName("model=A5"));
	}

	@Test
	public void getModelType_A5Hatchback_ReturnHatchBack() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("hatchback", cvc.getModelType("model=A5-hatchback"));
	}
	
	@Test
	public void getModelType_A5NoModelType_ReturnNull() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(null, cvc.getModelType("model=A5"));
	}
	
	@Test
	public void getEngine_PetrolEngine_ReturnPetrolEngine() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertThat(cvc.getEngine("engine=B-100hp-euro3", null, null, false, null), instanceOf(PetrolEngine.class));
	}
	
	@Test
	public void getEngine_DieselEngine_ReturnDieselEngine() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertThat(cvc.getEngine("engine=D-100hp-euro3", null, null, false, null), instanceOf(DieselEngine.class));
	}
	
	@Test
	public void getEngine_ElectricEngine_ReturnElectricEngine() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertThat(cvc.getEngine("engine=E-100hp-euro3", null, null, false, null), instanceOf(ElectricEngine.class));
	}
	
	@Test
	public void getEngineMainParameters_100Hp_ReturnCorrectParams() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("b-100hp-euro3", cvc.getEngineMainParameters("engine=B-100hp-euro3"));
	}
	
	@Test
	public void getEngineMainParameters_OnlyFuelType_ReturnNull() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("b", cvc.getEngineMainParameters("engine=B"));
	}
	
	@Test
	public void getHorsePower_100Hp_ReturnCorrectParams() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("100", cvc.getHorsePower("d-100hp-euro3"));
	}
	
	@Test
	public void getHorsePower_1L_ReturnNull() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(null, cvc.getHorsePower("1L"));
	}
	
	@Test
	public void getHorsePower_OnlyEngine_ReturnNull() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(null, cvc.getHorsePower("d"));
	}
	
	@Test
	public void getEngineDisplacementLiters_1L_Return1() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("1", cvc.getEngineDisplacementLiters("d-1l-euro3"));
	}
	
	@Test
	public void getEngineDisplacementLiters_100hp_ReturnNull() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(null, cvc.getEngineDisplacementLiters("d-100hp"));
	}
	
	@Test
	public void getEngineDisplacementLiters_Null_ReturnNull() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(null, cvc.getEngineDisplacementLiters("D"));
	}
	
	@Test
	public void wantsTurbo_100hpT_ReturnTrue() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(true, cvc.wantsTurbo("d-100hpt"));
	}
	
	@Test
	public void wantsTurbo_100hp_ReturnFalse() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(false, cvc.wantsTurbo("d-100hp"));
	}
	
	@Test
	public void wantsTurbo_Null_ReturnFalse() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(false, cvc.wantsTurbo("d"));
	}
	
	@Test
	public void getEmmissionStandard_Petrol100hpEuro3_ReturnEuro3() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("euro3", cvc.getEmmissionStandard("engine=B-100hp-euro3"));
	}
	
	@Test
	public void getEmmissionStandard_Petrol100hp_ReturnNull() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(null, cvc.getEmmissionStandard("engine=B-100hp"));
	}
	
	@Test
	public void getEmmissionStandard_Petrol_ReturnNull() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(null, cvc.getEmmissionStandard("engine=B"));
	}
	
	@Test
	public void getTransmissionType_Auto_ReturnAuto() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("auto", cvc.getTransmissionType("transmission=Auto"));
	}
	
	@Test
	public void getTransmissionType_Auto4_ReturnAuto() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("auto", cvc.getTransmissionType("transmission=Auto-4"));
	}
	
	@Test
	public void getTransmissionGearNumber_Auto5_Return5() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("5", cvc.getTransmissionGearNumber("transmission=Auto-5"));
	}
	
	@Test
	public void getTransmissionGearNumber_Auto_Return4() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals(null, cvc.getTransmissionGearNumber("transmission=Auto"));
	}
	
	@Test
	public void getTransmission_Auto4_AutoTransmission() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertThat(cvc.getTransmission("auto", "s"), instanceOf(AutomaticTransmission.class));
	}
	
	@Test
	public void getTransmission_Manual4_ManualTransmission() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertThat(cvc.getTransmission("manual", "4"), instanceOf(ManualTransmission.class));
	}
	
	/*@Test
	public void execute_FullCommand_ProperOuput() {
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("VIN = BG212345678901235 Model = Q2 Type = hatchback Engine = D-197hp-euro3 Transmission = Manual-5",
				cvc.execute("suv model=Q2-hatchback engine=D-197hp transmission=Manual-5"));
	}*/
	
	@Test
	public void alkdfmasdmkfflmas(){
		CreateVehicleCommand cvc = new CreateVehicleCommand(null, null);
		assertEquals("B-2L-euro3", cvc.getEngineString("engine=b-2l", "2", null, false, null));
	}
}
