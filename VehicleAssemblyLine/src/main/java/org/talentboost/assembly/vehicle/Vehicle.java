package org.talentboost.assembly.vehicle;

import org.talentboost.assembly.vehicle_components.engine.IEngine;
import org.talentboost.assembly.vehicle_components.transmission.ITransmission;

public class Vehicle {

	private final String vehicleIdentificationNumber;
	private final String modelName;
	private final String modelType;

	private IEngine engine;
	private ITransmission transmission;

	private Vehicle(VehicleBuilder vehicleBuilder) {
		vehicleIdentificationNumber = vehicleBuilder.vehicleIdentificationNumber;
		modelName = vehicleBuilder.modelName;
		modelType = vehicleBuilder.modelType;
		engine = vehicleBuilder.engine;
		transmission = vehicleBuilder.transmission;
	}

	public String getVehicleIdentificationNumber() {
		return vehicleIdentificationNumber;
	}

	/*
	 * public String getModelName() { return modelName; }
	 * 
	 * public String getModelType() { return modelType; }
	 * 
	 * public IEngine getEngine() { return engine; }
	 * 
	 * public ITransmission getTransmission() { return transmission; }
	 * 
	 * public void setEngine(IEngine engine) { this.engine = engine; }
	 * 
	 * public void setTransmission(ITransmission transmission) { this.transmission =
	 * transmission; }
	 */

	public static class VehicleBuilder {
		private final String vehicleIdentificationNumber;
		private final String modelName;
		private final String modelType;

		private IEngine engine = null;
		private ITransmission transmission = null;

		public VehicleBuilder(String vehicleIdentificationNumber, String modelName, String modelType) {
			this.vehicleIdentificationNumber = vehicleIdentificationNumber;
			this.modelName = modelName;
			this.modelType = modelType;
		}

		public VehicleBuilder engine(IEngine engine) {
			this.engine = engine;
			return this;
		}

		public VehicleBuilder transmission(ITransmission transmission) {
			this.transmission = transmission;
			return this;
		}

		public Vehicle build() {
			return new Vehicle(this);
		}
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("VIN = ");
		sb.append(this.vehicleIdentificationNumber);
		sb.append(" Model = ");
		sb.append(this.modelName);
		sb.append(" Type = ");
		if (this.modelType == null) {
			sb.append("Sedan");
		} else {
			sb.append(this.modelType);
		}

		sb.append(" Engine = ");
		sb.append(this.engine.toString());
		sb.append(" Transmission = ");
		sb.append(this.transmission.toString());

		return sb.toString();
	}

}
