package fr.uvsq.zumu_panchi.view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.uvsq.zumu_panchi.controller.BookshopController;
import fr.uvsq.zumu_panchi.model.Bookshop;
import fr.uvsq.zumu_panchi.model.Cart;

@SuppressWarnings("serial")
public class OrderPane extends JPanel {

    private WorksTable modelTable;

    private JTable table;
    private Bookshop bookshop;
    private JList<String> cartList;
    private JButton orderCartButton;
    private DefaultListModel<String> cartListModel;

    private Cart cart;
    private BookshopController bookshopController;

    public OrderPane() {
        JLabel title;
        this.cart = new Cart();

        this.bookshop = new Bookshop();
        this.bookshopController = new BookshopController(this.bookshop, this.cart, this);

        title = new JLabel("Order");

        // bookshop
        this.modelTable = new WorksTable(this.bookshop);
        this.table = new JTable(this.modelTable);
        this.table.addMouseListener(bookshopController);

        // cart
        cartListModel = new DefaultListModel<String>();
        cartList = new JList<String>(cartListModel);
        cartList.addMouseListener(bookshopController);
        JScrollPane listScroller = new JScrollPane(cartList);

        // Order button
        orderCartButton = new JButton("Order");
        orderCartButton.addActionListener(bookshopController);

        this.add(title);
        this.add(new JScrollPane(this.table));
        this.add(listScroller);
        this.add(orderCartButton);
    }

    public JTable getTable() {
        return this.table;
    }

    public JList getCartList() {
        return this.cartList;
    }

    public DefaultListModel<String> getCartListModel() {
        return cartListModel;
    }

    public WorksTable getModelTable() {
        return modelTable;
    }

    public JButton getOrderCartButton() {
        return this.orderCartButton;
    }
}
