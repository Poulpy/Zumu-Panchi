package fr.uvsq.zumu_panchi;

import fr.uvsq.zumu_panchi.view.Master;

public class App {
    
    private static String resourcePath = "resources";

	public static void main(String[] args) {
	    /*java.net.URL url = ClassLoader.getSystemResource("resources/cochon.png");
	    if (url != null) {
	    } else {
	        System.err.println("Couldn't find file:resources/cochon.png " );
	    }	
	    java.net.URL imageURL = App.class.getResource("/resources/cochon.png");
	    if (imageURL == null) {
	        System.err.println("Couldn't find file AGAIN :resources/cochon.png " );
	    }*/

	    java.net.URL url2 = App.class.getClassLoader().getResource("cochon.png");
	       if (url2 == null) {
	            System.err.println("Couldn't find file AGAIN :resources/cochon.png " );
	        }
	    
		new Master();
	}
}
