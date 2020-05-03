/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.ArrayList;

public class SalesJournal {

    ArrayList<Cart> carts;

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
