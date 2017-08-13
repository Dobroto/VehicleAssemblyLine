package org.talentboost.assembly.vehicle_components.engine.parameters;

import java.util.Map;

import org.talentboost.assembly.factory.VehicleBrochure;
import org.talentboost.assembly.vehicle_components.engine.EngineSpecifications;

public class EngineLiter implements IEngineMainCharacteristic {

	Map<Integer, EngineSpecifications> engineDisplacementCCMap;

	/**
	 * If the given engine specifications include liters this class's checkAvailability
	 * will be called. We are simply converting from liters to CC and then we search 
	 * in the displacement map for the CC value. We are also checking is this engine
	 * displacement is available to this engine type.
	 */
	@Override
	public boolean checkAvailability(String displacementLiterInput, boolean hasTurbo, String engineType) {

		VehicleBrochure brochure = new VehicleBrochure();
		engineDisplacementCCMap = brochure.getMapOfEngineDisplacementCC();
		int ccDisplacement = turnFromLiterToCC(displacementLiterInput);
		
		if(engineDisplacementCCMap.containsKey(ccDisplacement)) {
			EngineSpecifications es = engineDisplacementCCMap.get(ccDisplacement);
			
			if((es.getEngineTypeOne() != engineType) && (es.getEngineTypeTwo() != engineType)) {
				System.out.println("These liters are not available to this engine type.");
				return false;
			}
			return true;
		}
		
		
		return false;
	}

	public int turnFromLiterToCC(String displacementLiterInput) {
		int literNumber = Integer.parseInt(displacementLiterInput);
		return literNumber * 1000;

	}

}
