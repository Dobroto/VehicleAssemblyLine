package org.talentboost.assembly.validators;

import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Map;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.parsers.transmission_parsers.AutomaticTransmissionParser;
import org.talentboost.assembly.parsers.transmission_parsers.ManualTransmissionParser;
import org.talentboost.assembly.parsers.transmission_parsers.TransmissionParser;
import org.talentboost.assembly.vehicle_components.transmission.ITransmission;

public class TransmissionValidator implements IValidator {

	private Map<String, TransmissionParser> transmissionParserMap;

	public TransmissionValidator() {
		transmissionParserMap = new HashMap<String, TransmissionParser>();
		transmissionParserMap.put(Constants.automaticTransmissionSymbol, new AutomaticTransmissionParser());
		transmissionParserMap.put(Constants.manualTransmissionSymbol, new ManualTransmissionParser());
	}

	/**
	 * This method validates the transmission part of the create command.
	 * It checks if "transmission=" is entered correctly.
	 * It checks if there are gear numbers - if yes - checkTransmissionGears is called
	 */
	@Override
	public boolean validate(String transmissionInput) {

		try {
			int indexOfEquals = transmissionInput.indexOf("=");
			if ((indexOfEquals == -1) || (!transmissionInput.startsWith("transmission="))) {
				System.out.println("Please enter a transmission in the agreed manner.");
				return false;
			}
			String[] transmissionInputSplit = transmissionInput.split("=");
			String transmissionParameters = transmissionInputSplit[1].toLowerCase();

			if (transmissionParameters.contains("-")) {
				String[] transmissionParametersSplit = transmissionParameters.split("-");
				String transmissionType = transmissionParametersSplit[0];
				String gearNumber = transmissionParametersSplit[1];

				if (transmissionParserMap.get(transmissionType) == null) {
					System.out.println("Please enter valid transmission type.");
					return false;
				}
				return checkTransmissionGears(transmissionType, gearNumber);
			}
			else {
				if (transmissionParserMap.get(transmissionParameters) == null) {
					System.out.println("Please enter valid transmission type.");
					return false;
				}
			}

		} catch (NullPointerException ex) {
			System.out.println("Please enter valid transmission.");
		}
		return true;

	}
	
	/**
	 * This method parses the appropriate transmission type and they check if 
	 * the given gear number is applicable to the given transmission.
	 * @param transmissionType		"auto"/"manual"
	 * @param gearNumberInput		"4"/"5"/ etc.
	 * @return		is it applicable to this transmission
	 */

	public boolean checkTransmissionGears(String transmissionType, String gearNumberInput) {

		try {
			int gearNumber = Integer.parseInt(gearNumberInput);
			TransmissionParser transmissionParser = transmissionParserMap.get(transmissionType);
			ITransmission transmission = transmissionParser.parse(gearNumber);
			return transmission.validateGearNumber(gearNumberInput);

		} catch (IllegalFormatException ex) {
			System.out.println("Please enter a valid gear number.");
			return false;
		}

	}

}
