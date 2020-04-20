/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// ----------- << imports@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>
public class Bookshop {
    // ----------- << attribute.annotations@AAAAAAFxcn3FgB5TipY= >>
    // ----------- >>
    Map<Work, Integer> stocks;

    public Map<Work, Integer> getStocks() {
        return stocks;
    }

    public void setStocks(Map<Work, Integer> stocks) {
        this.stocks = stocks;
    }

    public Bookshop() {
    	stocks = new HashMap<Work, Integer>();
    	
    	stocks.put(new ComicBook("Hokuto no Ken", "Shueisha", 1983, 6.0f, "Tetsuo Hara"), 2);
    	stocks.put(new ComicBook("JoJo's Bizarre Adventure", "Shueisha", 1986, 7.2f, "Hirohiko Araki"), 2);
    	stocks.put(new ComicBook("20th Century Boys", "Shogakukan", 2000, 4.5f, "Naoki Urasawa"), 23);
    	stocks.put(new ComicBook("Berserk", "Hakusensha", 1997, 9.3f, "Kentaro Miura"), 5);
    }
    
    public void diminishStockFor(Book bookStockToDiminish) {
    	this.stocks.replace(bookStockToDiminish, this.stocks.get(bookStockToDiminish) - 1);
    }
    
    public Object[][] getArray() {
		Object[][] arr = new Object[stocks.size()][6];
		Set entries = stocks.entrySet();
		Iterator entriesIterator = entries.iterator();
		
		int i = 0;
		while(entriesIterator.hasNext()){
		
		    Map.Entry mapping = (Map.Entry) entriesIterator.next();
		    Work b = (Work) mapping.getKey();
		    /*
		    if (mapping.getKey() instanceof ComicBook)
		    	ComicBook b = (ComicBook) mapping.getKey();
		    else
		    	Book b = (Book) mapping.getKey();
		    */
		
		    arr[i][0] = b.title;
		    arr[i][1] = b.publisher;
		    arr[i][2] = b.publishingYear;
		    arr[i][3] = b.getSellingPrice();
		    arr[i][4] = mapping.getValue();
		    
		
		    i++;
		}

		return arr;
    }
    
    public String[] getInformations() {
    	String infos[];
    	infos = new String[5];
    	
    	infos[0] = "Title";
    	// infos[1] = "Author";
    	infos[1] = "Publisher";
    	infos[2] = "Publishing Year";
    	infos[3] = "Price";
    	infos[4] = "Stock";
    	
    	return infos;
    }
// ----------- << class.extras@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>
}