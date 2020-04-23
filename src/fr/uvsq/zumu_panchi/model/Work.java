/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;




/**
 * Represents a work : book, comicbook, novel...
 * @author paul
 *
 */
public class Work {
    // ----------- << attribute.annotations@AAAAAAFxcAHJqXvRiiE= >>
    // ----------- >>
    protected String title;

    // ----------- << attribute.annotations@AAAAAAFxcAIkonvYevo= >>
    // ----------- >>
    protected String publisher;

    // ----------- << attribute.annotations@AAAAAAFxcAJKaXvf4Q0= >>
    // ----------- >>
    protected int publishingYear;

    // ----------- << attribute.annotations@AAAAAAFxcAJ7+HvmPC4= >>
    // ----------- >>
    protected float suppliersPrice;
    
    public int inStock;
    
    /**
     * The number of points a customer earns after buying the work
     */
    protected int loyaltyPoints;

    /**
    * In percent
    */
    protected int margin;

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



    // ----------- << method.annotations@AAAAAAFxcAK9gnvtmGg= >>
    // ----------- >>
    public float getSellingPrice() {
    // ----------- << method.body@AAAAAAFxcAK9gnvtmGg= >>
    	return ((100 + this.margin) / 100f) * this.suppliersPrice;
    // ----------- >>
    }
    
    /**
    * @param title 
    * @param publisher 
    * @param publishingYear 
    * @param suppliersPrice
    */

    // ----------- << method.annotations@AAAAAAFxcAa2YnySkT0= >>
    // ----------- >>
    public Work(String title, String publisher, int publishingYear, float suppliersPrice, int inStock) {
    	this.title = title;
    	this.publisher = publisher;
    	this.publishingYear = publishingYear;
    	this.suppliersPrice = suppliersPrice;
    	this.inStock = inStock;
    }
    
    public String[] toStringArray() {
        String[] str;
        
        str = new String[5];
        
        str[0] = this.title;
        str[1] = this.publisher;
        str[2] = String.valueOf(this.publishingYear);
        str[3] = String.format("%.2f", this.getSellingPrice()) + " €";
        str[4] = String.valueOf(this.inStock);
        
        return str;
    }
    
    
    public String toString() {
    	return this.title + " " + this.publisher + " " + this.publishingYear;
    }
// ----------- << class.extras@AAAAAAFxcAF+1nunV8E= >>
// ----------- >>
}