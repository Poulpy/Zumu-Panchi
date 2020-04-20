/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

/**
 * and a cartoonist
 * 
 * @author paul
 *
 */
public class ComicBook extends Work {

    /**
     * The one who writes the scenario/script of the comicbook
     */
    private String scriptwriter;

    /**
     * The one who draws the illustrations
     */
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
    public ComicBook(String title, String publisher, int publishingYear, float suppliersPrice, String cartoonist,
            String scriptwriter) {
        super(title, publisher, publishingYear, suppliersPrice);

        this.cartoonist = cartoonist;
        this.scriptwriter = scriptwriter;
        this.margin = 50;
        this.loyaltyPoints = 50;
    }

    public ComicBook(String title, String publisher, int publishingYear, float suppliersPrice, String author) {
        this(title, publisher, publishingYear, suppliersPrice, author, author);
    }
}
