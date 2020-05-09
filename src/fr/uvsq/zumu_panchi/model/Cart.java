/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * A collection of books
 * 
 * @author paul
 *
 */
public class Cart<T extends Work> {


    
    private Map<String, Stock<T>> items;

    public Cart() {
        //this.works = new ArrayList<Stock<T>>();
        this.items = new HashMap<String, Stock<T>>();
    }


    /**
     * Remove an item from the cart
     * 
     * @param work
     * @throws StockDepletedException 
     */
    public void removeItemFromCart(Stock<T> item) throws StockDepletedException {
        System.out.println("Before remove > " + items.get(item.getTitle()) + ":" + items.get(item.getTitle()).getQuantity());
        //this.works.remove(item);
        if (items.get(item.getTitle()).getQuantity() == 1) {
            items.remove(item.getTitle());
        } else {
            this.items.get(item.getTitle()).decreaseStock();
        }
    }
    
    public int totalItemsShipped() {
        int total = 0;
        Set<Map.Entry<String, Stock<T>>> entries = items.entrySet();
        Iterator<Entry<String, Stock<T>>> entriesIterator = entries.iterator();

        while (entriesIterator.hasNext()) {
            Map.Entry mapping = (Map.Entry) entriesIterator.next();
            Stock<Work> b = (Stock<Work>) mapping.getValue();

            total += b.getQuantity();
        }
        
        return total;
    }

    /**
     * Add an item to the cart
     * 
     * @param work
     */
    public void addItemToCart(Stock<T> item) {
        //this.works.add(item);
        
        if (this.items.containsKey(item.getTitle())) {
            items.get(item.getTitle()).increaseStock();
        } else {
            this.items.put(item.getTitle(), item);
        }
        System.out.println("After add > " + items.get(item.getTitle()).getTitle() + ":" + items.get(item.getTitle()).getQuantity());
    }



    /**
     * Get the total price of the cart
     * 
     * @return
     */
    public float getPrice() {
        float totalPrice;

        totalPrice = 0;

        /*
        for (Stock<T> b : this.works) {
            totalPrice += b.getSellingPrice();
        }
        */
        
        Set<Map.Entry<String, Stock<T>>> entries = items.entrySet();
        Iterator<Entry<String, Stock<T>>> entriesIterator = entries.iterator();

        while (entriesIterator.hasNext()) {
            Map.Entry mapping = (Map.Entry) entriesIterator.next();
            Stock<T> b = (Stock) mapping.getValue();

            totalPrice += b.getSellingPrice();
        }


        return totalPrice;
    }

    /**
     * Get the total loyalty points of the cart
     * 
     * @return
     */
    public int getLoyaltyPoints() {
        int totalPoints;

        totalPoints = 0;

        /*
        for (Stock<T> b : this.works) {
            totalPoints += b.getLoyaltyPoints();
        }
        */
        
        
        Set<Map.Entry<String, Stock<T>>> entries = items.entrySet();
        Iterator<Entry<String, Stock<T>>> entriesIterator = entries.iterator();

        while (entriesIterator.hasNext()) {
            Map.Entry mapping = (Map.Entry) entriesIterator.next();
            Stock<T> b = (Stock) mapping.getValue();

            totalPoints += b.getLoyaltyPoints();
        }

        return totalPoints;
    }
    
    public void clear() {
        this.items.clear();
    }
}
