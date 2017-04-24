package process.services;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StoreDocument {
	
	/**
	 * This method gets the content of the web's HTML, stores it in a Document object and returns it.
	 * Allowing us to parse the object obtained with the JSoup libraries in the future.
	 * @param url
	 * @return HTML document
	 */
	
	public Document getHtml(String url) {

		Document doc = null;

		try {
			doc = Jsoup.connect(url).userAgent("Chrome/13.0.782.112").timeout(100000).get();
		} catch (IOException e) {
			System.out.println("Exception obtaining the web's HTML: " + e.getMessage());
		}

		return doc;

	}

}
