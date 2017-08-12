package org.talentboost.assembly.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.talentboost.assembly.parsers.engine_parameters_parsers.EngineParametersParser;
import org.talentboost.assembly.parsers.engine_parameters_parsers.HorsePowerParser;
import org.talentboost.assembly.parsers.engine_parameters_parsers.LiterParser;

public class OptionalEngineParametersValidator implements IValidator{

	private Map<String, EngineParametersParser> engineParametersParserMap;
	
	public OptionalEngineParametersValidator() {
		engineParametersParserMap = new HashMap<String, EngineParametersParser>();
		engineParametersParserMap.put("hp", new HorsePowerParser());
		engineParametersParserMap.put("l", new LiterParser());
		
	}
	@Override
	public boolean validate(String engineInput) {
		String[] engineInputSplit = engineInput.split("-");
		
		String loweredEngineCharac = engineInputSplit[1].toLowerCase();
		
		String pattern = "(\\d+)(\\w+)"; //match at least one digit followed by at least one alphabet character 
		
		Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(loweredEngineCharac);
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );
	         System.out.println("Found value: " + m.group(1) );
	         System.out.println("Found value: " + m.group(2) );
	      }else {
	         System.out.println("NO MATCH");
	      }
		
		/*if(!engineParametersParserMap.containsKey(loweredEngineCharac)) {
			System.out.println("Please enter valid HP or liters.");
			return false;
		}*/
		
		
		return false;
	}

}
