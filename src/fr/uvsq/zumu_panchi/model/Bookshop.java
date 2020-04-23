/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Bookshop {

    private Map<String, Work> stocks;

    public Map<String, Work> getStocks() {
        return stocks;
    }

    public Work getWork(String work) {
        return this.stocks.get(work);
    }

    public Bookshop() {
        stocks = new HashMap<String, Work>();

        // TODO put in CSV ?
        stocks.put("Hokuto no Ken", new ComicBook("Hokuto no Ken", "Shueisha", 1983, 6.0f, 2, "Tetsuo Hara"));
        stocks.put("JoJo's Bizarre Adventure",
                new ComicBook("JoJo's Bizarre Adventure", "Shueisha", 1986, 7.2f, 2, "Hirohiko Araki"));
        stocks.put("20th Century Boys",
                new ComicBook("20th Century Boys", "Shogakukan", 2000, 4.5f, 23, "Naoki Urasawa"));
        stocks.put("Berserk", new ComicBook("Berserk", "Hakusensha", 1997, 9.3f, 5, "Kentaro Miura"));
        stocks.put("Avatar", new Book("Avatar", "Michel Lévy", 1856, 19.0f, 1, "Théophile Gautier"));
    }

    public List<String[]> getList() {
        List<String[]> list;

        list = new ArrayList<String[]>();
        Set entries = stocks.entrySet();
        Iterator entriesIterator = entries.iterator();

        while (entriesIterator.hasNext()) {
            Map.Entry mapping = (Map.Entry) entriesIterator.next();
            Work b = (Work) mapping.getValue();

            list.add(b.toStringArray());
        }

        return list;
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

    public void increaseStock(String title) {
        this.stocks.get(title).increaseStock();
    }

    public void decreaseStock(String bookStockToDiminish) {
        Work book = this.stocks.get(bookStockToDiminish);
        book.decreaseStock();

        this.stocks.replace(bookStockToDiminish, book);
    }
}
