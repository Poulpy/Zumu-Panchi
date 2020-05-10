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

    /**
     * Year the work was published
     */
    protected int publishingYear;

    /**
     * Price of the supplier
     */
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
    
    public Work(Work w) {
        this.title = w.title;
        this.publisher = w.publisher;
        this.publishingYear = w.publishingYear;
        this.suppliersPrice = w.suppliersPrice;
    }

    public String toString() {
        return this.title + " " + this.publisher + " " + this.publishingYear;
    }

    public String getTitle() {
        return title;
    }
}
