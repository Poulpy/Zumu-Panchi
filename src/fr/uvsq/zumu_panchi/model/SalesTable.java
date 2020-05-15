package fr.uvsq.zumu_panchi.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
/**
 * Underlying model for the JTable containing
 * the sales objects
 * 
 * @author paul
 *
 */
public class SalesTable extends AbstractTableModel {

    /**
     * The datas of the table : sales
     */
    private List<String[]> datas;

    /**
     * The headers : Day | Hour | Total
     */
    private final String[] headers;
    
    public SalesTable(SalesJournal sales) {
        super();
        
        headers = new String[] {"Day", "Hour", "Articles shipped", "Total"};
        datas = sales.getList();
    }
    
    @Override
    public int getRowCount() {
        return datas.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datas.get(rowIndex)[columnIndex];
    }
    
    public String getColumnName(int columnIndex) {
        return this.headers[columnIndex];
    }
    
    public void update(SalesJournal sales) {
        this.datas = sales.getList();
    }
}
