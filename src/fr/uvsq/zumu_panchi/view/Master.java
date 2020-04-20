package fr.uvsq.zumu_panchi.view;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Master extends JFrame {
	final int HEIGHT = 500;
	final int WIDTH = 500;
	final static String TITLE = "Zumu Panchi";

	public Master() {
		super(TITLE);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane();

		JComponent panel1 = new OrderPane();
		tabbedPane.addTab("Order", panel1);

		JComponent panel2 = new SalesPane();
		tabbedPane.addTab("Sales", panel2);

		this.add(tabbedPane);

		setVisible(true);
	}
}
