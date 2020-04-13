/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.HashMap;
import java.util.Map;

// ----------- << imports@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>
public class Bookshop {
    // ----------- << attribute.annotations@AAAAAAFxcn3FgB5TipY= >>
    // ----------- >>
    Map<Work, Integer> stocks;

    public Map<Work, Integer> getStocks() {
        return stocks;
    }

    public void setStocks(Map<Work, Integer> stocks) {
        this.stocks = stocks;
    }

    public Bookshop() {
    	stocks = new HashMap<Work, Integer>();
    	
    	stocks.put(new Book("Hokuto no Ken", "Shueisha", 1983, 6.0f), 2);
    	stocks.put(new Book("JoJo's Bizarre Adventure", "Shueisha", 1986, 7.2f), 2);
    	stocks.put(new Book("20th Century Boys", "Shōgakukan", 2000, 4.5f), 23);
    	stocks.put(new Book("Berserk", "Hakusensha", 1997, 9.3f), 5);
    }
// ----------- << class.extras@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>
}