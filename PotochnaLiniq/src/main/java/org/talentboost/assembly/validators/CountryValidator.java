package org.talentboost.assembly.validators;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * The method validate accepts the factory's country code
 * and checks if the set with ISO country codes contains it.
 * The code needs to be upper case.
 * 
 * @param	code		a string provided by the user
 * @return	boolean		does it contain it or not
 */
public final class CountryValidator implements IValidator {

	private static final Set<String> ISO_COUNTRIES = new HashSet<String>(Arrays.asList(Locale.getISOCountries()));

	@Override
	public boolean validate(String code) {
		String result = code.toUpperCase();
		return ISO_COUNTRIES.contains(result);
	}

}
