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
import fr.uvsq.zumu_panchi.model.StockDepletedException;
import fr.uvsq.zumu_panchi.model.Work;
import fr.uvsq.zumu_panchi.view.OrderPane;

public class BookshopController implements MouseListener, ActionListener {

    private Bookshop bookshop;
    private Cart cart;
    private OrderPane orderPane;
    private SalesJournal salesJournal;

    public BookshopController(Bookshop bookshop, Cart cart, SalesJournal salesJournal) {
        this.bookshop = bookshop;
        this.cart = cart;
        this.salesJournal = salesJournal;
    }

    /**
     * Takes out one item from the bookshop and add it to the cart
     * 
     * @param row
     * @param col
     * @throws StockDepletedException
     */
    public void addItemToCart() throws StockDepletedException {
        Stock item = this.getItemSelectedFromBookshop();

        Stock<Work> itemShipped = item.takeOutOneItem();
        cart.addItemToCart(itemShipped);

        // Updating the view
        orderPane.addItemToCart(itemShipped.getTitle());
        orderPane.updateBookshopView(this.bookshop);
        orderPane.setCartInformations(this.cart.getLoyaltyPoints(), this.cart.getPrice());
    }

    public void removeItemFromCart(int indexOfitemToRemove) throws StockDepletedException {
        Stock work = getItemSelectedFromCart();

        bookshop.increaseStock(work.getTitle());
        cart.removeItemFromCart(work);

        // update view
        orderPane.updateBookshopView(this.bookshop);
        orderPane.removeItemFromCart(indexOfitemToRemove);
        orderPane.setCartInformations(this.cart.getLoyaltyPoints(), this.cart.getPrice());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.orderPane.getOrderCartButton()) {
            System.out.println("Order ...");
            
            if (this.cart.totalItemsShipped() == 0) {
                // TODO label indicating cart is empty
                System.out.println("Cart is empty !");
            } else {
                salesJournal.addCart(this.cart);
                this.orderPane.updatePointsEarned(this.cart.getLoyaltyPoints());
                this.cart.clear();
                this.orderPane.clearCartList();
                this.orderPane.setCartInformations(0, 0f);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {

            try {
                // Add to cart
                if (e.getSource() == orderPane.getTable()) {
                    this.addItemToCart();
                    // Remove from cart
                } else if (e.getSource() == orderPane.getCartList()) {
                    int index = orderPane.getCartList().locationToIndex(e.getPoint());
                    this.removeItemFromCart(index);
                }
            } catch (StockDepletedException e1) {
                // TODO label indicating stock is 0
                e1.printStackTrace();
            }
        }
    }

    public Stock getItemSelectedFromCart() {
        JList<String> cartList = orderPane.getCartList();

        String itemToRemove = cartList.getSelectedValue();

        return this.bookshop.getWork(itemToRemove);
    }

    public Stock getItemSelectedFromBookshop() {
        JTable table = orderPane.getTable();

        int row = table.getSelectedRow();

        return this.bookshop.getWork((String) table.getValueAt(row, 0));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void setOrderPane(OrderPane orderPane) {
        this.orderPane = orderPane;
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
}
