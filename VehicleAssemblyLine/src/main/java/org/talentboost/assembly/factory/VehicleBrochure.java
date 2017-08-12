package org.talentboost.assembly.factory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VehicleBrochure {
	
	public final static Set<String> carModels = 
			new HashSet<>(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8"));
	
	public final static Set<String> SUVModels = 
			new HashSet<>(Arrays.asList("Q1", "Q2", "Q3", "Q4", "Q5", "Q6", "Q7", "Q8"));
	
	public final Set<String> bodyConfiguration = 
			new HashSet<>(Arrays.asList("sedan", "hatchback", "kombi"));
	
	public final Set<String> engineDisplacementCC = 
			new HashSet<>(Arrays.asList("1000", "2000", "3000", "4000", "5000", "6000", "8000"));
	
	public final Set<String> powerInKW = 
			new HashSet<>(Arrays.asList("55", "147", "245", "253", "331", "510", "736"));
	
	public final Set<String> transmissionTypes = 
			new HashSet<>(Arrays.asList("automatic", "manual"));
	
	public final Set<String> automaticGearsNumber = 
			new HashSet<>(Arrays.asList("4", "5", "6", "8"));
	
	public final Set<String> manualGearsNumber = 
			new HashSet<>(Arrays.asList("4", "5", "6"));
}
