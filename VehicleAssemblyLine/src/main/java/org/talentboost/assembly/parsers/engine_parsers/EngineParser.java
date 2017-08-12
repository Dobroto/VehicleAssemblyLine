package org.talentboost.assembly.parsers.engine_parsers;

import org.talentboost.assembly.vehicle_components.engine.IEngine;

public abstract class EngineParser {
	public abstract IEngine parse(int engineDisplacementCC, int powerInKW, 
			boolean hasTurbo, String emissionStandard);
}