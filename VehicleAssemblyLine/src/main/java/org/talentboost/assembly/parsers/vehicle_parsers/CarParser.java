package org.talentboost.assembly.parsers.vehicle_parsers;

import org.talentboost.assembly.vehicles.Car;
import org.talentboost.assembly.vehicles.IVehicleType;

public class CarParser extends VehicleParser{

	@Override
	public IVehicleType parse() {
		return new Car();
	}

}
