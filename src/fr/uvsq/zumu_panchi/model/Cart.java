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
public class Cart {

    /**
     * List of books in the cart
     */
    private ArrayList<Work> works;

    public Cart() {
        this.works = new ArrayList<Work>();
    }

    public Cart(ArrayList<Work> works) {
        this.works = works;
    }

    /**
     * Remove an item from the cart
     * 
     * @param work
     */
    public void removeItemToCart(Work work) {
        this.works.remove(work);
    }

    /**
     * Add an item to the cart
     * 
     * @param work
     */
    public void addItemToCart(Work work) {
        this.works.add(work);
    }

    public ArrayList<Work> getBooks() {
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

        for (Work b : this.works) {
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

        for (Work b : this.works) {
            totalPoints += b.loyaltyPoints;
        }

        return totalPoints;
    }
}
