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
    private Map<String, Work> stocks;

    public Map<String, Work> getStocks() {
        return stocks;
    }

    public Bookshop() {
        stocks = new HashMap<String, Work>();

        stocks.put("Hokuto no Ken", new ComicBook("Hokuto no Ken", "Shueisha", 1983, 6.0f, 2, "Tetsuo Hara"));
        stocks.put("JoJo's Bizarre Adventure", new ComicBook("JoJo's Bizarre Adventure", "Shueisha", 1986, 7.2f, 2, "Hirohiko Araki"));
        stocks.put("20th Century Boys", new ComicBook("20th Century Boys", "Shogakukan", 2000, 4.5f, 23, "Naoki Urasawa"));
        stocks.put("Berserk", new ComicBook("Berserk", "Hakusensha", 1997, 9.3f, 5, "Kentaro Miura"));
        stocks.put("Avatar", new Book("Avatar", "Michel Lévy", 1856, 19.0f, 1, "Théophile Gautier"));
    }

    public void diminishStockFor(String bookStockToDiminish) {
        Work book = this.stocks.get(bookStockToDiminish);
        book.inStock--;
        
        this.stocks.replace(bookStockToDiminish, book);
    }

    public Object[][] getArray() {
        Object[][] arr = new Object[stocks.size()][6];
        Set entries = stocks.entrySet();
        Iterator entriesIterator = entries.iterator();

        int i = 0;
        while (entriesIterator.hasNext()) {

            Map.Entry mapping = (Map.Entry) entriesIterator.next();
            Work b = (Work) mapping.getValue();
            
            arr[i][0] = b.title;
            arr[i][1] = b.publisher;
            arr[i][2] = b.publishingYear;
            arr[i][3] = String.format("%.2f", b.getSellingPrice()) + " €";
            arr[i][4] = b.inStock;

            i++;
        }

        return arr;
    }

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
// ----------- << class.extras@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>
}