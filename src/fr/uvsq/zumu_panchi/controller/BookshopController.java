package fr.uvsq.zumu_panchi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;

import fr.uvsq.zumu_panchi.model.Bookshop;
import fr.uvsq.zumu_panchi.model.Cart;
import fr.uvsq.zumu_panchi.model.Work;
import fr.uvsq.zumu_panchi.view.OrderPane;
import fr.uvsq.zumu_panchi.view.WorksTable;

public class BookshopController implements MouseListener, ActionListener {

    private Bookshop bookshop;
    private Cart cart;
    private OrderPane orderPane;

    public BookshopController(Bookshop bookshop, Cart cart, OrderPane orderPane) {
        this.bookshop = bookshop;
        this.cart = cart;
        this.orderPane = orderPane;
    }

    public void addElementToCart(int row, int col) {
        JTable table = orderPane.getTable();
        DefaultListModel<String> cartListModel = orderPane.getCartListModel();
        WorksTable modelTable = orderPane.getModelTable();

        Work work = this.bookshop.getWork((String) table.getValueAt(row, 0));

        if (work.getStock() == 0) {
            System.out.println("No stocks available !");
            return;
        }

        this.bookshop.decreaseStock(work.getTitle());
        cart.addItemToCart(work);
        cartListModel.addElement(work.getTitle());

        modelTable.update(bookshop);
        modelTable.fireTableDataChanged();
    }

    public void removeItemFromCart(int indexOfitemToRemove) {
        JTable table = orderPane.getTable();
        DefaultListModel<String> cartListModel = orderPane.getCartListModel();
        JList<String> cartList = orderPane.getCartList();
        WorksTable modelTable = orderPane.getModelTable();

        String itemToRemove = cartList.getSelectedValue();

        Work work = this.bookshop.getWork(itemToRemove);

        this.bookshop.increaseStock(work.getTitle());
        cart.removeItemToCart(work);

        modelTable.update(bookshop);
        modelTable.fireTableDataChanged();
        cartListModel.remove(indexOfitemToRemove);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.orderPane.getOrderCartButton()) {
            System.out.println("Order ...");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {

            // Add to cart
            if (e.getSource() == orderPane.getTable()) {
                int row = orderPane.getTable().getSelectedRow();
                int column = orderPane.getTable().getSelectedColumn();
                this.addElementToCart(row, column);

                // Remove from cart
            } else if (e.getSource() == orderPane.getCartList()) {
                int index = orderPane.getCartList().locationToIndex(e.getPoint());
                this.removeItemFromCart(index);
            }
        }
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

}
