package process.services;

public class WordCounter {
	 //allows expressions like alphanumeric, some abbreviations 
		//and expressions with two or more characters. Almost all kind of words.
	
	public int count(String string) {
	    int numberWords = 0;
	    String[] words = string.split("\\s+");
	    for (String word : words) {
	    	if (word.length()>1){
	    		if (word.matches("^[,:'-@./#&+\\w]*$") && !word.matches("\\d+")) {
		            numberWords++;
	    		}
	        
	        }
	    }
	    return numberWords;
	}

}
