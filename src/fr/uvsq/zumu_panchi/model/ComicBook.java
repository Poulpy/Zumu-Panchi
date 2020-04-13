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
    String scriptwriter;

    // ----------- << attribute.annotations@AAAAAAFxcAXjbHxpUV4= >>
    // ----------- >>
    String cartoonist;

    public String getScriptwriter() {
        return scriptwriter;
    }

    public String getCartoonist() {
        return cartoonist;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    public void setCartoonist(String cartoonist) {
        this.cartoonist = cartoonist;
    }

    /**
    * @param title 
    * @param publisher 
    * @param publishingYear 
    * @param suppliersPrice
    */

    // ----------- << method.annotations@AAAAAAFxcAg513y+eRk= >>
    // ----------- >>
    public ComicBook(String title, String publisher, String publishingYear, int suppliersPrice) {
    // ----------- << method.body@AAAAAAFxcAg513y+eRk= >>
    	super(title, publisher, publishingYear, suppliersPrice);
    	this.margin = 40;
    	this.loyaltyPoints = 50;
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAFxcAVexXw4F+c= >>
// ----------- >>
}