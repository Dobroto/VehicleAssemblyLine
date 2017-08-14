package org.talentboost.assembly.parsers.engine_parsers;

import org.talentboost.assembly.vehicle_components.engine.ElectricEngine;
import org.talentboost.assembly.vehicle_components.engine.IEngine;

public class ElectricEngineParser extends EngineParser{

	@Override
	public IEngine parse() {
		return new ElectricEngine();
	}

}
