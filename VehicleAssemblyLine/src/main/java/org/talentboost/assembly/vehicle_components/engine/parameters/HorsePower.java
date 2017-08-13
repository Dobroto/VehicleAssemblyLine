package org.talentboost.assembly.vehicle_components.engine.parameters;

import java.util.TreeMap;

import org.talentboost.assembly.factory.Constants;
import org.talentboost.assembly.factory.VehicleBrochure;
import org.talentboost.assembly.vehicle_components.engine.EngineSpecifications;

public class HorsePower implements IEngineMainCharacteristic {

	TreeMap<Double, EngineSpecifications> enginePowerKWMap;

	/**
	 * If the given engine specifications include horse power, this class's check availability
	 * will be called. Here if the input is B-100hpT, horsePowerInput will be 100, wantsTurbo will
	 * be true and engineType will be B. The kW map is called and the horse power are converted to kW.
	 * TreeMap is used because we are searching for a range of possible keys.
	 * If the kW value is between two groups of EngineSpecifications with same values,
	 * it means that we have a match. Next we are checking if the object's engine types are
	 * the same.
	 * The last if block checks whether the client wants turbo and if that specific horse power
	 * comes with turbo.
	 */
	@Override
	public boolean checkAvailability(String horsePowerInput, boolean wantsTurbo, String engineType) {

		VehicleBrochure brochure = new VehicleBrochure();
		enginePowerKWMap = brochure.getMapOfEnginePowerInKW();
		double powerInKw = turnFromHpToKw(horsePowerInput);

		if(powerInKw < Constants.minPowerInKw) {
			return false;
		}
		EngineSpecifications groupBelow = enginePowerKWMap.floorEntry(powerInKw).getValue();
		EngineSpecifications groupAbove = enginePowerKWMap.ceilingEntry(powerInKw).getValue();

		if ((groupBelow.getIdOfSpecification() == groupAbove.getIdOfSpecification())
				&& (groupBelow.getEngineTypeOne().equals(groupAbove.getEngineTypeOne()))
				&& (groupBelow.getTurbo() == groupAbove.getTurbo())) {
			if ((groupBelow.getEngineTypeOne() != engineType) && (groupBelow.getEngineTypeTwo() != engineType)) {
				System.out.println("That horse power isn't available with this engine.");
				return false;
			}
			if (wantsTurbo) {
				return groupBelow.getTurbo();

			}

		}

		return false;
	}

	public double turnFromHpToKw(String horsePowerInput) {

		double horsePowerNumber = Double.parseDouble(horsePowerInput);
		return horsePowerNumber * Constants.hptoKWConversionValue;

	}

	

}
