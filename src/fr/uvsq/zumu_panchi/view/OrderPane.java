package fr.uvsq.zumu_panchi.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.BoxLayout;
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
import fr.uvsq.zumu_panchi.model.SalesJournal;

@SuppressWarnings("serial")
/**
 * The pane for the customer to make a cart, and pass an order
 * 
 * @author paul
 *
 */
public class OrderPane extends JPanel {

    /**
     * The underlying model contaning the data of the JTable Contains the books
     * available in the bookshop
     */
    private WorksTable modelTable;
    private JTable table;

    private DefaultListModel<String> cartListModel;
    /**
     * Contains the books added to the cart
     */
    private JList<String> cartList;

    /**
     * The button for passing an order
     */
    private JButton orderCartButton;

    private Bookshop bookshop;
    private Cart cart;

    private BookshopController bookshopController;
    
    private JLabel totalLoyaltyPoints;
    
    private JLabel totalPrice;

    public OrderPane() {
        super();
        this.setLayout(new GridBagLayout());

        
        JLabel title;
        this.cart = new Cart();

        this.bookshop = new Bookshop();
        
        try {
            this.bookshop.seedBooks("resources/books.csv");
            this.bookshop.seedComicBooks("resources/comic_books.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        SalesJournal salesJournal = new SalesJournal();
        this.bookshopController = new BookshopController(this.bookshop, this.cart, salesJournal, this);

        title = new JLabel("Order");
        title.setFont(new Font("Calibri", Font.BOLD, 30));

        // bookshop
        this.modelTable = new WorksTable(this.bookshop);
        this.table = new JTable(this.modelTable);
        this.table.setRowHeight(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        this.table.addMouseListener(bookshopController);

        // cart
        cartListModel = new DefaultListModel<String>();
        cartList = new JList<String>(cartListModel);
        cartList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        
        cartList.addMouseListener(bookshopController);
        JScrollPane listScroller = new JScrollPane(cartList);

        // Order button

        orderCartButton = new JButton("Order");
        orderCartButton.addActionListener(bookshopController);
        totalLoyaltyPoints = new JLabel();
        totalPrice = new JLabel();
        this.setCartInformations(0, 0f);

        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        this.add(title, c);
        
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 3.0;
        c.weightx = 7.0;
        c.gridheight = 3;
        this.add(new JScrollPane(this.table), c);
        
        c.weightx = 2.0;
        c.gridx = 1;
        this.add(listScroller, c);
        
        c.gridx = 2;
        c.gridy = 1;
        
        c.gridheight = 1;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.NONE;
                
        this.add(totalLoyaltyPoints, c);
        
        c.gridy = 2;
        this.add(totalPrice, c);
        
        c.gridy = 3;
        this.add(orderCartButton, c);
        
    }

    public JTable getTable() {
        return this.table;
    }

    public JList<String> getCartList() {
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
    
    public void clearCartList() {
        this.cartListModel.clear();
    }
    
    public void setCartInformations(int loyaltyPoints, float price) {
        String loyaltyTextLabel = "Loyalty points : " + loyaltyPoints;
        String priceTextLabel = "Total price : " + String.format("%.2f", price) + " €";
        
        this.totalLoyaltyPoints.setText(loyaltyTextLabel);
        this.totalPrice.setText(priceTextLabel);
    }
}
