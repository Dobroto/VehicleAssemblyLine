package org.talentboost.assembly.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.factory.VehicleBrochure;
import org.talentboost.assembly.parsers.engine_parameters_parsers.EngineParametersParser;
import org.talentboost.assembly.parsers.engine_parameters_parsers.HorsePowerParser;
import org.talentboost.assembly.parsers.engine_parameters_parsers.LiterParser;
import org.talentboost.assembly.vehicle_components.engine.parameters.IEngineMainCharacteristic;

public class OptionalEngineParametersValidator implements IValidator {

	private Map<String, EngineParametersParser> engineParametersParserMap;
	String engineValue;
	String engineParameterKey;
	boolean wantsTurbo = false;

	public OptionalEngineParametersValidator() {
		engineParametersParserMap = new HashMap<String, EngineParametersParser>();
		engineParametersParserMap.put("hp", new HorsePowerParser());
		engineParametersParserMap.put("l", new LiterParser());

	}

	@Override
	public boolean validate(String engineInput) {
		String[] engineInputSplit = engineInput.split("-");

		String loweredEngineType = engineInputSplit[0].substring(engineInputSplit[0].length() - 1).toLowerCase();
		String loweredEngineCharac = engineInputSplit[1].toLowerCase();

		String pattern = "(\\d+)(\\w+)"; // match at least one digit followed by at least one alphabet character

		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(loweredEngineCharac);
		if (m.find()) {
			engineValue = m.group(1);
			engineParameterKey = m.group(2);
		}

		try {
			Double.parseDouble(engineValue);
		} catch (NumberFormatException ex) {
			System.out.println("Please enter valid engine specisifications number.");
			return false;
		}

		if (engineParameterKey.endsWith(Constants.turboSymbol)) {
			engineParameterKey.replaceFirst(Constants.turboSymbol, "");
			wantsTurbo = true;
		}

		if (!engineParametersParserMap.containsKey(engineParameterKey)) {
			System.out.println("Please enter valid HP or liters.");
			return false;
		}

		String euroStandard = Constants.defaultEuroStandard;

		if (engineInputSplit.length > 2) {
			euroStandard = engineInputSplit[2].toLowerCase();
			if (!VehicleBrochure.euroStandards.contains(euroStandard)) {
				System.out.println("Please enter valid euro standard.");
				return false;
			}
		}

		return checkInputEngineSpecsAvailability(wantsTurbo, engineValue, engineParameterKey, loweredEngineType);
		
	}

	public boolean checkInputEngineSpecsAvailability(boolean wantsTurbo, String engineValue, String engineParameterKey,
			String engineType) {
		EngineParametersParser engineParamParser = engineParametersParserMap.get(engineParameterKey);
		IEngineMainCharacteristic engineMainCharacteristic = engineParamParser.parse();
		return engineMainCharacteristic.checkAvailability(engineValue, wantsTurbo, engineType);

	}

}
