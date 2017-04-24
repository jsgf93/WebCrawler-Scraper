package process.services;

public class Conversion {
	
	private int number;
	
	/**
	 * These methods convert a string into a number, erase all not numeric characters and parses the result into an integer.
	 * @param string
	 * @return number
	 */
	
	public int convertNumbers (String string){
		String s = string.replaceAll("[^\\d]","");
		number = Integer.parseInt(s.trim());		
		return number;
	}
	
	public int convertRank (String string){
		String s = string.replaceAll("[^\\d]","");
		number = Integer.parseInt(s);
		return number;
	}
}
