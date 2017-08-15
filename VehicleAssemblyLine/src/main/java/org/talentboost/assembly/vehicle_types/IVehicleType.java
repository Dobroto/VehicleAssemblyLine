package org.talentboost.assembly.vehicle_types;

import java.util.Set;

public interface IVehicleType {
	public Set<String> getListOfModels();
	public String getVehicleTypeRepresentation();
	public Set<String> getAvailableVehicleModels();
}
