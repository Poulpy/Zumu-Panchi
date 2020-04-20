package fr.uvsq.zumu_panchi.view;


import javax.swing.table.AbstractTableModel;

import fr.uvsq.zumu_panchi.model.Bookshop;

@SuppressWarnings("serial")
public class WorksTable extends AbstractTableModel {

    private final Object[][] datas;

    private final String[] headers;

    public WorksTable() {
        super();

        Bookshop bookshop;
        bookshop = new Bookshop();

        headers = bookshop.getInformations();
        datas = bookshop.getArray();
    }

    @Override
    public int getRowCount() {
        return datas.length;
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return datas[rowIndex][columnIndex];
    }
    
    public String getColumnName(int columnIndex) {
        return this.headers[columnIndex];
    }

}
