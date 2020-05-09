package fr.uvsq.zumu_panchi.model;

import java.text.SimpleDateFormat;
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
    
    /**
     * 
     * @return the day of the cart was sold. eg, 02-03-2020
     */
    public String getDayOfSellDate() {
        return new SimpleDateFormat("dd-MM-yyyy").format(sellDate);
    }
    
    public String getHourOfSellDate() {
        return new SimpleDateFormat("HH:mm").format(sellDate);
    }
    
    public String[] toStringArray() {
        return new String[] {getDayOfSellDate(), getHourOfSellDate(),
                              String.valueOf(cart.totalItemsShipped()),
                              String.format("%.2f", cart.getPrice()) + " €"};
    }
    
    public String toString() {
        return getDayOfSellDate() + " "
                + getHourOfSellDate() + " "
                + cart.toString();
    }
}
