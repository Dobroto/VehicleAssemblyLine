package org.talentboost.assembly.enums;

public enum EngineDisplacementCCEnum {
	cc1000(1000), cc2000(2000), cc3000(3000), cc4000(4000), cc5000(5000), cc6000(6000), cc8000(8000);

	private int number;

	private EngineDisplacementCCEnum(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
