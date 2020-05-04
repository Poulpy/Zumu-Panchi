/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A collection of books
 * 
 * @author paul
 *
 */
public class Cart<T extends Work> {

    /**
     * List of books in the cart
     */
    private ArrayList<Stock<T>> works;
    
    private Map<String, Stock<T>> items;

    public Cart() {
        this.works = new ArrayList<Stock<T>>();
        this.items = new HashMap<String, Stock<T>>();
    }


    /**
     * Remove an item from the cart
     * 
     * @param work
     * @throws StockDepletedException 
     */
    public void removeItemFromCart(Stock<T> item) throws StockDepletedException {
        this.works.remove(item);
        this.items.get(item.getTitle()).decreaseStock();
    }

    /**
     * Add an item to the cart
     * 
     * @param work
     */
    public void addItemToCart(Stock<T> item) {
        this.works.add(item);
        
        if (this.items.containsKey(item)) {
            this.items.get(item).increaseStock();
        } else {
            this.items.put(item.getTitle(), item);
        }
    }

    public ArrayList<Stock<T>> getBooks() {
        return this.works;
    }

    /**
     * Get the total price of the cart
     * 
     * @return
     */
    public float getPrice() {
        float totalPrice;

        totalPrice = 0;

        for (Stock<T> b : this.works) {
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

        for (Stock<T> b : this.works) {
            totalPoints += b.getLoyaltyPoints();
        }

        return totalPoints;
    }
    
    public void clear() {
        this.works.clear();
    }
}
