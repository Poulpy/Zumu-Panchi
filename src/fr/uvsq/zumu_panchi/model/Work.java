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
    
    protected String title;

    protected String publisher;

    protected int publishingYear;

    protected float suppliersPrice;
    
    private int stock;
    
    /**
     * The number of points a customer earns after buying the work
     */
    protected int loyaltyPoints;

    /**
    * In percent
    */
    protected int margin;
    
    public int getStock() {
        return this.stock;
    }
    
    public void decreaseStockBy(int decrease) {
        if (this.stock >= decrease) {
            this.stock -= decrease;
        }
    }
    
    public void increaseStock() {
        this.stock++;
    }
    
    /**
     * Decrease the stock by one
     */
    public void decreaseStock() {
        if (this.stock > 0) {
            this.stock--;
        }
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
    	this.stock = inStock;
    }
    
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
// ----------- << class.extras@AAAAAAFxcAF+1nunV8E= >>
// ----------- >>
}