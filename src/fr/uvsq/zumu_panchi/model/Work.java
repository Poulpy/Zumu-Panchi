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
     * The number of points a customer earns after buying the work
     */
    protected int loyaltyPoints;

    /**
     * In percent. It's for calculating the price
     */
    protected int margin;




    /**
     * @param title
     * @param publisher
     * @param publishingYear
     * @param suppliersPrice
     */
    public Work(String title, String publisher, int publishingYear, float suppliersPrice) {
        this.title = title;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.suppliersPrice = suppliersPrice;
 
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

}
