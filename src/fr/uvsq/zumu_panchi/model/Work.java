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
    private String title;

    // ----------- << attribute.annotations@AAAAAAFxcAIkonvYevo= >>
    // ----------- >>
    private String publisher;

    // ----------- << attribute.annotations@AAAAAAFxcAJKaXvf4Q0= >>
    // ----------- >>
    private int publishingYear;

    // ----------- << attribute.annotations@AAAAAAFxcAJ7+HvmPC4= >>
    // ----------- >>
    private int suppliersPrice;

    /**
    * In percent
    */

    // ----------- << attribute.annotations@AAAAAAFxcAMcH3v0hPg= >>
    // ----------- >>
    private int margin;

    protected String getTitle() {
        return title;
    }

    protected String getPublisher() {
        return publisher;
    }

    protected int getPublishingYear() {
        return publishingYear;
    }

    protected int getSuppliersPrice() {
        return suppliersPrice;
    }

    protected int getMargin() {
        return margin;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    protected void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    protected void setSuppliersPrice(int suppliersPrice) {
        this.suppliersPrice = suppliersPrice;
    }

    protected void setMargin(int margin) {
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
    public Work(String title, String publisher, String publishingYear, int suppliersPrice) {
    // ----------- << method.body@AAAAAAFxcAa2YnySkT0= >>
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAFxcAF+1nunV8E= >>
// ----------- >>
}