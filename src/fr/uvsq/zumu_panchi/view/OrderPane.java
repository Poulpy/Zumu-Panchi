package fr.uvsq.zumu_panchi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.uvsq.zumu_panchi.model.Bookshop;
import fr.uvsq.zumu_panchi.model.Cart;

public class OrderPane extends JPanel implements ActionListener {

    private JButton addToCartButton;
    private JTable table;
    private Bookshop bookshop;
    
	public OrderPane() {
		JLabel title;
		
		this.bookshop = new Bookshop();
		
		
		title = new JLabel("Order");

		this.table = new JTable(new WorksTable(this.bookshop));
		addToCartButton = new JButton("Add to the cart");
		addToCartButton.addActionListener(this);

		
		
		this.add(title);
		this.add(new JScrollPane(this.table));
		this.add(addToCartButton);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        Cart newCart;
        newCart = new Cart();
        
        
        if (e.getSource() == this.addToCartButton) {
            int[] selectedRows = this.table.getSelectedRows();
            
            for (int i = 0; i != selectedRows.length; i++) {
                System.out.println("Name : " + table.getValueAt(selectedRows[i], 0));
                newCart.addItemToCart(this.bookshop.getWork((String) table.getValueAt(selectedRows[i], 0)));
            }
        }
    }
}
