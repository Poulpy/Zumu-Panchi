/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;




// ----------- << imports@AAAAAAFxcAF+1nunV8E= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAFxcAF+1nunV8E= >>
// ----------- >>
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
    protected int suppliersPrice;
    
    protected int loyaltyPoints;

    /**
    * In percent
    */

    // ----------- << attribute.annotations@AAAAAAFxcAMcH3v0hPg= >>
    // ----------- >>
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

    public int getSuppliersPrice() {
        return suppliersPrice;
    }

    public int getMargin() {
        return margin;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public void setSuppliersPrice(int suppliersPrice) {
        this.suppliersPrice = suppliersPrice;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    // ----------- << method.annotations@AAAAAAFxcAK9gnvtmGg= >>
    // ----------- >>
    public int getSellingPrice() {
    // ----------- << method.body@AAAAAAFxcAK9gnvtmGg= >>
    	return (this.margin / 100) * this.suppliersPrice;
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
    public Work(String title, String publisher, int publishingYear, int suppliersPrice) {
    	this.title = title;
    	this.publisher = publisher;
    	this.publishingYear = publishingYear;
    	this.suppliersPrice = suppliersPrice;
    }
// ----------- << class.extras@AAAAAAFxcAF+1nunV8E= >>
// ----------- >>
}