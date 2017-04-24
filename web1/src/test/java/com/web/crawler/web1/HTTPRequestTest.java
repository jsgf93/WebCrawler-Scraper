package com.web.crawler.web1;

import junit.framework.TestCase;
import process.services.HTTPRequest;

public class HTTPRequestTest extends TestCase {
	
	/**
	* A test applied to the HTTP request method, it checks the connection status code obtained from the HTTP request,
	* it will use a fake user agent so the web server thinks the web crawler is a normal web browser.
	* OPTIONS:
	* 		200 OK					300 Multiple Choices
	* 		301 Moved Permanently	305 Use Proxy
	* 		400 Bad Request			403 Forbidden
	* 		404 Not Found			500 Internal Server Error
	* 		502 Bad Gateway			503 Service Unavailable
	* @param url
	* @return statusCode
	*/
	
	public void testHTTPRequest() {
		HTTPRequest test = new HTTPRequest();
		//input
		int result = test.getStatus("https://news.ycombinator.com/");
		//output
		assertEquals(200,result);
	}

}
