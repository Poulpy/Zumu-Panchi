/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Class that stores the books, along with the stock number
 * 
 * @author paul
 *
 */
public class Bookshop<T extends Work> {

    /**
     * Stores the book with the title of the book as a key
     */
    private Map<String, Stock<T>> products;

    public Bookshop() {
        products = new HashMap<String, Stock<T>>();
    }

    /**
     * Return the books as a list of string arrays: it's for the model table
     * (JTable)
     * 
     * @return
     */
    public List<String[]> getList() {
        List<String[]> list;

        list = new ArrayList<String[]>();
        Set<Map.Entry<String, Stock<T>>> entries = products.entrySet();
        Iterator<Entry<String, Stock<T>>> entriesIterator = entries.iterator();

        while (entriesIterator.hasNext()) {
            Map.Entry mapping = (Map.Entry) entriesIterator.next();
            Stock<T> b = (Stock) mapping.getValue();

            list.add(b.toStringArray());
        }

        return list;
    }

    /**
     * For the header of the model table (JTable)
     * 
     * @return
     */
    public String[] getInformations() {
        String infos[];
        infos = new String[5];

        infos[0] = "Title";
        infos[1] = "Publisher";
        infos[2] = "Publishing Year";
        infos[3] = "Price";
        infos[4] = "Stock";

        return infos;
    }

    /**
     * Increase the stock of a book by one
     * 
     * @param title
     */
    public void increaseStock(String title) {
        products.get(title).increaseStock();
    }

    public Stock getWork(String work) {
        return products.get(work);
    }

    /**
     * Parse a csv file to seed the bookshop of comicbooks
     * Format Name, Publisher, Publishing Year, Price, Stock, Author
     * 
     * 
     * @param pathToFile A CSV file containing works
     * @throws IOException
     */
    public void seedComicBooks(String pathToFile) throws IOException {
        InputStream res = Bookshop.class.getResourceAsStream("/" + pathToFile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(res));
        String line = null;
        
        while ((line = reader.readLine()) != null) {
            String args[] = line.split(",");
            Work w = new ComicBook(args[0], args[1], Integer.parseInt(args[2]), Float.parseFloat(args[3]), args[5]);
            Stock s = new Stock(w, Integer.parseInt(args[4]));
            
            products.put(args[0], s);
        }
        
        reader.close();
    }

    /**
     * Parse a csv file to seed the bookshop of books
     * @param pathToFile
     * @throws IOException
     */
    public void seedBooks(String pathToFile) throws IOException {
        InputStream res = Bookshop.class.getResourceAsStream("/" + pathToFile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(res));
        
        String line = null;
        
        while ((line = reader.readLine()) != null) {
            String args[] = line.split(",");
            Work w = new Book(args[0], args[1], Integer.parseInt(args[2]), Float.parseFloat(args[3]), args[5]);
            Stock s = new Stock(w, Integer.parseInt(args[4]));
            
            this.products.put(args[0], s);
        }
        
        reader.close();
    }
    
    /**
     * Take a random item from the bookshop
     * @return the item
     * @throws ItemOutOfStockException
     */
    public Stock<T> offerRandomItem() throws ItemOutOfStockException {
        Stock<T> itemToOffer = null;
        boolean searchForBook = true;
        
        Set<Map.Entry<String, Stock<T>>> entries = products.entrySet();
        Iterator<Entry<String, Stock<T>>> entriesIterator = entries.iterator();

        // we search for a book that is still in stock
        if (entriesIterator.hasNext() && searchForBook) {
            Map.Entry mapping = (Map.Entry) entriesIterator.next();
            Stock<T> b = (Stock) mapping.getValue();
            
            if (b.getQuantity() != 0) {
                itemToOffer = b.takeOutOneItem();
                itemToOffer.setGift(true);
                searchForBook = false;
            }
        }
        
        return itemToOffer;
    }
}
