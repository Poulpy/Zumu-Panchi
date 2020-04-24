package fr.uvsq.zumu_panchi.view;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.uvsq.zumu_panchi.model.Bookshop;

@SuppressWarnings("serial")
public class WorksTable extends AbstractTableModel {

    /**
     * The datas of the table : books
     */
    private List<String[]> datas;

    /**
     * The headers : Title | Publisher | ...
     */
    private final String[] headers;

    public WorksTable(Bookshop bookshop) {
        super();

        headers = bookshop.getInformations();
        datas = bookshop.getList();
        
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
    
    public void update(Bookshop newBookshop) {
        this.datas = newBookshop.getList();
    }

    public void removeRow(int row) {
        this.datas.remove(row);
    }
}
