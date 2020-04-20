package fr.uvsq.zumu_panchi.view;

import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.uvsq.zumu_panchi.model.Bookshop;

public class OrderPane extends JPanel {

	public OrderPane() {
		Bookshop bookshop;
		
		bookshop = new Bookshop();
		
		JLabel title;
		
		title = new JLabel("Order");

		JTable table = new JTable(new WorksTable());

		
		
		this.add(title);
		this.add(new JScrollPane(table));
	}
}
