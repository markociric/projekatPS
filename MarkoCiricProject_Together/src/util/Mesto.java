/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marko
 */
public class Mesto extends AbstractDomainObject{
    private int idMesto;
    private String location;
    private int zipcode;

    public Mesto() {
    }

    public Mesto(int idMesto, String location, int zipcode) {
        this.idMesto = idMesto;
        this.location = location;
        this.zipcode = zipcode;
    }

    public int getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(int idMesto) {
        this.idMesto = idMesto;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return location + " " + zipcode;
    }
    
    @Override
    public String tableName() {
        return "mesto";
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
                int id = rs.getInt("idMesto");
                String location = rs.getString("location");
                int zipcode = rs.getInt("zipcode");
                Mesto m = new Mesto(id, location, zipcode);
                lista.add(m);
            }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
       return "";
    }

    @Override
    public String requirement() {
        return "";
    }

    @Override
    public String valuesForInsert() {
       return "";
    }

    @Override
    public String valuesForUpdate() {
        return "";
    }

    @Override
    public String requirementForSelect(Object o) {
        return "";
    }
}
