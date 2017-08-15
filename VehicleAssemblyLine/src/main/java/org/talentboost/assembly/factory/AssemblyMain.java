package org.talentboost.assembly.factory;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

import org.talentboost.assembly.interpreter.Interpreter;
import org.talentboost.assembly.validators.CountryValidator;
import org.talentboost.assembly.validators.FactoryNumberValidator;
import org.talentboost.assembly.validators.OptionalEngineParametersValidator;
import org.talentboost.assembly.validators.VehicleTypeValidator;
import org.talentboost.assembly.vehicle_components.engine.EngineSpecifications;

public class AssemblyMain {

	public static void main(String[] args) {

		InputStream str = System.in;
		System.out.println("Please enter the factory's country ISO code.");
		String coutryCode = Greeter.getCountryCode(str);
		

		System.out.println("Please enter your factory's number.");
		
		String factoryNumber = Greeter.getFactoryCode(str);
		
			Interpreter interpreter = new Interpreter(coutryCode, factoryNumber);
			interpreter.processInput(str);
			
			

		

		
		//InputStream str = System.in;
		
		
		/*Factory factory = Factory.getInstance();
		factory.interpretate(str, validFactoryNum, validFactoryNum);*/
	}

}
