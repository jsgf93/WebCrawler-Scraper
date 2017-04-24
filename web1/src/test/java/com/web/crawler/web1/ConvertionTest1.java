package com.web.crawler.web1;

import junit.framework.TestCase;
import process.services.Conversion;

public class ConvertionTest1 extends TestCase {
	
	/**
	 * A test applied to the conversion method, it converts a string into a number, 
	 * erase all not numeric characters and parses the result into an integer.
	 * @param string
	 * @return number
	 */
	
	public void testConvertion() {
		Conversion test = new Conversion();
		//input
		int result = test.convertNumbers("1https://news1.ycombinator.com/");
		//output
		assertEquals(11,result);
	}

}
