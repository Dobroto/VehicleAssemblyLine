package org.talentboost.assembly.commands;

public interface ICommand {
	String getCommandName();
    String execute(String input);
}
