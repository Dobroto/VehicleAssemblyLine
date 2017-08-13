
public class Loop {

	public static void main(String[] args) {
		
		String engineInput = "engine=B-100hpT-euro3";
		String[] engineInputSplit = engineInput.split("-");
		

		String loweredEngineType = engineInputSplit[0].substring(engineInputSplit[0].length()-1).toLowerCase();
		String loweredEngineCharac = engineInputSplit[1].toLowerCase();
		
		
		
	}

}
