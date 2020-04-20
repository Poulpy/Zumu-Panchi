/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Work> works;

    public ArrayList<Work> getBooks() {
        return this.works;
    }
    
    public void addItemToCart(Work work) {
        this.works.add(work);
    }

    public Cart() {
        this.works = new ArrayList<Work>();
    }
    
    public Cart(ArrayList<Work> works) {
        this.works = works;
    }

    public float getPrice() {
        float totalPrice;

        totalPrice = 0;

        for (Work b : this.works) {
            totalPrice += b.getSellingPrice();
        }

        return totalPrice;
    }

    public int getLoyaltyPoints() {
        int totalPoints;

        totalPoints = 0;

        for (Work b : this.works) {
            totalPoints += b.loyaltyPoints;
        }

        return totalPoints;
    }
}
