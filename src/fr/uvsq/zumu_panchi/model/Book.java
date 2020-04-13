/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;




// ----------- << imports@AAAAAAFxcAQHa3v9Uag= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAFxcAQHa3v9Uag= >>
// ----------- >>
public class Book extends Work {
    // ----------- << attribute.annotations@AAAAAAFxcAQhRXwnkVA= >>
    // ----------- >>
    String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
    * @param title 
    * @param publisher 
    * @param publishingYear 
    * @param suppliersPrice
    */

    // ----------- << method.annotations@AAAAAAFxcAfiJXytv1c= >>
    // ----------- >>
    public Book(String title, String publisher, String publishingYear, int suppliersPrice) {
    // ----------- << method.body@AAAAAAFxcAfiJXytv1c= >>
    	super(title, publisher, publishingYear, suppliersPrice);
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAFxcAQHa3v9Uag= >>
// ----------- >>
}