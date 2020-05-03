/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.ArrayList;
import java.util.Map;

public class SalesJournal {

    ArrayList<Cart> carts;
    // better implementation
    /**
     * The key is the day, something like 02-03-1999
     * equivalent to dd-mm-yyyy 
     */
    Map<String, ArrayList<Sale>> sales;

    public SalesJournal() {
        this.carts = new ArrayList<Cart>();
    }

    public ArrayList<Cart> getCarts() {
        return carts;
    }

    public void setCarts(ArrayList<Cart> carts) {
        this.carts = carts;
    }

    public void addCart(Cart cartToAdd) {
        carts.add(cartToAdd);
    }
}
