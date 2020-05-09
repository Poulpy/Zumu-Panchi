/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SalesJournal {

    /**
     * The key is the day, something like 02-03-1999
     * equivalent to dd-mm-yyyy 
     */
    Map<String, ArrayList<Sale>> sales;

    public SalesJournal() {
        this.sales = new HashMap<String, ArrayList<Sale>>();
    }


    public void addCart(Cart cartToAdd) {
        Sale s = new Sale(cartToAdd);
        String key = s.getDayOfSellDate();
        
        if (sales.get(key) == null) {
            sales.put(key, new ArrayList<Sale>());
        }
        
        sales.get(key).add(s);
    }
}
