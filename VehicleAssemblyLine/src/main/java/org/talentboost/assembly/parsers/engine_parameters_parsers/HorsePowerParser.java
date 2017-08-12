package org.talentboost.assembly.parsers.engine_parameters_parsers;

import org.talentboost.assembly.vehicle_components.engine.parameters.HorsePower;
import org.talentboost.assembly.vehicle_components.engine.parameters.IEngineMainCharacteristic;

public class HorsePowerParser extends EngineParametersParser{

	@Override
	public IEngineMainCharacteristic parse() {
		return new HorsePower();
	}

}
