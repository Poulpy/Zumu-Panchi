package fr.uvsq.zumu_panchi.model;

@SuppressWarnings("serial")
public class StockDepletedException extends Exception {

    public StockDepletedException(String message) {
        super(message);
    }
}
