package org.talentboost.assembly.parsers.vehicle_parsers;

import org.talentboost.assembly.vehicles.IVehicleType;
import org.talentboost.assembly.vehicles.SUV;

public class SUVParser extends VehicleParser{

	@Override
	public IVehicleType parse() {
		return new SUV();
	}

}
