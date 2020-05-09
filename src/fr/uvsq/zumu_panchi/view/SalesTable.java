package fr.uvsq.zumu_panchi.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.uvsq.zumu_panchi.model.SalesJournal;

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

}
