package org.talentboost.assembly.vehicle_components.transmission;

import org.talentboost.assembly.factory.Constants;

public final class ManualTransmission implements ITransmission{
	
	private int numOfGears;
	
	public ManualTransmission(int numOfGears) {
		this.numOfGears = numOfGears;
	}
	
	@Override
	public String getTransmissionSymbol() {
		return Constants.manualTransmissionSymbol;
	}
	
	@Override
	public int getNumberOfGears() {
		return this.numOfGears;
	}
}
