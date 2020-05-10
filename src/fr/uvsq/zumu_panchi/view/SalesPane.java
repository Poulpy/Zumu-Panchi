package fr.uvsq.zumu_panchi.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.uvsq.zumu_panchi.controller.BookshopController;
import fr.uvsq.zumu_panchi.model.SalesJournal;

public class SalesPane extends JPanel {
    
    
    private SalesTable modelTable;
    private JTable table;
	
	public SalesPane(BookshopController controller) {
		JLabel title;
		
		title = new JLabel("Sales journal");
		
        this.setLayout(new GridBagLayout());

        title.setFont(new Font("Calibri", Font.BOLD, 30));

        controller.setSalesPane(this);
        this.modelTable = new SalesTable(controller.getSalesJournal());
        this.table = new JTable(this.modelTable);
        this.table.setRowHeight(30);

        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        this.add(title, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 3.0;
        this.add(new JScrollPane(this.table), c);
	}
	
    public void updateSalesView(SalesJournal sales) {
        modelTable.update(sales);
        modelTable.fireTableDataChanged();
    }
}
