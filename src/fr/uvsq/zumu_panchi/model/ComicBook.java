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

    private String getScriptwriter() {
        return scriptwriter;
    }

    private String getCartoonist() {
        return cartoonist;
    }

    private void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    private void setCartoonist(String cartoonist) {
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
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAFxcAVexXw4F+c= >>
// ----------- >>
}