package org.talentboost.assembly.vehicles;

import java.util.Set;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.factory.VehicleBrochure;

public class Car implements IVehicleType {

	@Override
	public Set<String> getListOfModels() {
		return VehicleBrochure.carModels;
	}

	@Override
	public String getVehicleTypeRepresentation() {
		return Constants.vehicleTypeRepresentationCar;
	}

}
