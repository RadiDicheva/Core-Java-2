import java.util.HashSet;
import java.util.LinkedList;

public class WebCrawler {

	private static final int MAX_PAGES_TO_SEARCH = 10;
	private HashSet<String> pagesVisited = new HashSet<String>();
	private LinkedList<String> pagesToVisit = new LinkedList<String>();

	private String nextUrl() {
		String nextUrl;
		do
			nextUrl = pagesToVisit.remove(0);
		while (pagesVisited.contains(nextUrl));
		
		pagesVisited.add(nextUrl);
		return nextUrl;
	}
	
	public void search(String url, String needle) {
		
        while(pagesVisited.size() < MAX_PAGES_TO_SEARCH) {
            String currentUrl;
            DataCollector dc = new DataCollector();
            
            if (!pagesToVisit.isEmpty())
            	currentUrl = nextUrl();
            else {
            	currentUrl = url;
                pagesVisited.add(url);
            }
                
            dc.crawl(currentUrl);
                                  
            boolean matchFound = dc.searchForNeedle(needle);
            if(matchFound == true) {
                System.out.println("Found a match!!! Needle " + needle + " is found at " + currentUrl);
                break;
            }
            
           // pagesToVisit.addAll(dc.getAllLinks());
        }
        
        System.out.println("Visited " + pagesVisited.size() + " web pages.");
    }



	public static void main(String[] args) {

	}
}
