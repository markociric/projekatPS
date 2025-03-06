/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Marko
 */
public class Roba extends AbstractDomainObject {

    private int idRoba;
    private String nameRoba;
    private double qty;
    private String unitOfMeasure;
    private double price;

    public Roba() {
    }

    public Roba(int idRoba, String nameRoba, double Qty, String unitOfMeasure, double price) {
        this.idRoba = idRoba;
        this.nameRoba = nameRoba;
        this.qty = Qty;
        this.unitOfMeasure = unitOfMeasure;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public int getIdRoba() {
        return idRoba;
    }

    public void setIdRoba(int idRoba) {
        this.idRoba = idRoba;
    }

    public String getNameRoba() {
        return nameRoba;
    }

    public void setNameRoba(String nameRoba) {
        this.nameRoba = nameRoba;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return nameRoba;
    }

    @Override
    public String tableName() {
        return "roba";
    }

    @Override
    public String alijas() {
        return "";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("idRoba");
            String name = rs.getString("nameRoba");
            double qty = rs.getDouble("qty");
            double price = rs.getDouble("price");
            String unitOfMeasure = rs.getString("unitOfMeasure");
            Roba r = new Roba(id, name, qty, unitOfMeasure, price);
            lista.add(r);
        }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return "(nameRoba,qty,unitOfMeasure,price)";
    }

    @Override
    public String requirement() {
        return "idRoba =" + idRoba;
    }

    @Override
    public String valuesForInsert() {
        return "'" + nameRoba + "'," + qty + "," + "'" + unitOfMeasure + "'," + price;
    }

    @Override
    public String valuesForUpdate() {
        return "qty=" + qty;
    }

    @Override
    public String requirementForSelect(Object o) {
        HashMap<Integer, String> needSort = (HashMap<Integer, String>) o;
        int key = needSort.keySet().iterator().next();
        switch (key) {
            case 0:
                return "";
            case 1:
                return "ORDER BY nameRoba ASC";
            case 2:
                return "ORDER BY nameRoba DESC";
            case 3:
                return "WHERE nameRoba LIKE \"" + needSort.get(key) + "%\"";
        }
        return "";
    }
}
