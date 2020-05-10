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
import java.util.Map.Entry;
import java.util.Set;

/**
 * Contains all sales
 * 
 * @author paul
 *
 */
public class SalesJournal {

    /**
     * The key is the day, something like 02-03-1999 equivalent to dd-mm-yyyy
     */
    Map<String, ArrayList<Sale>> sales;

    public SalesJournal() {
        this.sales = new HashMap<String, ArrayList<Sale>>();
    }

    /**
     * Add a cart to the sales journal
     * 
     * @param cartToAdd
     */
    public void addCart(Cart cartToAdd) {
        ArrayList<Sale> salesToUpdate = new ArrayList<Sale>();
        Sale s = new Sale(cartToAdd);
        String key = s.getDayOfSellDate();

        if (sales.containsKey(key)) {
            salesToUpdate = sales.get(key);
        }

        salesToUpdate.add(s);
        sales.put(key, salesToUpdate);
    }

    /**
     * For the table model (view)
     * 
     * @return
     */
    public List<String[]> getList() {
        List<String[]> list;

        list = new ArrayList<String[]>();

        Set<Map.Entry<String, ArrayList<Sale>>> entries = sales.entrySet();
        Iterator<Entry<String, ArrayList<Sale>>> entriesIterator = entries.iterator();

        while (entriesIterator.hasNext()) {
            Map.Entry mapping = (Map.Entry) entriesIterator.next();
            ArrayList<Sale> allSales = (ArrayList<Sale>) mapping.getValue();

            for (Sale s : allSales) {
                list.add(s.toStringArray());
            }
        }

        return list;
    }
}
