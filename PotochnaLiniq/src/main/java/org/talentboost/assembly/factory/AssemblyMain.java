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

		Scanner sc = new Scanner(System.in);

		String coutryCode = null;
		
		while (coutryCode == null) {
			System.out.println("Please enter valid country code.");
			String countryCodeInput = sc.next();
			coutryCode = Greeter.getCountryCode(countryCodeInput);
		}
		
		
		String factoryNumber = null;
		
		while(factoryNumber == null) {
			System.out.println("Please enter valid factory code.");

			String factoryCodeInput = sc.next();
			factoryNumber = Greeter.getFactoryCode(factoryCodeInput);
		}
		

		InputStream str = System.in;

		Interpreter interpreter = new Interpreter(coutryCode, factoryNumber);
		interpreter.processInput(str);

	
	}

}
