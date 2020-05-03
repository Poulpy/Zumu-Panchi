package fr.uvsq.zumu_panchi.view;

import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import fr.uvsq.zumu_panchi.controller.BookshopController;
import fr.uvsq.zumu_panchi.model.Bookshop;
import fr.uvsq.zumu_panchi.model.Cart;
import fr.uvsq.zumu_panchi.model.SalesJournal;

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

        Cart cart = new Cart();

        Bookshop bookshop = new Bookshop();
        
        try {
            bookshop.seedBooks("resources/books.csv");
            bookshop.seedComicBooks("resources/comic_books.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        SalesJournal salesJournal = new SalesJournal();
        BookshopController bookshopController = new BookshopController(bookshop, cart, salesJournal);

        
        JComponent panel1 = new OrderPane(bookshopController);
        tabbedPane.addTab("Order", panel1);

        JComponent panel2 = new SalesPane(null, null);
        tabbedPane.addTab("Sales", panel2);

        this.add(tabbedPane);

        setVisible(true);
    }
}
