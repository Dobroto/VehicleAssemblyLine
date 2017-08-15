package org.talentboost.assembly.parsers.engine_parsers;

import org.talentboost.assembly.vehicle_components.engine.DieselEngine;
import org.talentboost.assembly.vehicle_components.engine.IEngine;

public class DieselEngineParser extends EngineParser {

	@Override
	public IEngine parse(String engineDisplacementLiters, String horsePower,
			boolean hasTurbo, String emissionStandard) {
		return new DieselEngine(engineDisplacementLiters, horsePower,
			 hasTurbo, emissionStandard);
	}

}
