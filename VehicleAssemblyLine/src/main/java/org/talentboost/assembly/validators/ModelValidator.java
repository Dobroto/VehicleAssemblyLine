package org.talentboost.assembly.validators;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.vehicle_types.IVehicleType;

public class ModelValidator {

	VehicleTypeValidator vtv = new VehicleTypeValidator();

	/**
	 * The method validates the part of the command which clarifies the model (for
	 * example "model=A5-hatchback") It is checked if the string is given according
	 * to the specifications. A substring of the model is created (for example
	 * "A1"). The method parseVehicleType from VehicleTypeValidator is called.
	 * (Please read the documentation in that class for more information) The object
	 * of the vehicle type calls getAvailableVehicleModels which returns a set with
	 * all models (for car - A1..., for SUV - Q1...) and the model is checked
	 * whether it corresponds to any of them. If the string contains body
	 * configuration type, the BodyConfiguration Validator validates it.
	 * 
	 * @param vehicleTypeInput
	 * @param vehicleModelInput
	 * @return boolean does the model corresponds to the specific vehicle type
	 */
	public boolean validate(String vehicleTypeInput, String vehicleModelInput) {
		try {

			int indexOfEquals = vehicleModelInput.indexOf("=");
			if ((indexOfEquals == -1) || (!vehicleModelInput.startsWith("model="))) {
				System.out.println("Please enter a model in the agreed manner.");
				return false;
			}
			indexOfEquals++;
			String vehicleModel = vehicleModelInput.substring(indexOfEquals,
					indexOfEquals + Constants.vehicleModelRepresentationLength);

			IVehicleType vehicleType = vtv.parseVehicleType(vehicleTypeInput);

			if (vehicleType.getAvailableVehicleModels().contains(vehicleModel)) {
				if (vehicleModelInput.contains("-")) {
					BodyConfigurationValidator bcv = new BodyConfigurationValidator();
					return bcv.validate(vehicleModelInput);
				}
				return true;
			}

		} catch (NullPointerException ex) {
			System.out.println("Please enter valid model.");
		}

		return false;

	}

}
