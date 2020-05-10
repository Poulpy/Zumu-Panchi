package fr.uvsq.zumu_panchi.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;

import fr.uvsq.zumu_panchi.controller.BookshopController;
import fr.uvsq.zumu_panchi.model.Bookshop;
import fr.uvsq.zumu_panchi.model.Cart;

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
    
    private JLabel loyaltyPointsEarnedLabel;
    
    private JLabel notificationLabel;

    public OrderPane(BookshopController bookshopController) {
        super();
        
        this.bookshopController = bookshopController;
        this.cart = bookshopController.getCart();
        this.bookshop = bookshopController.getBookshop();
        this.bookshopController.setOrderPane(this);
        
        JLabel title;
        
        this.setLayout(new GridBagLayout());


        title = new JLabel("Order");
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        
        notificationLabel = new JLabel();
        notificationLabel.setFont(new Font("Calibri", Font.PLAIN, 12));

        // bookshop
        modelTable = new WorksTable(bookshop);
        table = new JTable(modelTable);
        table.setRowHeight(30);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        table.addMouseListener(bookshopController);

        // cart
        cartListModel = new DefaultListModel<String>();
        cartList = new JList<String>(cartListModel);
        cartList.setLayoutOrientation(JList.VERTICAL);
        
        cartList.addMouseListener(bookshopController);
        JScrollPane listScroller = new JScrollPane(cartList);

        // Order button

        orderCartButton = new JButton("Order");
        orderCartButton.addActionListener(bookshopController);
        totalLoyaltyPoints = new JLabel();
        totalLoyaltyPoints.setFont(new Font("Calibri", Font.PLAIN, 12));
        totalPrice = new JLabel();
        totalPrice.setFont(new Font("Calibri", Font.PLAIN, 12));
        loyaltyPointsEarnedLabel = new JLabel("Your points    0");
        loyaltyPointsEarnedLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
        this.setCartInformations(0, 0f);

        
        GridBagConstraints c = new GridBagConstraints();
        //c.insets = new Insets(6, 6, 6, 6);
        
        //c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        this.add(title, c);

        
        c.gridx = 2;
        this.add(loyaltyPointsEarnedLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 3.0;
        c.weightx = 4.0;
        c.gridheight = 3;
        this.add(new JScrollPane(this.table), c);
        
        c.weightx = 1.0;
        c.gridx = 1;
        this.add(listScroller, c);
        
        
        c.gridx = 2;
        c.weightx = 1.0;
        
        c.gridheight = 1;
        c.gridy = 1;
        //c.fill = GridBagConstraints.NONE;
        this.add(totalLoyaltyPoints, c);
        
        c.gridy = 2;
        this.add(totalPrice, c);
        
        c.gridy = 3;
        this.add(orderCartButton, c);
        
        
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        //c.fill = GridBagConstraints.PAGE_END;
        this.add(notificationLabel, c);
        
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
        /*
        String loyaltyTextLabel = "<html>Loyalty points <span align='right'>" + loyaltyPoints + "</span></html>";
        String priceTextLabel =   "Total price    " + String.format("% 3.2f", price) + " €";
        
        this.totalLoyaltyPoints.setText(loyaltyTextLabel);
        this.totalPrice.setText(priceTextLabel);
        */
        setCartInfosString(loyaltyPoints, price);
    }
    
    public void updatePointsEarned(int newPoints) {
        this.loyaltyPointsEarnedLabel.setText("Your points    " + newPoints);
    }
    
    public void updateBookshopView(Bookshop b) {
        modelTable.update(bookshop);
        modelTable.fireTableDataChanged();
    }
    
    public void addItemToCart(String title) {
        cartListModel.addElement(title);
    }
    
    public void removeItemFromCart(int index) {
        cartListModel.remove(index);
    }
    
    public void setCartInfosString(int loyaltyPoints, float price) {
        StringBuilder sb = new StringBuilder(128);
    
        sb.append("<html>");
        sb.append("<table border='0'>");
        sb.append("<tr>");
        sb.append("<td align='left'>Loyalty points</td>");
        sb.append(String.format("<td align='right'>%d</td>", loyaltyPoints));

        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td align='left'>Total price</td>");
        sb.append(String.format("<td align='right'>%3.2f €</td>", price));
        sb.append("</tr>");
        sb.append("</table>");
        sb.append("</html>");

        totalLoyaltyPoints.setText(sb.toString());
    }
    
    private int alpha = 255;
    private int increment = -5;
    public void notification(String msg) {
        notificationLabel.setText(msg);
        Timer t = new Timer(100, new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
              alpha += increment;
              
              if (alpha >= 255) {
                increment = -increment;
              }
              if (alpha <= 0) {
                  alpha = 255;
                  notificationLabel.setText("");
                ((Timer)e.getSource()).stop();
              }
              
              notificationLabel.setForeground(new Color(0, 0, 0, alpha));
            }
          });
        
        t.start();
    }
}
