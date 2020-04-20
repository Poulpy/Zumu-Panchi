/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

/**
 * A book is a work with an author
 * 
 * @author paul
 *
 */
public class Book extends Work {
    // ----------- << attribute.annotations@AAAAAAFxcAQhRXwnkVA= >>
    // ----------- >>
    private String author;

    public String getAuthor() {
        return author;
    }

    /**
     * @param title
     * @param publisher
     * @param publishingYear
     * @param suppliersPrice
     */
    public Book(String title, String publisher, int publishingYear, float suppliersPrice, String author) {
        super(title, publisher, publishingYear, suppliersPrice);

        this.author = author;
        this.margin = 20;
        this.loyaltyPoints = 30;
    }
}
