package org.talentboost.assembly.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.talentboost.assembly.vehicle_components.engine.EngineSpecifications;

public class VehicleBrochure {

	public final static Set<String> carModels = new HashSet<>(
			Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8"));

	public final static Set<String> SUVModels = new HashSet<>(
			Arrays.asList("Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8"));

	public final static Set<String> bodyConfiguration = new HashSet<>(Arrays.asList("sedan", "hatchback", "kombi"));

	private List<Integer> engineDisplacementCC = new ArrayList<>(
			Arrays.asList(1000, 2000, 3000, 4000, 5000, 6000, 8000));

	private double[] EnginePowerKW = {54, 56, 70.5, 72.5, 146, 148, 190.1, 192.1, 244, 246, 
			317.5, 319.5, 252, 254, 327, 329, 330, 332, 429.3, 431.3, 509, 511, 662, 664, 
			735, 737, 957.8, 959.8, 534, 536};

	public final static Set<String> powerInKW = new HashSet<>(
			Arrays.asList("55", "147", "245", "253", "331", "510", "736"));

	public final Set<String> transmissionTypes = new HashSet<>(Arrays.asList("automatic", "manual"));

	public final Set<String> automaticGearsNumber = new HashSet<>(Arrays.asList("4", "5", "6", "8"));

	public final Set<String> manualGearsNumber = new HashSet<>(Arrays.asList("4", "5", "6"));

	public final static Set<String> euroStandards = new HashSet<>(Arrays.asList("euro3", "euro4", "euro5", "euro6"));

	private Map<Integer, EngineSpecifications> engineDisplacementCCMap;
	private TreeMap<Double, EngineSpecifications> enginePowerKWMap;

	/**
	 * This list will be used for mapping every possible horse power value with turbo and engine types
	 * The EngineSpecifications class has three values - hasTurbo, engineTypeOne, engineTypeTwo
	 * (these are two because more than one engine type can have a specific horse power value)
	 */
	private List<EngineSpecifications> engineTurboAndEngineTypeForPowerKWCollection = Arrays.asList(
			new EngineSpecifications(false, Constants.petrolEngineSymbol),
			new EngineSpecifications(true, Constants.petrolEngineSymbol),
			new EngineSpecifications(false, Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(true, Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(false, Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(true, Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(false, Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(true, Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(false, Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(true, Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(false, Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(true, Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(false, Constants.petrolEngineSymbol),
			new EngineSpecifications(true, Constants.petrolEngineSymbol),
			new EngineSpecifications(false, Constants.electricEngineSymbol));

	private List<EngineSpecifications> engineTypeForEngineDisplacementCC = Arrays.asList(
			new EngineSpecifications(Constants.petrolEngineSymbol),
			new EngineSpecifications(Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(Constants.petrolEngineSymbol, Constants.dieselEngineSymbol),
			new EngineSpecifications(Constants.petrolEngineSymbol),
			new EngineSpecifications(Constants.electricEngineSymbol));

	/**
	 * This method fills the map which will be used to validate input with KWatts.
	 * It uses engineTurboAndEngineTypeForPowerKWCollection.
	 * The map includes +/-1 ranges of kW values
	 * @return		a map<KW, <turbo, engineTypes>>
	 */
	public TreeMap<Double, EngineSpecifications> getMapOfEnginePowerInKW() {
		enginePowerKWMap = new TreeMap<>();

		int index = 0;
		for (int i = 0; i < EnginePowerKW.length; i+=2) {
			for (int j = i; j < i + 2; j++) {
				enginePowerKWMap.put(EnginePowerKW[j], engineTurboAndEngineTypeForPowerKWCollection.get(index));
			}
			index++;
		}

		return enginePowerKWMap;
	}
	
	/**
	 * This method fills the map which will be used to validate input with engine displacement in CC.
	 * @return 	a map<CC, <engineTypes>>
	 */

	public Map<Integer, EngineSpecifications> getMapOfEngineDisplacementCC() {
		engineDisplacementCCMap = new HashMap<>();

		for (int i = 0; i < engineDisplacementCC.size(); i++) {
			engineDisplacementCCMap.put(engineDisplacementCC.get(i), engineTypeForEngineDisplacementCC.get(i));
		}

		return engineDisplacementCCMap;
	}

}
