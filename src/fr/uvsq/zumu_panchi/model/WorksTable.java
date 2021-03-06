package fr.uvsq.zumu_panchi.model;


import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
/**
 * Table model for works. Table model are objects
 * containing the datas of a JTable. The update of such tables then
 * is simplified.
 * 
 * @author paul
 *
 */
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
