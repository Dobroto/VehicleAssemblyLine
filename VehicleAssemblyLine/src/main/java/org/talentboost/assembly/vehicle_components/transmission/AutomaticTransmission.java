package org.talentboost.assembly.vehicle_components.transmission;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.factory.VehicleBrochure;

public class AutomaticTransmission implements ITransmission {

	private int numOfGears;

	public AutomaticTransmission() {
		this.numOfGears = Constants.defaultNumberOfGears;
	}

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

	@Override
	public boolean validateGearNumber(String gearNumber) {
		return VehicleBrochure.automaticGearsNumber.contains(gearNumber);

	}

}
