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
    }
// ----------- << class.extras@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>
}