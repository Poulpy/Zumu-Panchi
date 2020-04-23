package fr.uvsq.zumu_panchi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import fr.uvsq.zumu_panchi.model.Work;

@SuppressWarnings("serial")
public class OrderPane extends JPanel implements ActionListener, MouseListener {

    private WorksTable modelTable;
    public WorksTable getModelTable() {
        return modelTable;
    }

    private JTable table;
    private Bookshop bookshop;
    private JList<String> cartList;
    private JButton orderCartButton;
    private DefaultListModel<String> cartListModel;
    public DefaultListModel<String> getCartListModel() {
        return cartListModel;
    }

    private Cart cart;
    private BookshopController bookshopController;

    public OrderPane() {
        JLabel title;
        this.cart = new Cart();

        this.bookshop = new Bookshop();
        this.bookshopController = new BookshopController(this.bookshop, this.cart, this);

        title = new JLabel("Order");

        this.modelTable = new WorksTable(this.bookshop);
        this.table = new JTable(this.modelTable);
        this.table.addMouseListener(bookshopController);

        cartListModel = new DefaultListModel<String>();
        cartList = new JList<String>(cartListModel);
        cartList.addMouseListener(bookshopController);
        JScrollPane listScroller = new JScrollPane(cartList);
        
        
        orderCartButton = new JButton("Order");
        orderCartButton.addActionListener(bookshopController);

        this.add(title);
        this.add(new JScrollPane(this.table));
        this.add(listScroller);
        this.add(orderCartButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

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
    
    public JTable getTable() {
        return this.table;
    }
    
    public JList getCartList() {
        return this.cartList;
    }
}
