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
import fr.uvsq.zumu_panchi.model.WorksTable;

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

    /**
     * Table showing all books of the bookshop
     */
    private JTable table;

    /**
     * Object for modifying the content of the JList (the list of books in the cart)
     */
    private DefaultListModel<String> cartListModel;

    /**
     * Shows the books added to the cart
     */
    private JList<String> cartList;

    /**
     * The button for passing an order
     */
    private JButton orderCartButton;

    /**
     * Contains all books of the bookshop
     */
    private Bookshop bookshop;

    /**
     * Manage the update of the view
     */
    private BookshopController bookshopController;

    /**
     * Label showing info about the cart : loyalty points and total price
     */
    private JLabel cartInfo;

    /**
     * Label showing all loyalty points of the user
     */
    private JLabel loyaltyPointsEarnedLabel;

    /**
     * Label for notification
     */
    private JLabel notificationLabel;

    /**
     * For fade out effect (notification)
     */
    private int alpha = 255;

    /**
     * For fade out effect (notification)
     */
    private int increment = -10;
    private final String EMPTY_TEXT = "     ";

    public OrderPane(BookshopController bookshopController) {
        super();

        JLabel title;

        this.bookshopController = bookshopController;
        this.bookshop = bookshopController.getBookshop();
        this.bookshopController.setOrderPane(this);

        this.setLayout(new GridBagLayout());

        // TITLE
        title = new JLabel("Order");
        title.setFont(new Font("Calibri", Font.BOLD, 30));

        // NOTIFICATION
        notificationLabel = new JLabel(EMPTY_TEXT);
        notificationLabel.setFont(new Font("Calibri", Font.PLAIN, 12));

        // BOOKS OF THE BOOKSHOP
        modelTable = new WorksTable(bookshop);
        table = new JTable(modelTable);
        table.setRowHeight(30);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        table.addMouseListener(bookshopController);

        // BOOKS OF THE CART
        cartListModel = new DefaultListModel<String>();
        cartList = new JList<String>(cartListModel);
        cartList.setLayoutOrientation(JList.VERTICAL);

        cartList.addMouseListener(bookshopController);
        JScrollPane listScroller = new JScrollPane(cartList);

        // ORDER BUTTON
        orderCartButton = new JButton("Order");
        orderCartButton.addActionListener(bookshopController);

        // CART INFORMATION
        cartInfo = new JLabel();
        cartInfo.setFont(new Font("Calibri", Font.PLAIN, 12));

        // TOTAL OF LOYALTY POINTS
        loyaltyPointsEarnedLabel = new JLabel("Your points    0");
        loyaltyPointsEarnedLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
        this.setCartInformations(0, 0f);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);

        // PLACING THE ELEMENTS IN THE GRID

        // c.anchor = GridBagConstraints.WEST;
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

        this.add(cartInfo, c);

        c.gridy = 3;
        this.add(orderCartButton, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 3;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(6, 6, 6, 6);
        this.add(notificationLabel, c);

    }

    public JTable getTable() {
        return this.table;
    }

    public JList<String> getCartList() {
        return this.cartList;
    }

    public JButton getOrderCartButton() {
        return this.orderCartButton;
    }

    // Removing all items of a cart
    public void clearCartList() {
        this.cartListModel.clear();
    }

    /**
     * Update the info about the cart : loyalty points and total price
     * 
     * @param loyaltyPoints
     * @param price
     */
    public void setCartInformations(int loyaltyPoints, float price) {
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

        cartInfo.setText(sb.toString());
    }

    /**
     * Shows the total loyalty points earned
     * 
     * @param newPoints
     */
    public void updatePointsEarned(int newPoints) {
        this.loyaltyPointsEarnedLabel.setText("Your points    " + newPoints);
    }

    /**
     * Update the table showing the books of the bookshop
     * 
     * @param b
     */
    public void updateBookshopView(Bookshop b) {
        modelTable.update(bookshop);
        modelTable.fireTableDataChanged();
    }

    /**
     * Adds a item to the cart in the view
     * 
     * @param title
     */
    public void addItemToCart(String title) {
        cartListModel.addElement(title);
    }

    /**
     * Removes an item from the cart in the view
     * 
     * @param index
     */
    public void removeItemFromCart(int index) {
        cartListModel.remove(index);
    }

    /**
     * Displays a notification with a fade out effect
     * 
     * @param msg
     */
    public void notification(String msg) {
        notificationLabel.setText(msg);
        alpha = 255;

        Timer t = new Timer(100, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                alpha += increment;

                if (alpha <= 0) {
                    notificationLabel.setText(EMPTY_TEXT);
                    alpha = 0;
                    ((Timer) e.getSource()).stop();
                }

                notificationLabel.setForeground(new Color(0, 0, 0, alpha));
            }
        });

        t.start();
    }
}
