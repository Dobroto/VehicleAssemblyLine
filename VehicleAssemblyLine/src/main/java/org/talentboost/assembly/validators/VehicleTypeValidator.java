package org.talentboost.assembly.validators;

import java.util.HashMap;
import java.util.Map;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.parsers.vehicle_parsers.CarParser;
import org.talentboost.assembly.parsers.vehicle_parsers.SUVParser;
import org.talentboost.assembly.parsers.vehicle_parsers.VehicleParser;
import org.talentboost.assembly.vehicle_types.IVehicleType;

/**
 * 
 * In order to achieve better extensibility, parsers are used. In the
 * constructor a map is created which contains as key for example "car" and as
 * value - object of CarParser.
 * 
 * @author Borislav Georgiev
 *
 */
public class VehicleTypeValidator implements IValidator {

	private Map<String, VehicleParser> vehicleTypeParserMap;

	public VehicleTypeValidator() {
		vehicleTypeParserMap = new HashMap<String, VehicleParser>();
		vehicleTypeParserMap.put(Constants.vehicleTypeRepresentationCar, new CarParser());
		vehicleTypeParserMap.put(Constants.vehicleTypeRepresentationSUV, new SUVParser());
	}

	/**
	 * The method checks the first word after the create command. With the current
	 * specifications it should be either "car" or "suv". The word is brought to
	 * lower case and is searched in the map.
	 * 
	 * @param vehicleTypeInput
	 *            first word after the create command
	 * @return boolean does the word exist in the map
	 */
	@Override
	public boolean validate(String vehicleTypeInput) {

		String loweredVehicleTypeInput = vehicleTypeInput.toLowerCase();
		try {
			if (vehicleTypeParserMap.get(loweredVehicleTypeInput) == null) {
				System.out.println("Please enter valid vehicle type.");
				return false;
			}

		} catch (NullPointerException ex) {
			return false;
		}

		return true;
	}

	/**
	 * The method parseVehicleType accepts vehicle type(for example "car") and using
	 * parsers finds the correct vehicle type object (for example car object).
	 * 
	 * @param vehicleTypeInput
	 * @return IVehicleType interface
	 */
	public IVehicleType parseVehicleType(String vehicleTypeInput) {

		String loweredVehicleTypeInput = vehicleTypeInput.toLowerCase();
		VehicleParser vehicleParser = vehicleTypeParserMap.get(loweredVehicleTypeInput);

		return vehicleParser.parse();
	}

}
