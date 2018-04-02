package org.talentboost.assembly.parsers.engine_parameters_parsers;

import org.talentboost.assembly.vehicle_components.engine.parameters.EngineLiter;
import org.talentboost.assembly.vehicle_components.engine.parameters.IEngineMainCharacteristic;

public class LiterParser extends EngineParametersParser{

	@Override
	public IEngineMainCharacteristic parse() {
		return new EngineLiter();
	}

}
