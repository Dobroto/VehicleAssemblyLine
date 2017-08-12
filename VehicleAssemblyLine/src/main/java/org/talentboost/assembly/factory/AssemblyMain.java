package org.talentboost.assembly.factory;

import java.util.Scanner;

import org.talentboost.assembly.validators.CountryValidator;
import org.talentboost.assembly.validators.FactoryNumberValidator;
import org.talentboost.assembly.validators.OptionalEngineParametersValidator;
import org.talentboost.assembly.validators.VehicleTypeValidator;

public class AssemblyMain {

	public static void main(String[] args) {

		System.out.println("Please enter the factory's country ISO code.");
		Scanner sc = new Scanner(System.in);
		CountryValidator cv = new CountryValidator();
		FactoryNumberValidator fnv = new FactoryNumberValidator();
		String validCountryCode = null;
		String validFactoryNum = null;

		try {
			while (sc.hasNextLine()) {
				validCountryCode = sc.nextLine().trim();
				if (cv.validate(validCountryCode)) {
					break;
				}
				else {
					System.out.println("Please enter a valid country code.");
				}
			}

			System.out.println("Please enter your factory's number.");

			while (sc.hasNextLine()) {
				validFactoryNum = sc.nextLine().trim();
				if (fnv.validate(validFactoryNum)) {
					break;
				}
			}

		} finally {
			sc.close();
		}

		Factory factory = new Factory(validCountryCode, validFactoryNum);
		System.out.println("Please put the commands files in your home directory.");
		
		
		OptionalEngineParametersValidator vtv = new OptionalEngineParametersValidator();
		vtv.validate("engine=B-100hp");

	}

}
