/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.ArrayList;

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

    public Cart() {
        this.works = new ArrayList<Stock<T>>();
    }

    public Cart(ArrayList<Stock<T>> works) {
        this.works = works;
    }

    /**
     * Remove an item from the cart
     * 
     * @param work
     */
    public void removeItemToCart(Stock work) {
        this.works.remove(work);
    }

    /**
     * Add an item to the cart
     * 
     * @param work
     */
    public void addItemToCart(Stock<T> work) {
        this.works.add(work);
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
