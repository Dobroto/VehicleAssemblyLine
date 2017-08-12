package org.talentboost.assembly.validators;

import org.talentboost.assembly.factory.VehicleBrochure;
/**
 * The method checks if the given body configuration type 
 * exists in the brochure.
 * @author Borislav Georgiev
 *
 */
public class BodyConfigurationValidator implements IValidator {

	@Override
	public boolean validate(String vehicleModelInput) {

		int indexOfBodyConfiguration = vehicleModelInput.indexOf("-") + 1;
		
		String bodyConfig = vehicleModelInput.substring(indexOfBodyConfiguration);
		
		if (!VehicleBrochure.bodyConfiguration.contains(bodyConfig)) {
			System.out.println("Please enter valid body configuration.");
			return false;
		}

		return true;
	}

}
