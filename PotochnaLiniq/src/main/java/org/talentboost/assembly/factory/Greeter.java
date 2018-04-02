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

	public static String getCountryCode(String line) {

		if (cv.validate(line.trim())) {
			return line;
		} else {
			return null;
		}

	}

	public static String getFactoryCode(String line) {

		if (fnv.validate(line.trim())) {
			return line;
		} else {
			return null;
		}

	}

}
