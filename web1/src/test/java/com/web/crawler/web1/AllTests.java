package com.web.crawler.web1;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTest(AppTest.suite());
		suite.addTestSuite(ConvertionTest.class);
		suite.addTestSuite(ConvertionTest1.class);
		suite.addTestSuite(HTTPRequestTest.class);
		suite.addTestSuite(WordCounterTest.class);
		suite.addTestSuite(WordCounterTest1.class);
		suite.addTestSuite(WordCounterTest2.class);
		suite.addTestSuite(WordCounterTest3.class);
		//$JUnit-END$
		return suite;
	}

}
