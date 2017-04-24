package process.services;

public class Convertion {
	
	private int number;
	
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
