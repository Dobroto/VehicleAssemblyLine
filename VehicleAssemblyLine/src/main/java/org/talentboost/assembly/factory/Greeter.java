package org.talentboost.assembly.factory;

import java.io.InputStream;
import java.util.Scanner;

import org.talentboost.assembly.validators.CountryValidator;
import org.talentboost.assembly.validators.FactoryNumberValidator;

public class Greeter {
	static CountryValidator cv = new CountryValidator();
	static FactoryNumberValidator fnv = new FactoryNumberValidator();
	static String validCountryCode = null;
	static String validFactoryNum = null;

	public static String getCountryCode(InputStream str) {
		Scanner sc = new Scanner(str);
		try {
			while (sc.hasNextLine()) {
				validCountryCode = sc.nextLine().trim();
				if (cv.validate(validCountryCode)) {
					return validCountryCode;
				} else {
					System.out.println("Please enter a valid country code.");
				}
			}
		} finally {
			sc.close();
		}
		return validCountryCode;
	}
	

	public static String getFactoryCode(InputStream str) {

		Scanner sc = new Scanner(str);
		try {
			while (sc.hasNextLine()) {
				validFactoryNum = sc.nextLine().trim();
				if (fnv.validate(validFactoryNum)) {
					return validFactoryNum;
				}
			}
		} finally {
			sc.close();
		}
		return validFactoryNum;
	}
}
