package process.services;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;

public class HTTPRequest {
	
	
	/**
	* This method checks the connection status code obtained from the HTTP request,
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
	
	public int getStatus(String url) {
		
		Response response = null;
		
		try {
			response = Jsoup.connect(url).userAgent("Chrome/13.0.782.112").timeout(100000).ignoreHttpErrors(true).execute();
		}catch (IOException e) {
			System.out.println("Connection status code exception: " + e.getMessage());
		}
		return response.statusCode();
	}

}
