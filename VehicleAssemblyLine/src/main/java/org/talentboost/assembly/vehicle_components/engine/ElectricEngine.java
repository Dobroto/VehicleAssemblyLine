package org.talentboost.assembly.vehicle_components.engine;

import org.talentboost.assembly.factory.Constants;

public final class ElectricEngine implements IEngine{

	private final String emissionStandard = "euro6";

	@Override
	public double getPowerInKW() {
		return Constants.electricEnginePowerInKW;
	}

	@Override
	public String getEmissionStandard() {
		return this.emissionStandard;
	}

	@Override
	public double getPowerInHP() {
		return Constants.electricEnginePowerInKW * Constants.kWToHPConversionValue;
	}

	@Override
	public String getEngineSymbol() {
		return Constants.electricEngineSymbol;
	}

}
