package org.talentboost.assembly.vehicle_components.engine;

import org.talentboost.assembly.factory.Constants;

public final class PetrolEngine implements IEngine {

	private String engineDisplacementLiters;
	private String horsePower;
	private boolean hasTurbo;
	private String emissionStandard;
	private String typeOfFuel = "B";

	public PetrolEngine(String engineDisplacementLiters, String horsePower,
			boolean hasTurbo, String emissionStandard) {
		this.engineDisplacementLiters = engineDisplacementLiters;
		this.horsePower = horsePower;
		this.hasTurbo = hasTurbo;
		this.emissionStandard = emissionStandard;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.typeOfFuel + "-");
		if (this.horsePower != null) {
			sb.append(this.horsePower + "hp");
		}
		if (this.engineDisplacementLiters != null) {
			sb.append(this.engineDisplacementLiters + "L");
		}
		if (this.hasTurbo) {
			sb.append("T-");
		} else {
			sb.append("-");
		}
		if (this.emissionStandard == null) {
			sb.append(Constants.defaultEuroStandard);
		} else {
			sb.append(this.emissionStandard);
		}

		return sb.toString();

	}

}
