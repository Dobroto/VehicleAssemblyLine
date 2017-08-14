package org.talentboost.assembly.vehicle_components.transmission;

public interface ITransmission {

	public String getTransmissionSymbol();
	public int getNumberOfGears();
	public boolean validateGearNumber(String gearNumber);
}
