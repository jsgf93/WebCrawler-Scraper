package com.web.crawler.web1;

import junit.framework.TestCase;
import process.services.WordCounter;

public class WordCounterTest1 extends TestCase {
	
	/**
	 * A test applied to the word counter method, it has to prove that only allows alphanumeric expressions, 
	 * some abbreviations and expressions with two or more characters.
	 * @param string
	 * @return numberWords
	 */
	
	public void testWordCounter() {
		WordCounter test = new WordCounter();
		//input
		int result = test.count("Surface Noise");//Scenery number two.
		//output
		assertEquals(2,result);
	}

}
