package org.talentboost.assembly.parsers.engine_parsers;

import org.talentboost.assembly.vehicle_components.engine.ElectricEngine;
import org.talentboost.assembly.vehicle_components.engine.IEngine;

public class ElectricEngineParser extends EngineParser{

	@Override
	public IEngine parse(String engineDisplacementLiters, String horsePower,
			boolean hasTurbo, String emissionStandard) {
		return new ElectricEngine(engineDisplacementLiters, horsePower,
				hasTurbo, emissionStandard);
	}

}
