package org.talentboost.assembly.commands;

import org.talentboost.assembly.validators.CreateVehicleCommandValidator;

public class CreateVehicleCommand implements ICommand{

	private String commandName = "create";
	
	@Override
	public String getCommandName() {
		return this.commandName;
	}

	@Override
	public String execute(String input) {
		
		CreateVehicleCommandValidator cvcv = new CreateVehicleCommandValidator();
		if (!cvcv.validate(input)) {
			return "Please enter valid vehicle.";
		}
		
		
		
		return null;
	}

}
