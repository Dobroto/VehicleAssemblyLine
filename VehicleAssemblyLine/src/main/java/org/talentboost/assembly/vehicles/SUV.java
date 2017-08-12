package org.talentboost.assembly.vehicles;

import java.util.Set;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.factory.VehicleBrochure;

public class SUV implements IVehicleType{

	@Override
	public Set<String> getListOfModels() {
		return VehicleBrochure.SUVModels;
	}

	@Override
	public String getVehicleTypeRepresentation() {
		return Constants.vehicleTypeRepresentationSUV;
	}

	@Override
	public Set<String> getAvailableVehicleModels() {
		return VehicleBrochure.SUVModels;
	}

	
}
