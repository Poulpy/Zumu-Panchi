package fr.uvsq.zumu_panchi.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale implements Comparable<Sale> {

    /**
     * The date the cart was sold
     */
    private Date sellDate;

    /**
     * The cart which was sold
     */
    private Cart cart;

    public Sale(Cart cart) {
        this.cart = cart;
        this.sellDate = new Date();
    }

    @Override
    /**
     * Usefull for future implementation, if we want to show the sales ordered by
     * date
     */
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

    /**
     * 
     * @return the hour the cart was sold eg 09:14
     */
    public String getHourOfSellDate() {
        return new SimpleDateFormat("HH:mm").format(sellDate);
    }

    /**
     * For the table model
     * 
     * @return
     */
    public String[] toStringArray() {
        return new String[] { getDayOfSellDate(), getHourOfSellDate(),
                String.valueOf(cart.totalItemsShipped()),
                String.format("%.2f", cart.getPrice()) + " €" };
    }

    public String toString() {
        return getDayOfSellDate() + " " + getHourOfSellDate() + " " + cart.toString();
    }
}
