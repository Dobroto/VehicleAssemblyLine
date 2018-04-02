package org.talentboost.assembly.factory;

import java.util.Random;

/**
 * Generates Vehicle Identification Number
 * @param 	validCountryCode	already validated country code
 * @param	validFactoryNum		already validated factory number
 * @author 	Borislav Georgiev
 */
public final class VINCreator {
	private String countryCode;
	private String factoryNum;
	private String acceptedSymbols = "0123456789ABCDEFGHJKLMNPRSTUVWXYZ";

	public VINCreator(String validCountryCode, String validFactoryNum) {
		this.countryCode = validCountryCode;
		this.factoryNum = validFactoryNum;
	}

	/**
	 * In 14 iterations of the loop, the randomizer chooses a symbol from 
	 * the allowed set of characters
	 * @return	the generated VIN
	 */
	public String createVIN() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append(countryCode);
		sb.append(factoryNum);

		for (int i = 0; i < 14; i++) {
			int index = rand.nextInt(acceptedSymbols.length());
			char randSymbol = acceptedSymbols.charAt(index);
			sb.append(randSymbol);
		}
		return sb.toString();
	}
}
