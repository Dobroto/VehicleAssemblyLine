package org.talentboost.assembly.validators;

public class CreateVehicleCommandValidator implements IValidator {

	boolean transmissionResult = true;

	@Override
	public boolean validate(String commandArguments) {
		VehicleTypeValidator vtv = new VehicleTypeValidator();
		ModelValidator mv = new ModelValidator();
		EngineValidator ev = new EngineValidator();

		String[] splittedCommandArguments = commandArguments.split(" ");

		if (splittedCommandArguments.length > 3) {
			TransmissionValidator tv = new TransmissionValidator();
			transmissionResult = tv.validate(splittedCommandArguments[3]);
		}

		String vehicleType = splittedCommandArguments[0];
		String modelArguments = splittedCommandArguments[1];
		String engineArguments = splittedCommandArguments[2];

		if (vtv.validate(vehicleType) 
			&& mv.validate(vehicleType, modelArguments) 
			&& ev.validate(engineArguments)
			&& transmissionResult) {
			return true;
		}

		return false;

	}

}
