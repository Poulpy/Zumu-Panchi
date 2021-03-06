package fr.uvsq.zumu_panchi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JTable;

import fr.uvsq.zumu_panchi.model.Bookshop;
import fr.uvsq.zumu_panchi.model.Cart;
import fr.uvsq.zumu_panchi.model.SalesJournal;
import fr.uvsq.zumu_panchi.model.Stock;
import fr.uvsq.zumu_panchi.model.ItemOutOfStockException;
import fr.uvsq.zumu_panchi.model.Work;
import fr.uvsq.zumu_panchi.view.OrderPane;
import fr.uvsq.zumu_panchi.view.SalesPane;

public class BookshopController implements MouseListener, ActionListener {

    // Models
    private Bookshop bookshop;
    private Cart<Work> cart;
    private SalesJournal salesJournal;
    private int loyaltyPoints;
    private final int THRESHOLD = 500;
    
    // Views
    private SalesPane salesPane;
    private OrderPane orderPane;

    public BookshopController(Bookshop bookshop, Cart<Work> cart, SalesJournal salesJournal) {
        this.bookshop = bookshop;
        this.cart = cart;
        this.salesJournal = salesJournal;
        this.loyaltyPoints = 0;
    }

    /**
     * Takes out one item from the bookshop and add it to the cart
     * 
     * @throws ItemOutOfStockException
     */
    public void addItemToCart() throws ItemOutOfStockException {
        Stock<Work> item = this.getItemSelectedFromBookshop();

        Stock<Work> itemShipped = item.takeOutOneItem();
        cart.addItemToCart(itemShipped);

        // Updating the view
        orderPane.addItemToCart(itemShipped.getTitle());
        orderPane.updateBookshopView(this.bookshop);
        orderPane.setCartInformations(this.cart.getLoyaltyPoints(), this.cart.getPrice());
    }

    /**
     * Remove an item from a cart
     * @param indexOfitemToRemove
     * @throws ItemOutOfStockException
     */
    public void removeItemFromCart(int indexOfitemToRemove) throws ItemOutOfStockException {
        Stock work = getItemSelectedFromCart();

        bookshop.increaseStock(work.getTitle());
        cart.removeItemFromCart(work);

        // update view
        orderPane.updateBookshopView(this.bookshop);
        orderPane.removeItemFromCart(indexOfitemToRemove);
        orderPane.setCartInformations(this.cart.getLoyaltyPoints(), this.cart.getPrice());
    }

    @Override
    /**
     * Triggered when the user clicks on the order button
     * TODO refactor
     */
    public void actionPerformed(ActionEvent e) {
        Stock freeItem;
        
        if (e.getSource() == orderPane.getOrderCartButton()) {
            
            if (this.cart.totalItemsShipped() == 0) {
                orderPane.notification("Cart is empty !");
            } else {
                // Adding the cart to the sales, and updating the view
                loyaltyPoints += cart.getLoyaltyPoints();
                
                // if the user has more than 1000 points a book is given for free
                if (loyaltyPoints >= THRESHOLD) {
                    freeItem = bookshop.offerRandomItem();
                    if (freeItem == null) {
                        orderPane.notification("Couldn't find an item for you. Come next time !");
                    } else {
                        cart.addItemToCart(freeItem);
                        orderPane.updateBookshopView(this.bookshop);
                        System.out.println("You've reached "
                                + THRESHOLD
                                + " points ! The bookshop offers you a free book !"
                                + "\n" + freeItem);
                        orderPane.notification("You've reached " + THRESHOLD
                                + " points ! The bookshop offers you a free book ! " + freeItem);
                        loyaltyPoints -= THRESHOLD;
                    }
  
                } else {
                    orderPane.notification(cart.orderDoneMessage());
                }
                
                salesJournal.addCart(cart);
                salesPane.updateSalesView(salesJournal);
                
                orderPane.updatePointsEarned(loyaltyPoints);
                cart = new Cart<Work>();
                orderPane.clearCartList();
                orderPane.setCartInformations(0, 0f);
            }
        }
    }


    @Override
    /**
     * When the user clicks on a book of the bookshop
     * or
     * a book of the cart
     */
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1 || e.getClickCount() == 2) {

            try {
                // Add to cart
                if (e.getSource() == orderPane.getTable()) {
                    this.addItemToCart();
                    // Remove from cart
                } else if (e.getSource() == orderPane.getCartList()) {
                    int index = orderPane.getCartList().locationToIndex(e.getPoint());
                    this.removeItemFromCart(index);
                }
            } catch (ItemOutOfStockException e1) {
                orderPane.notification("Item is out of stock :D !");
            }
        }
    }

    /**
     * Get selected item in the cart in the view
     * @return
     */
    public Stock getItemSelectedFromCart() {
        JList<String> cartList = orderPane.getCartList();

        String itemToRemove = cartList.getSelectedValue();

        return this.bookshop.getWork(itemToRemove);
    }

    /**
     * Get selected item in the bookshop table in the view
     * @return
     */
    public Stock<Work> getItemSelectedFromBookshop() {
        JTable table = orderPane.getTable();

        int row = table.getSelectedRow();

        return this.bookshop.getWork((String) table.getValueAt(row, 0));
    }

    public void setOrderPane(OrderPane orderPane) {
        this.orderPane = orderPane;
    }
    
    public void setSalesPane(SalesPane salesPane) {
        this.salesPane = salesPane;
    }

    public Cart getCart() {
        return this.cart;
    }

    public Bookshop getBookshop() {
        return this.bookshop;
    }

    public SalesJournal getSalesJournal() {
        return this.salesJournal;
    }

    // Methods not used
    
    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
