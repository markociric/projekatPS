/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import controller.Controller;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marko
 */
public class TableModelDetailsVozac extends AbstractTableModel {

    List<VzVV> list = new ArrayList<>();

    public TableModelDetailsVozac(List<VzVV> list) {
        this.list = list;
    }
    String columns[] = {"Vrsta prevoznog sredstva", "Kategorija dozvole", "Dozvola važi do"};

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VzVV v = list.get(rowIndex);
        VrstaVozaca vv = Controller.getInstance().findVrstaVozaca(v.getIdVrstaVozaca());
       
        switch (columnIndex) {
            case 0:
                return vv.getVehicle();
            case 1:
                return vv.getDriverLicence();
            case 2:
                return Controller.getInstance().convertDate(v.getExpireDateLicence());
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
}
