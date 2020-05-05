package fr.uvsq.zumu_panchi.model;

public class Stock<T extends Work> {
    
    private T work;
    
    private int quantity = 0;
    
    private boolean ebook = false;

    /**
     * The number of points a customer earns after buying the work
     */
    protected int loyaltyPoints;

    /**
     * In percent. It's for calculating the price
     */
    protected int margin;

    public Stock(T work, int quantity, boolean ebook) {
        this.work = work;
        this.quantity = quantity;
        this.ebook = ebook;
    }

    public Stock(T work, int quantity) {
        this.work = work;
        this.quantity = quantity;
    }
    
    public Stock<T> takeOutOneItem() throws StockDepletedException {
        Stock<T> itemTaken = new Stock<T>(this.work, 1);
        this.decreaseStock();
        
        return itemTaken;
    }
    /**
     * Increase the stock of the book by one
     */
    public void increaseStock() {
        this.quantity++;
    }

    /**
     * Decrease the stock by one
     * Can't go below zero
     */
    public void decreaseStock() throws StockDepletedException {
        if (this.quantity > 0) {
            this.quantity--;
        } else {
            throw new StockDepletedException("There are no more items !");
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
        str[4] = String.valueOf(this.quantity);

        return str;
    }

    public float getSellingPrice() {
        return ((100 + this.margin) / 100f) * this.work.suppliersPrice;
    }
    
    public String getTitle() {
        return this.work.getTitle();
    }
    
    public int getLoyaltyPoints() {
        return this.work.loyaltyPoints;
    }
}
