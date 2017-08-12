package org.talentboost.assembly.vehicle_components.engine;


import org.talentboost.assembly.enums.EngineDisplacementCCEnum;
import org.talentboost.assembly.enums.EngineTypesEnum;
import org.talentboost.assembly.enums.PowerInKWEnum;

public class EngineSpecifications {
	int idNumber;
	EngineDisplacementCCEnum engineDisplacementCC;
	PowerInKWEnum powerInKW;
	boolean turbo;
	EngineTypesEnum engineTypes;
	
	public EngineSpecifications(int idNumber, EngineDisplacementCCEnum engineDisplacementCC, 
			PowerInKWEnum powerInKW, boolean turbo, EngineTypesEnum engineTypes) {
		this.idNumber = idNumber;
		this.engineDisplacementCC = engineDisplacementCC;
		this.powerInKW = powerInKW;
		this.turbo = turbo;
		this.engineTypes = engineTypes;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public EngineDisplacementCCEnum getEngineDisplacementCC() {
		return engineDisplacementCC;
	}

	public void setEngineDisplacementCC(EngineDisplacementCCEnum engineDisplacementCC) {
		this.engineDisplacementCC = engineDisplacementCC;
	}

	public PowerInKWEnum getPowerInKW() {
		return powerInKW;
	}

	public void setPowerInKW(PowerInKWEnum powerInKW) {
		this.powerInKW = powerInKW;
	}

	public boolean isTurbo() {
		return turbo;
	}

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

	public EngineTypesEnum getEngineTypes() {
		return engineTypes;
	}

	public void setEngineTypes(EngineTypesEnum engineTypes) {
		this.engineTypes = engineTypes;
	}

	
	
	
	
}
