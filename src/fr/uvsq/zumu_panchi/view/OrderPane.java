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

public class OrderPane extends JPanel implements ActionListener {

    private JButton orderButton;
    private JTable table;
    
	public OrderPane() {
		Bookshop bookshop;
		JLabel title;
		
		bookshop = new Bookshop();
		
		
		title = new JLabel("Order");

		JTable table = new JTable(new WorksTable());
		orderButton = new JButton("Order");

		
		
		this.add(title);
		this.add(new JScrollPane(table));
		this.add(orderButton);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.orderButton) {
            int[] selectedRows = table.getSelectedRows();
            for (int i = 0; i != selectedRows.length; i++) {
                System.out.println("Name : " + table.getValueAt(i, 0));
            }
        }
    }
}
