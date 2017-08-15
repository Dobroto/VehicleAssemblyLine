package org.talentboost.assembly.vehicle_components.transmission;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.factory.VehicleBrochure;

public final class ManualTransmission implements ITransmission {

	private String numOfGears;
	private String nameOfTransmission = "Manual";


	public ManualTransmission(String numOfGears) {
		this.numOfGears = numOfGears;
	}

	@Override
	public String getTransmissionSymbol() {
		return Constants.manualTransmissionSymbol;
	}

	@Override
	public String getNumberOfGears() {
		return this.numOfGears;
	}

	@Override
	public boolean validateGearNumber(String gearNumber) {
		return VehicleBrochure.manualGearsNumber.contains(gearNumber);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nameOfTransmission + "-");

		if(numOfGears != null) {
			sb.append(numOfGears);
		}
		else {
			sb.append(Constants.defaultNumberOfGears);
		}

		return sb.toString();
	}
	
	
}
