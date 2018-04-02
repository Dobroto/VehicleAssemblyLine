package org.talentboost.assembly.parsers.engine_parsers;

import org.talentboost.assembly.vehicle_components.engine.IEngine;
import org.talentboost.assembly.vehicle_components.engine.PetrolEngine;

public class PetrolEngineParser extends EngineParser {

	@Override
	public IEngine parse(String engineDisplacementLiters, String horsePower,
			boolean hasTurbo, String emissionStandard) {
		return new PetrolEngine(engineDisplacementLiters, horsePower,
				hasTurbo, emissionStandard);
	}

}
