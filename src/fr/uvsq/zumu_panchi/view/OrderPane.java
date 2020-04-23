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

import fr.uvsq.zumu_panchi.model.Bookshop;
import fr.uvsq.zumu_panchi.model.Cart;
import fr.uvsq.zumu_panchi.model.Work;

@SuppressWarnings("serial")
public class OrderPane extends JPanel implements ActionListener, MouseListener {

    private WorksTable modelTable;
    private JTable table;
    private Bookshop bookshop;
    private JList<String> cartList;
    private JButton orderCartButton;
    private DefaultListModel<String> cartListModel;
    private Cart cart;

    public OrderPane() {
        JLabel title;
        this.cart = new Cart();

        this.bookshop = new Bookshop();

        title = new JLabel("Order");

        this.modelTable = new WorksTable(this.bookshop);
        this.table = new JTable(this.modelTable);
        this.table.addMouseListener(this);

        cartListModel = new DefaultListModel<String>();
        cartList = new JList<String>(cartListModel);
        cartList.addMouseListener(this);
        JScrollPane listScroller = new JScrollPane(cartList);
        
        
        orderCartButton = new JButton("Order");

        this.add(title);
        this.add(new JScrollPane(this.table));
        this.add(listScroller);
        this.add(orderCartButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void addElementToCart(int row, int col) {
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
    
    
    private void removeItemFromCart(int indexOfitemToRemove) {
        String itemToRemove = this.cartList.getSelectedValue();
        
        Work work = this.bookshop.getWork(itemToRemove);


        this.bookshop.increaseStock(work.getTitle());
        cart.removeItemToCart(work);

        modelTable.update(bookshop);
        modelTable.fireTableDataChanged();
        cartListModel.remove(indexOfitemToRemove);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            
            // Add to cart
            if (e.getSource() == this.table) {
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                this.addElementToCart(row, column);
                
            // Remove from cart
            } else if (e.getSource() == this.cartList) {
                int index = cartList.locationToIndex(e.getPoint());
                
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
