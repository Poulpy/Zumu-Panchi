package fr.uvsq.zumu_panchi;

import java.awt.EventQueue;

import fr.uvsq.zumu_panchi.view.Master;

public class App {
    
	public static void main(String[] args) {
	    EventQueue.invokeLater(() -> {

            Master m = new Master();
            m.initGUI();
        });
	    
	}
}
