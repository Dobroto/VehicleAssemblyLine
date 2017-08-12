package org.talentboost.assembly.interpreter;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.talentboost.assembly.commands.CreateVehicleCommand;
import org.talentboost.assembly.commands.DisassembleCommand;
import org.talentboost.assembly.commands.FindCommand;
import org.talentboost.assembly.commands.ICommand;
import org.talentboost.assembly.commands.PrintCommand;
import org.talentboost.assembly.commands.UpdateCommand;
import org.talentboost.assembly.factory.VehicleBrochure;


public class Interpreter {
	private static VehicleBrochure memory = new VehicleBrochure();
	private Map<String, ICommand> COMMAND_MAP;
    /*
     * Offering our commands to the client 
     */
    public Interpreter() {
    	this(Arrays.asList(new ICommand[] {new CreateVehicleCommand(), new DisassembleCommand(), 
    	    		new FindCommand(), new PrintCommand(), new UpdateCommand() }));
    }
    
    /*
     * The client puts his own commands in the map 
     */
    public Interpreter(Collection<ICommand> commands) {
    	this.COMMAND_MAP = new HashMap<>();
    	for (Iterator<ICommand> iterator = commands.iterator(); iterator.hasNext();) {
    		ICommand command = (ICommand) iterator.next();
			this.COMMAND_MAP.put(command.getCommandName(), command);
		}
    }
    
    public void processInput(InputStream str) {
    	Scanner sc = new Scanner(str);
    	try {
    		while(sc.hasNextLine()) {
    			String line = sc.nextLine().trim();
    			processLine(line);
    		}
    	}
    	finally {
    		sc.close();
    	}
    }

	private void processLine(String line) {
		Scanner lineScan = new Scanner(line);
		try {
			String command = lineScan.next();
			String args = lineScan.nextLine().trim();
			
			ICommand cmd = COMMAND_MAP.get(command);
			if (cmd == null) {
				System.out.println("No such command!");
				return;
			}
			String result = cmd.execute(args);
			System.out.println(result);
		}
		catch (NoSuchElementException e) {
			System.out.println("Cannot parse command");
		}
		finally {
			lineScan.close();
		}
		
		
	}
    
    
    
	
}
