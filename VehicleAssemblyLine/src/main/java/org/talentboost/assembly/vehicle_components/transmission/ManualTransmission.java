package org.talentboost.assembly.vehicle_components.transmission;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.factory.VehicleBrochure;

public final class ManualTransmission implements ITransmission {

	private int numOfGears;

	public ManualTransmission() {
		this.numOfGears = Constants.defaultNumberOfGears;
	}

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

	@Override
	public boolean validateGearNumber(String gearNumber) {
		return VehicleBrochure.manualGearsNumber.contains(gearNumber);
	}
}
