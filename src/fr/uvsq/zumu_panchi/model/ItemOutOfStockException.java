package fr.uvsq.zumu_panchi.model;

@SuppressWarnings("serial")
/**
 * Exception for when an item is out of stock
 * @author paul
 *
 */
public class ItemOutOfStockException extends Exception {

    public ItemOutOfStockException(String message) {
        super(message);
    }
}
