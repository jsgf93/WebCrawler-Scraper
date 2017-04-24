package com.web.crawler.web1;

import java.util.Arrays;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import process.services.*;
import source.dto.Entry;

/**
 * A web crawler that uses scraping techniques
 *
 */
public class App 
{
	
	public static final String url = "https://news.ycombinator.com/";
	
    public static void main( String[] args ) {
    	
    	// Instantiate classes
    	HTTPRequest request = new HTTPRequest();
    	StoreDocument store = new StoreDocument();
    	Entry[] entry = new Entry[30];
    	WordCounter counter = new WordCounter();
    	Convertion convert = new Convertion();
    	
    	// Check the response with the connection status code obtained from the HTTP request.
    	if (request.getStatus(url) == 200) {
    		
    		// Obtain the HTML page of the web and store it in a Document object.
    		Document document = store.getHtml(url);
    		
    		// Search for the 30 first entries(the web page is designed to display only 30 entries at once).
    		Elements entries = document.select("tr.athing");//gets the number and the title of the entries.
    		Elements entries1 = document.select("td.subtext");//gets the number of comments and points.
    		System.out.println("Number of entries in the web page: "+entries.size()+"\n");
    		
    		int i= 0;
    		
    		// Initializing entries array
    		for (i=0;i<30;i++){
    			entry[i] = new Entry();
    		}
    		
    		// Scraping the HTML document and storing it.
    		i = 0;
    		for (Element elem : entries) {
    			entry[i].setRank(elem.getElementsByClass("rank").text());
    			entry[i].setTitle(elem.getElementsByClass("storylink").text());				
    			i++;
    		}
    		i = 0;
    		for (Element elem1 : entries1) {
    			String comments = elem1.select("a:containsOwn(comments)").text();
    			if (comments.equals("")){
    				entry[i].setNumberComments("0 comments");
    			}else{
    				entry[i].setNumberComments(comments);
    			}
    			String score = elem1.getElementsByClass("score").text();
    			if (score.equals("")){
    				entry[i].setNumberPoints("0 points");
    			}else{
    				entry[i].setNumberPoints(score);
    			}				
    			i++;
    		}
    		
    		//Print the 30 entries scraped.
    		for (i=0;i<30;i++){
    			System.out.println(entry[i].getRank()+" "+entry[i].getTitle()+"\n"+entry[i].getNumberComments()+"\n"+entry[i].getNumberPoints()+"\n\n");
    		}
    		
    		//Count the number of words in each entries' titles and filter the ones that have more than five and the ones
    		//that have less than or equal to five words.
    		int j = 0;
    		int k = 0;
    		for (i=0;i<30;i++){
    			if (counter.count(entry[i].getTitle())>5){//filtering operation number one.
    				j++;
    			}
    			else{//filtering operation number two.
    				k++;
    			}		
    		}
    		int[][] firstArray = new int[j][2];
    		int[][] secondArray = new int[k][2];
    		j = 0;
    		k = 0;
    		for (i=0;i<30;i++){
    			if (counter.count(entry[i].getTitle())>5){//filtering operation number one.
    				 firstArray[j][0] = convert.convertRank(entry[i].getRank());
    				 firstArray[j][1] = convert.convertNumbers(entry[i].getNumberComments());
    				j++;
    			}
    			else{//filtering operation number two.
    				secondArray[k][0] = convert.convertRank(entry[i].getRank());
    				secondArray[k][1] = convert.convertNumbers(entry[i].getNumberPoints());
    				k++;
    			}
    		}
    		
			//Continuing with the filtering operation number one, now we have to sort by number of comments 
    		//of the filtered entries, from highest to lowest.
    		Arrays.sort(firstArray, (a, b) -> Integer.compare(b[1], a[1]));
    		System.out.println("\n**************************************************\n");
    		System.out.println("\nFiltering operation number 1:\n");
    		for (i=0;i<firstArray.length;i++){
    			System.out.println(entry[firstArray[i][0]-1].getRank()+" "+entry[firstArray[i][0]-1].getTitle()+"\n"+entry[firstArray[i][0]-1].getNumberComments()+"\n\n");	
    		}
    		
    		//Continuing with the filtering operation number two, now we have to sort by number of points 
    		//of the filtered entries, from highest to lowest.
    		Arrays.sort(secondArray, (a, b) -> Integer.compare(b[1], a[1]));
    		System.out.println("\n**************************************************\n");
    		System.out.println("\nFiltering operation number 2:\n");
    		for (i=0;i<secondArray.length;i++){
    			System.out.println(entry[secondArray[i][0]-1].getRank()+" "+entry[secondArray[i][0]-1].getTitle()+"\n"+entry[secondArray[i][0]-1].getNumberPoints()+"\n\n");
    		}
    					
    	}else
    				System.out.println("The connection status code is not OK, the response is: "+request.getStatus(url));		
    }

}

