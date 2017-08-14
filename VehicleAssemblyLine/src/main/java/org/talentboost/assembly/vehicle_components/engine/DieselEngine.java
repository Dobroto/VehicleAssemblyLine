package org.talentboost.assembly.vehicle_components.engine;

import org.talentboost.assembly.factory.Constants;

public class DieselEngine implements IEngine{
	
	private String engineDisplacementLiters;
	private String horsePower;
	private boolean hasTurbo;
	private String emissionStandard;
	private String typeOfFuel = "P";
	
	
	public DieselEngine(String engineDisplacementLiters, String horsePower,
			boolean hasTurbo, String emissionStandard) {
		
		this.engineDisplacementLiters = engineDisplacementLiters;
		this.horsePower = horsePower;
		this.hasTurbo = hasTurbo;
		this.emissionStandard = emissionStandard;
	}

	

	


}
