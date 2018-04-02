package org.talentboost.assembly.parsers.vehicle_parsers;

import org.talentboost.assembly.vehicle_types.Car;
import org.talentboost.assembly.vehicle_types.IVehicleType;

public class CarParser extends VehicleParser{

	@Override
	public IVehicleType parse() {
		return new Car();
	}

}
