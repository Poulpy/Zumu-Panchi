/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;




// ----------- << imports@AAAAAAFxcAVexXw4F+c= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAFxcAVexXw4F+c= >>
// ----------- >>
public class ComicBook extends Work {
    // ----------- << attribute.annotations@AAAAAAFxcAWK3nxiOZg= >>
    // ----------- >>
    private String scriptwriter;

    // ----------- << attribute.annotations@AAAAAAFxcAXjbHxpUV4= >>
    // ----------- >>
    private String cartoonist;

    public String getScriptwriter() {
        return scriptwriter;
    }

    public String getCartoonist() {
        return cartoonist;
    }


    /**
    * @param title 
    * @param publisher 
    * @param publishingYear 
    * @param suppliersPrice
    */

    // ----------- << method.annotations@AAAAAAFxcAg513y+eRk= >>
    // ----------- >>
    public ComicBook(String title, String publisher, int publishingYear, float suppliersPrice, String cartoonist, String scriptwriter) {
    // ----------- << method.body@AAAAAAFxcAg513y+eRk= >>
    	super(title, publisher, publishingYear, suppliersPrice);
    	this.cartoonist = cartoonist;
    	this.scriptwriter = scriptwriter;
    	this.margin = 40;
    	this.loyaltyPoints = 50;
    // ----------- >>
    }
    
    public ComicBook(String title, String publisher, int publishingYear, float suppliersPrice, String author) {
    // ----------- << method.body@AAAAAAFxcAg513y+eRk= >>
    	this(title, publisher, publishingYear, suppliersPrice, author, author);
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAFxcAVexXw4F+c= >>
// ----------- >>
}