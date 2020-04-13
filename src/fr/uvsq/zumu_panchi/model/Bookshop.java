/*
* Made by Poulpy
*
* GitHub @Poulpy
*/
package fr.uvsq.zumu_panchi.model;

import java.util.Map;

// ----------- << imports@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>
public class Bookshop {
    // ----------- << attribute.annotations@AAAAAAFxcn3FgB5TipY= >>
    // ----------- >>
    private Map<Work, Integer> stocks;

    Map<Work, Integer> getStocks() {
        return stocks;
    }

    void setStocks(Map<Work, Integer> stocks) {
        this.stocks = stocks;
    }

// ----------- << class.extras@AAAAAAFxcn2wxx4p7L4= >>
// ----------- >>
}