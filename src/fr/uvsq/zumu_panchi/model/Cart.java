/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.ArrayList;

// ----------- << imports@AAAAAAFxcApPPXzNMrw= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAFxcApPPXzNMrw= >>
// ----------- >>
public class Cart {
	// ----------- << attribute.annotations@AAAAAAFxcAp1M3z4V+s= >>
	// ----------- >>
	ArrayList<Book> books;

	ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	// ----------- << method.annotations@AAAAAAFxcAr4XHz/LIY= >>
	// ----------- >>
	public int getPrice() {
		// ----------- << method.body@AAAAAAFxcAr4XHz/LIY= >>
		int totalPrice;

		totalPrice = 0;

		for (Book b : this.books) {
			totalPrice += b.getSellingPrice();
		}

		return totalPrice;
		// ----------- >>
	}

	// ----------- << method.annotations@AAAAAAFxcAs/pn0IoH8= >>
	// ----------- >>
	public int getLoyaltyPoints() {
		// ----------- << method.body@AAAAAAFxcAs/pn0IoH8= >>
		int totalPoints;

		totalPoints = 0;

		for (Book b : this.books) {
			totalPoints += b.loyaltyPoints;
		}

		return totalPoints;
		// ----------- >>
	}
// ----------- << class.extras@AAAAAAFxcApPPXzNMrw= >>
// ----------- >>
}