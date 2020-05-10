package fr.uvsq.zumu_panchi.model;

/**
 * Represents a certain quantity of works.
 * Indicates if the ebook is also available, and if the item
 * is a gift (= free)
 * TODO rename Item ?
 * 
 * @author paul
 *
 * @param <T>
 */
public class Stock<T extends Work> {
   
    /**
     * The item
     */
    private T work;
    
    /**
     * Number of items stored
     */
    private int quantity = 0;
    
    private boolean ebook = false;
    
    /**
     * Is it given / free ?
     */
    private boolean gift = false;

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
        str[3] = String.format("%.2f", this.getCostPerUnit()) + " €";
        str[4] = String.valueOf(this.quantity);

        return str;
    }

    /**
     * 
     * @return the total cost of the items
     */
    public float getSellingPrice() {
        if (gift) {
            return 0f;
        } else {
            return (((100 + work.margin) / 100f) * work.suppliersPrice) * quantity;
        }
    }
    

    /**
     * 
     * @return the cost of an item
     */
    public float getCostPerUnit() {
        return (((100 + work.margin) / 100f) * work.suppliersPrice);
    }
    
    public String getTitle() {
        return this.work.getTitle();
    }
    
    /**
     * 
     * @return the total of loyalty points gained for all items
     */
    public int getLoyaltyPoints() {
        return this.work.loyaltyPoints * quantity;
    }
    
    /**
     * @return the number of items stored
     */
    public int getQuantity() {
        return quantity;
    }
    
    public String toString() {
        return work.title;
    }
    
    public void setGift(boolean b) {
        this.gift = b;
    }
    
    /**
     * Checks if the item is free
     * @return a boolean indicating if the item's free
     */
    public boolean isGift() {
        return this.gift;
    }
}
