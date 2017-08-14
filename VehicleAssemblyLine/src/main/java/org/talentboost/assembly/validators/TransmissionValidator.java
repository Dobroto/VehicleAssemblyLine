package org.talentboost.assembly.validators;

import java.util.HashMap;
import java.util.Map;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.parsers.transmission_parsers.AutomaticTransmissionParser;
import org.talentboost.assembly.parsers.transmission_parsers.TransmissionParser;

public class TransmissionValidator implements IValidator{


	private Map<String, TransmissionParser> transmissionParserMap;
	
	public TransmissionValidator() {
		transmissionParserMap = new HashMap<String, TransmissionParser>();
		transmissionParserMap.put(Constants.automaticTransmissionSymbol, new AutomaticTransmissionParser());
		
	}
	@Override
	public boolean validate(String args) {
		
		
		return false;
		
	}

}
