package fr.uvsq.zumu_panchi.model;

import java.util.Date;

public class Sale implements Comparable<Sale> {

    private Date sellDate;

    private Cart cart;

    public Sale(Cart cart) {
        this.cart = cart;
        this.sellDate = new Date();
    }

    public Date getSellDate() {
        return sellDate;
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public int compareTo(Sale s) {
        return sellDate.compareTo(s.sellDate);
    }
}
