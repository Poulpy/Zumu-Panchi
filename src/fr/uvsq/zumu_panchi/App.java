package fr.uvsq.zumu_panchi;

import java.awt.EventQueue;

import fr.uvsq.zumu_panchi.view.Master;

/**
 * The main class
 * 
 * @author paul
 *
 */
public class App {

    public static void main(String[] args) {
        
        /*
         * Recommended by Oracle : Swing methods are not thread safe
         * that's why we must create the GUI in the Event Dispatch Thread
         */
        EventQueue.invokeLater(() -> {
            Master m = new Master();
            m.initGUI();
        });

    }
}
