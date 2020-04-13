package fr.uvsq.zumu_panchi.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Master extends JFrame {
	final int HEIGHT = 500;
	final int WIDTH = 500;
	final static String TITLE = "Zumu Panchi";

	public Master() {
		super(TITLE);
		setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        setVisible(true);
	}
}
