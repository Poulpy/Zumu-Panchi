package fr.uvsq.zumu_panchi.view;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
/**
 * One frame to rule them all, one frame to find them, One frame to bring them
 * all and in the darkness bind them.
 * 
 * @author paul
 *
 */
public class Master extends JFrame {

    /**
     * The height of the frame
     */
    final int HEIGHT = 500;

    /**
     * The width of the frame
     */
    final int WIDTH = 1200;

    /**
     * The title of the frame
     */
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
