package org.talentboost.assembly.vehicle_components.transmission;

import org.talentboost.assembly.factory.Constants;

public class AutomaticTransmission implements ITransmission{

	private int numOfGears;
	
	public AutomaticTransmission(int numOfGears) {
		this.numOfGears = numOfGears;
	}
	
	@Override
	public String getTransmissionSymbol() {
		return Constants.automaticTransmissionSymbol;
	}

	@Override
	public int getNumberOfGears() {
		return this.numOfGears;
	}

}
