package org.talentboost.assembly.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.factory.VINCreator;
import org.talentboost.assembly.parsers.engine_parameters_parsers.EngineParametersParser;
import org.talentboost.assembly.parsers.engine_parameters_parsers.HorsePowerParser;
import org.talentboost.assembly.parsers.engine_parameters_parsers.LiterParser;
import org.talentboost.assembly.parsers.engine_parsers.DieselEngineParser;
import org.talentboost.assembly.parsers.engine_parsers.ElectricEngineParser;
import org.talentboost.assembly.parsers.engine_parsers.EngineParser;
import org.talentboost.assembly.parsers.engine_parsers.PetrolEngineParser;
import org.talentboost.assembly.parsers.transmission_parsers.AutomaticTransmissionParser;
import org.talentboost.assembly.parsers.transmission_parsers.ManualTransmissionParser;
import org.talentboost.assembly.parsers.transmission_parsers.TransmissionParser;
import org.talentboost.assembly.validators.CreateVehicleCommandValidator;
import org.talentboost.assembly.vehicle.Vehicle;
import org.talentboost.assembly.vehicle_components.engine.IEngine;
import org.talentboost.assembly.vehicle_components.transmission.ITransmission;
import org.talentboost.assembly.vehicle_components.transmission.ManualTransmission;

public class CreateVehicleCommand implements ICommand {

	private String commandName = "create";

	private Map<String, EngineParser> engineParserMap;
	private Map<String, EngineParametersParser> engineParametersParserMap;
	private Map<String, TransmissionParser> transmissionParserMap;
	private String countryCode;
	private String factoryNum;

	public CreateVehicleCommand(String countryCode, String factoryNum) {
		engineParserMap = new HashMap<String, EngineParser>();
		engineParserMap.put(Constants.petrolEngineSymbol, new PetrolEngineParser());
		engineParserMap.put(Constants.dieselEngineSymbol, new DieselEngineParser());
		engineParserMap.put(Constants.electricEngineSymbol, new ElectricEngineParser());

		engineParametersParserMap = new HashMap<String, EngineParametersParser>();
		engineParametersParserMap.put(Constants.horsePowerSuffix, new HorsePowerParser());
		engineParametersParserMap.put(Constants.literSuffix, new LiterParser());

		transmissionParserMap = new HashMap<String, TransmissionParser>();
		transmissionParserMap.put(Constants.automaticTransmissionSymbol, new AutomaticTransmissionParser());
		transmissionParserMap.put(Constants.manualTransmissionSymbol, new ManualTransmissionParser());

		this.countryCode = countryCode;
		this.factoryNum = factoryNum;
	}

	@Override
	public String getCommandName() {
		return this.commandName;
	}

	@Override
	public String execute(String input) {

		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		if (!cvcv.validate(input)) {
			return "Please enter valid vehicle.";
		}

		String[] splitInput = input.split(" ");

		String modelName = getModelName(splitInput[1]);
		String modelType = getModelType(splitInput[1]);

		String mainEngineParameters = getEngineMainParameters(splitInput[2]);
		String engineDisplacementLiters = getEngineDisplacementLiters(mainEngineParameters);
		String horsePower = getHorsePower(mainEngineParameters);
		boolean hasTurbo = wantsTurbo(mainEngineParameters);
		String emmissionStandard = getEmmissionStandard(splitInput[2]);
		IEngine engine = getEngine(splitInput[2], engineDisplacementLiters, horsePower, hasTurbo, emmissionStandard);
		String transmissionParameters = null;
		ITransmission transmission;

		try {
			transmissionParameters = splitInput[3];
			String trasmissionType = getTransmissionType(transmissionParameters);
			String trasmissionGearNumber = getTransmissionGearNumber(transmissionParameters);
			transmission = getTransmission(trasmissionType, trasmissionGearNumber);

		} catch (IndexOutOfBoundsException ex) {
			transmission = new ManualTransmission(Constants.defaultNumberOfGears);
		}

		VINCreator vinCreator = new VINCreator(countryCode, factoryNum);

		String vin = vinCreator.createVIN();

		Vehicle vehicle = new Vehicle.VehicleBuilder(vin, modelName, modelType).engine(engine)
				.transmission(transmission).build();

		return vehicle.toString();
	}

	public ITransmission getTransmission(String trasmissionType, String trasmissionGearNumber) {
		TransmissionParser transmissionParser = transmissionParserMap.get(trasmissionType);
		return transmissionParser.parse(trasmissionGearNumber);
	}

	public String getTransmissionGearNumber(String transmissionParameters) {
		String[] splitTransmissionParameters = transmissionParameters.split(Constants.equalsChar);
		String[] splitTransmissionSpecifications = splitTransmissionParameters[1].split(Constants.minusChar);
		try {
			String gearNumberString = splitTransmissionSpecifications[1];
			return gearNumberString;
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}

	}

	public String getTransmissionType(String transmissionParameters) {
		String[] splitTransmissionParameters = transmissionParameters.split(Constants.equalsChar);
		String[] splitTransmissionSpecifications = splitTransmissionParameters[1].split(Constants.minusChar);

		return splitTransmissionSpecifications[0].toLowerCase();
	}

	public String getEmmissionStandard(String engineInput) {
		String emissionStandard = null;
		String[] splitEngineInput = engineInput.split(Constants.equalsChar);
		String[] splitEngineSpecifications = splitEngineInput[1].split(Constants.minusChar);
		try {
			emissionStandard = splitEngineSpecifications[2].toLowerCase();
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}

		return emissionStandard;
	}

	public boolean wantsTurbo(String mainEngineParameters) {
		String[] splitMainEngineParameters = mainEngineParameters.split(Constants.minusChar);
		if (splitMainEngineParameters.length > 1) {
			String engineValue = null;
			String engineParameterKey = null;

			String pattern = "(\\d+)(\\w+)";

			Pattern r = Pattern.compile(pattern);

			Matcher m = r.matcher(splitMainEngineParameters[1]);
			if (m.find()) {
				engineValue = m.group(1);
				engineParameterKey = m.group(2);
			}
			if (engineParameterKey.contains(Constants.turboSymbol)) {
				return true;
			}

			return false;
		} else {
			return false;
		}

	}

	public String getHorsePower(String mainEngineParameters) {

		String[] splitMainEngineParameters = mainEngineParameters.split(Constants.minusChar);
		if (splitMainEngineParameters.length > 1) {
			String engineValue = null;
			String engineParameterKey = null;

			String pattern = "(\\d+)(\\w+)";

			Pattern r = Pattern.compile(pattern);

			// Now create matcher object.
			Matcher m = r.matcher(splitMainEngineParameters[1]);
			if (m.find()) {
				engineValue = m.group(1);
				engineParameterKey = m.group(2);
			}
			if (engineParameterKey.equals(Constants.horsePowerSuffix)) {
				return engineValue;
			}
			return null;
		} else {
			return null;
		}

	}

	public String getEngineDisplacementLiters(String mainEngineParameters) {
		String[] splitMainEngineParameters = mainEngineParameters.split(Constants.minusChar);
		if (splitMainEngineParameters.length > 1) {
			
			String engineValue = null;
			String engineParameterKey = null;

			String pattern = "(\\d+)(\\w+)";

			Pattern r = Pattern.compile(pattern);

			// Now create matcher object.
			Matcher m = r.matcher(splitMainEngineParameters[1]);
			if (m.find()) {
				engineValue = m.group(1);
				engineParameterKey = m.group(2);
			}
			if (engineParameterKey.equals(Constants.literSuffix)) {
				return engineValue;
			}
			return null;

		} else {
			return null;
		}

	}

	public String getEngineMainParameters(String engineInput) {

		String[] splitEngineInput = engineInput.split(Constants.equalsChar);
		return splitEngineInput[1].toLowerCase();

	}

	public String getModelName(String modelSubstring) {

		String[] splitModelSubstring = modelSubstring.split(Constants.equalsChar);
		String[] splitModelType = splitModelSubstring[1].split("-");
		String model = splitModelType[0];

		return model;
	}

	public String getModelType(String modelSubstring) {

		String modelType;
		String[] splitModelSubstring = modelSubstring.split(Constants.equalsChar);
		String[] splitModelType = splitModelSubstring[1].split("-");
		try {
			modelType = splitModelType[1];
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}

		return modelType;
	}

	public IEngine getEngine(String engineInput, String engineDisplacementLiters, String horsePower, boolean hasTurbo,
			String emmissionStandard) {

		String[] splitEngineInput = engineInput.split(Constants.equalsChar);
		String[] splitEngineSpecifications = splitEngineInput[1].split(Constants.minusChar);
		String engineType = splitEngineSpecifications[0].toLowerCase();

		EngineParser engineParser = engineParserMap.get(engineType);

		return engineParser.parse(engineDisplacementLiters, horsePower, hasTurbo, emmissionStandard);

	}

	public String getEngineString(String engineInput, String engineDisplacementLiters, String horsePower,
			boolean hasTurbo, String emmissionStandard) {

		String[] splitEngineInput = engineInput.split(Constants.equalsChar);
		String[] splitEngineSpecifications = splitEngineInput[1].split(Constants.minusChar);
		String engineType = splitEngineSpecifications[0].toLowerCase();

		EngineParser engineParser = engineParserMap.get(engineType);

		return engineParser.parse(engineDisplacementLiters, horsePower, hasTurbo, emmissionStandard).toString();

	}

}
