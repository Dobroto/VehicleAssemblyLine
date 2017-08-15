package org.talentboost.assembly.parsers.transmission_parsers;

import org.talentboost.assembly.vehicle_components.transmission.AutomaticTransmission;
import org.talentboost.assembly.vehicle_components.transmission.ITransmission;

public class AutomaticTransmissionParser extends TransmissionParser{

	@Override
	public ITransmission parse(String numOfGears) {
		return new AutomaticTransmission(numOfGears);
	}

}
