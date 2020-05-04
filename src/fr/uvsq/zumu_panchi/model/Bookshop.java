/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

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
        //Set<Map.Entry<String, Work>> entries = stocks.entrySet();
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
        this.products.get(title).increaseStock();
    }

    /**
     * Decrease the stock of a book by one
     * 
     * @param bookStockToDiminish
     */
    public void decreaseStock(String bookStockToDiminish) {
        Stock<T> book = this.products.get(bookStockToDiminish);
        book.decreaseStock();

        this.products.replace(bookStockToDiminish, book);
    }

    public Map<String, Stock<T>> getStocks() {
        return products;
    }

    public Stock getWork(String work) {
        return this.products.get(work);
    }

    /**
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
            this.products.put(args[0], s);
        }
        
        reader.close();
    }

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
}
