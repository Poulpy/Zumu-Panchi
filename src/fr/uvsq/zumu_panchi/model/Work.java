/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

/**
 * Represents a work : book, comicbook, novel...
 * 
 * @author paul
 *
 */
public class Work {

    protected String title;

    protected String publisher;

    protected int publishingYear;

    protected float suppliersPrice;

    /**
     * Number of books available TODO SHOULD BE DEPENDENT OF THE BOOKSHOP and not
     * the book (it's a weird idea anyway)
     */
    private int stock;

    /**
     * The number of points a customer earns after buying the work
     */
    protected int loyaltyPoints;

    /**
     * In percent. It's for calculating the price
     */
    protected int margin;

    /**
     * Increase the stock of the book by one
     */
    public void increaseStock() {
        this.stock++;
    }

    /**
     * Decrease the stock by one
     * Can't go below zero
     */
    public void decreaseStock() {
        if (this.stock > 0) {
            this.stock--;
        }
    }


    /**
     * @param title
     * @param publisher
     * @param publishingYear
     * @param suppliersPrice
     */
    public Work(String title, String publisher, int publishingYear, float suppliersPrice, int inStock) {
        this.title = title;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.suppliersPrice = suppliersPrice;
        
        if (inStock >= 0)
            this.stock = inStock;
        else
            this.stock = 0;
    }

    /**
     * Put the attributes of the book to a string array
     * @return
     */
    public String[] toStringArray() {
        String[] str;

        str = new String[5];

        str[0] = this.title;
        str[1] = this.publisher;
        str[2] = String.valueOf(this.publishingYear);
        str[3] = String.format("%.2f", this.getSellingPrice()) + " €";
        str[4] = String.valueOf(this.stock);

        return str;
    }

    public String toString() {
        return this.title + " " + this.publisher + " " + this.publishingYear;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public float getSuppliersPrice() {
        return suppliersPrice;
    }

    public int getMargin() {
        return margin;
    }

    public float getSellingPrice() {
        return ((100 + this.margin) / 100f) * this.suppliersPrice;
    }
    
    public int getStock() {
        return this.stock;
    }
}
