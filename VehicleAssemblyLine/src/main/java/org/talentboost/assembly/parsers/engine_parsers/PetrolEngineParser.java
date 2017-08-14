package org.talentboost.assembly.parsers.engine_parsers;

import org.talentboost.assembly.vehicle_components.engine.IEngine;
import org.talentboost.assembly.vehicle_components.engine.PetrolEngine;

public class PetrolEngineParser extends EngineParser {

	@Override
	public IEngine parse() {
		return new PetrolEngine(null, null, false, null);
	}

}
