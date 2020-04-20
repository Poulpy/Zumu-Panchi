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
		
		String[] columnNames = bookshop.getInformations();

		
		Object[][] data = bookshop.getArray();
		
		System.out.println(Arrays.deepToString(columnNames));
		JTable table = new JTable(data, columnNames);

		
		
		this.add(title);
		/*
		this.add(table.getTableHeader());
		this.add(table);
		*/
		this.add(new JScrollPane(table));
	}
}
