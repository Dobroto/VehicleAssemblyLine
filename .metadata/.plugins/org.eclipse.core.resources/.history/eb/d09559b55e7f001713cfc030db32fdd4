package org.talentboost.assembly.vehicle_components.engine;

import org.talentboost.assembly.factory.Constants;

public class DieselEngine implements IEngine{
	
	private int engineDisplacementCC;
	private int powerInKW;
	private boolean hasTurbo;
	private String emissionStandard;
	
	
	public DieselEngine(int engineDisplacementCC, int powerInKW, 
			boolean hasTurbo, String emissionStandard) {
		
		this.engineDisplacementCC = engineDisplacementCC;
		this.powerInKW = powerInKW;
		this.hasTurbo = hasTurbo;
		this.emissionStandard = emissionStandard;
	}

	public int getEngineDisplacementInCC() {
		return this.engineDisplacementCC;
	}

	@Override
	public double getPowerInKW() {
		return this.powerInKW;
	}
	
	@Override
	public double getPowerInHP() {
		return this.powerInKW * Constants.kWToHPConversionValue;
	}

	
	public boolean hasTurbo() {
		return this.hasTurbo;
	}
	
	public double getPowerWithTurboInHP() {
		return getPowerInHP() * Constants.powerIncreaseWithTurbo;
	}

	@Override
	public String getEmissionStandard() {
		return this.emissionStandard;
	}

	@Override
	public char getEngineSymbol() {
		return Constants.dieselEngineSymbol;
	}


}
