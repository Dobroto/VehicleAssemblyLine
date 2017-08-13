
public class Loop {

	public static void main(String[] args) {
		

		double[] EnginePowerKW = {54, 56, 70.5, 72.5, 146, 148, 190.1, 192.1, 244, 246, 
				317.5, 319.5, 252, 254, 327, 329, 330, 332, 429.3, 431.3, 509, 511, 662, 664, 
				735, 737, 957.8, 959.8, 534, 536};
		
		int[] engineSpec = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int index = 0;
		for (int i = 0; i < EnginePowerKW.length; i+=2) {
			
			for (int j = i; j < i + 2; j++) {
				System.out.println(EnginePowerKW[j] + " " + engineSpec[index]);
			}
			index++;
		}
		
		
		
	}

}
