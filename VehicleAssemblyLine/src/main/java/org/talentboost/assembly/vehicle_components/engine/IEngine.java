package org.talentboost.assembly.vehicle_components.engine;

public interface IEngine {
	int getEngineDisplacementInCC();
	double getPowerInKW();
	boolean hasTurbo();
	String getEmissionStandard();
	String getTransmissionType();
	int getGearsNumber();
}
