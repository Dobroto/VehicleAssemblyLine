package org.talentboost.assembly.vehicle_components.engine;

import org.talentboost.assembly.factory.Constants;

public final class ElectricEngine implements IEngine {

	private String horsePower;
	private String typeOfFuel = "E";

	public ElectricEngine(String engineDisplacementLiters, String horsePower,
			boolean hasTurbo, String emissionStandard) {
		this.horsePower = horsePower;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.typeOfFuel + "-");
		if (this.horsePower != null) {
			sb.append(this.horsePower + "hp-");
		} else {
			sb.append(Constants.electronicEngineHP + "hp-");
		}
		sb.append(Constants.electricEuroStandard);

		return sb.toString();

	}
}
