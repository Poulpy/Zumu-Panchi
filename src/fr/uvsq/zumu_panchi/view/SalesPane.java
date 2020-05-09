package fr.uvsq.zumu_panchi.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.uvsq.zumu_panchi.controller.BookshopController;
import fr.uvsq.zumu_panchi.model.SalesJournal;

public class SalesPane extends JPanel {
    
    
    private SalesTable modelTable;
    private JTable table;
	
	public SalesPane(BookshopController controller, SalesJournal journal) {
		JLabel title;
		
		title = new JLabel("Sales journal");
		
        this.setLayout(new GridBagLayout());

        title.setFont(new Font("Calibri", Font.BOLD, 30));

        this.modelTable = new SalesTable(journal);
        this.table = new JTable(this.modelTable);
        this.table.setRowHeight(30);
        /*
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        */

        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        this.add(title, c);
        
	}
}
