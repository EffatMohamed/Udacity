/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udacity.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class InvoiceLinesTableModel extends AbstractTableModel {

    private List<InvoiceLine> invoiceLines;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public InvoiceLinesTableModel(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }
    
    
    @Override
    public int getRowCount() {
        return invoiceLines.size();
    }

     @Override
    public String getColumnName(int cIndex) {
        switch (cIndex) {
            case 0:
                return "Item Name";
            case 1:
                return "Item Price";
            case 2:
                return "Count";
            case 3:
                return "Line Total";
            default:
                return "";
        }
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }

   

    @Override
    public Class<?> getColumnClass(int cIndex) {
        switch (cIndex) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
            case 2:
                return Integer.class;
            case 3:
                return Double.class;
            default:
                return Object.class;
        }
    }

 
    @Override
    public Object getValueAt(int rIndex, int cIndex) {
        InvoiceLine r = invoiceLines.get(rIndex);
        
        switch (cIndex) {
            case 0:
                return r.getItemName();
            case 1:
                return r.getItemPrice();
            case 2:
                return r.getItemCount();
            case 3:
                return r.getLineTotal();
            default:
                return "";
        }
        
    }
    
      @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
}
