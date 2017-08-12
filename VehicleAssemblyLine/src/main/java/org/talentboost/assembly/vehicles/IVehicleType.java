package org.talentboost.assembly.vehicles;

import java.util.Set;

public interface IVehicleType {
	public Set<String> getListOfModels();
	public String getVehicleTypeRepresentation();
	public Set<String> getAvailableVehicleModels();
}
