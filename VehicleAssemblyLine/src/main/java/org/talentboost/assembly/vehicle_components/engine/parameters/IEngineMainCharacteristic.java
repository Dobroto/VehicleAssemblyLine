package org.talentboost.assembly.vehicle_components.engine.parameters;

public interface IEngineMainCharacteristic {
	boolean checkAvailability(String specificationsInput, boolean hasTurbo, String engineType);
}
