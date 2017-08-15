package org.talentboost.assembly.vehicle_components.transmission;

public interface ITransmission {

	public String getTransmissionSymbol();
	public String getNumberOfGears();
	public boolean validateGearNumber(String gearNumber);
}
