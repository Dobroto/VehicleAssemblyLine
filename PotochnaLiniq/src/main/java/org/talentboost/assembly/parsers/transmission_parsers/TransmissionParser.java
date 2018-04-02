package org.talentboost.assembly.parsers.transmission_parsers;

import org.talentboost.assembly.vehicle_components.transmission.ITransmission;

public abstract class TransmissionParser {
	public abstract ITransmission parse(String numOfGears);
}
