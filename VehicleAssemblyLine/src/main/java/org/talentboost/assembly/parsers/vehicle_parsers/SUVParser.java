package org.talentboost.assembly.parsers.vehicle_parsers;

import org.talentboost.assembly.vehicle_types.IVehicleType;
import org.talentboost.assembly.vehicle_types.SUV;

public class SUVParser extends VehicleParser{

	@Override
	public IVehicleType parse() {
		return new SUV();
	}

}
