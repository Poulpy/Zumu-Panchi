package fr.uvsq.zumu_panchi.model;

public class Stock {
    
    private Work work;
    
    private int stock = 0;
    
    private boolean ebookAvailable = false;

    /**
     * The number of points a customer earns after buying the work
     */
    protected int loyaltyPoints;

    /**
     * In percent. It's for calculating the price
     */
    protected int margin;

    public Stock(Work work, int stock, boolean ebookAvailable) {
        this.work = work;
        this.stock = stock;
        this.ebookAvailable = ebookAvailable;
    }

    /**
     * Increase the stock of the book by one
     */
    public void increaseStock() {
        this.stock++;
    }

    /**
     * Decrease the stock by one
     * Can't go below zero
     */
    public void decreaseStock() {
        if (this.stock > 0) {
            this.stock--;
        }
    }
    

    /**
     * Put the attributes of the book to a string array
     * @return
     */
    public String[] toStringArray() {
        String[] str;

        str = new String[5];

        str[0] = this.work.title;
        str[1] = this.work.publisher;
        str[2] = String.valueOf(this.work.publishingYear);
        str[3] = String.format("%.2f", this.getSellingPrice()) + " €";
        str[4] = String.valueOf(this.stock);

        return str;
    }


    public int getMargin() {
        return margin;
    }

    public float getSellingPrice() {
        return ((100 + this.margin) / 100f) * this.work.suppliersPrice;
    }
    
    public int getStock() {
        return this.stock;
    }
}
