package org.talentboost.assembly.validators;

import java.util.HashMap;
import java.util.Map;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.parsers.engine_parsers.EngineParser;
import org.talentboost.assembly.parsers.engine_parsers.PetrolEngineParser;

public class EngineValidator implements IValidator {

	private Map<String, EngineParser> engineParserMap;

	public EngineValidator() {
		engineParserMap = new HashMap<String, EngineParser>();
		engineParserMap.put(Constants.petrolEngineSymbol, new PetrolEngineParser());
		engineParserMap.put(Constants.dieselEngineSymbol, new PetrolEngineParser());
		engineParserMap.put(Constants.electricEngineSymbol, new PetrolEngineParser());
	}

	@Override
	public boolean validate(String engineInput) {

		try {
			int indexOfEquals = engineInput.indexOf("=");
			if ((indexOfEquals == -1) || (!engineInput.startsWith("engine="))) {
				System.out.println("Please enter an engine in the agreed manner.");
				return false;
			}
			indexOfEquals++;

			String engine = engineInput.substring(indexOfEquals, indexOfEquals + Constants.engineRepresentationLength);

			String loweredEngineInput = engine.toLowerCase();

			if (engineParserMap.get(loweredEngineInput) == null) {
				System.out.println("Please enter valid engine.");
				return false;
			}
			
			if (engineInput.contains("-")) {
				OptionalEngineParametersValidator oepv = new OptionalEngineParametersValidator();
				return oepv.validate(engineInput);
			}
		} catch (NullPointerException ex) {
			System.out.println("Please enter valid engine");
		}

		return true;

	}

}
