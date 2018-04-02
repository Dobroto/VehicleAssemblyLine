package org.talentboost.assembly.vehicle_components.engine;


public class EngineSpecifications {
	
	int idOfSpecification;
	boolean hasTurbo;
	String engineTypeOne;
	String engineTypeTwo;
	
	public EngineSpecifications(String engineTypeOne) {
		this.engineTypeOne = engineTypeOne;
	}
	
	public EngineSpecifications(String engineTypeOne, String engineTypeTwo) {
		this.engineTypeOne = engineTypeOne;
		this.engineTypeTwo = engineTypeTwo;
	}
	
	public EngineSpecifications(boolean turbo, String engineTypeOne) {
		this.hasTurbo = turbo;
		this.engineTypeOne = engineTypeOne;
		this.idOfSpecification = 1;
	}
	
	public EngineSpecifications(boolean turbo, String engineTypeOne, String engineTypeTwo) {
		this.hasTurbo = turbo;
		this.engineTypeOne = engineTypeOne;
		this.engineTypeTwo = engineTypeTwo;
		this.idOfSpecification = 2;
	}

	public boolean getTurbo() {
		return hasTurbo;
	}

	public void setTurbo(boolean turbo) {
		this.hasTurbo = turbo;
	}

	public String getEngineTypeOne() {
		return engineTypeOne;
	}

	public void setEngineTypeOne(String engineTypeOne) {
		this.engineTypeOne = engineTypeOne;
	}

	public String getEngineTypeTwo() {
		return engineTypeTwo;
	}

	public void setEngineTypeTwo(String engineTypeTwo) {
		this.engineTypeTwo = engineTypeTwo;
	}

	public int getIdOfSpecification() {
		return this.idOfSpecification;
	}
	
	
	
}
