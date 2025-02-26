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
public class NarucilacUsluge extends AbstractDomainObject {

    private int idNarucilacUsluge;
    private String name;
    private String lastName;
    private String adress;
    private String phone;
    private String email;
    private Mesto mesto;

    public NarucilacUsluge() {
    }

    public NarucilacUsluge(int idNarucilacUsluge, String name, String lastName, String adress, String phone, String email, Mesto mesto) {
        this.idNarucilacUsluge = idNarucilacUsluge;
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.mesto = mesto;
    }

    public int getIdNarucilacUsluge() {
        return idNarucilacUsluge;
    }

    public void setIdNarucilacUsluge(int idNarucilacUsluge) {
        this.idNarucilacUsluge = idNarucilacUsluge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String tableName() {
        return "narucilac_usluge";
    }

    @Override
    public String alijas() {
        return "nu";
    }

    @Override
    public String join() {
        return "JOIN mesto m ON nu.idMesto = m.idMesto";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
                int idNarucilacUsluge = rs.getInt("nu.idNarucilacUsluge");
                String name = rs.getString("nu.name");
                String lastName = rs.getString("nu.lastName");
                String phone = rs.getString("nu.phone");
                String email = rs.getString("nu.email");
                String adress = rs.getString("nu.adress");

                int idMesto = rs.getInt("m.idMesto");
                int zipcode = rs.getInt("m.zipcode");
                String location = rs.getString("m.location");
                Mesto mesto = new Mesto(idMesto, location, zipcode);

                NarucilacUsluge n = new NarucilacUsluge(idNarucilacUsluge, name, lastName, adress, phone, email, mesto);
                lista.add(n);

            }

        rs.close();
        return lista;
    }

    @Override
    public String toString() {
        return "NarucilacUsluge{" + "idNarucilacUsluge=" + idNarucilacUsluge + ", name=" + name + ", lastName=" + lastName + ", adress=" + adress + ", phone=" + phone + ", email=" + email + ", mesto=" + mesto + '}';
    }

    @Override
    public String columnsForInsert() {
        return "(name,lastName,phone,email,idMesto,adress)";
    }

    @Override
    public String requirement() {
        return "idNarucilacUsluge=" + idNarucilacUsluge;
    }

    @Override
    public String valuesForInsert() {
        return "'"+ name + "','" + lastName + "','" + phone + "','" + email + "'," + mesto.getIdMesto() + ",'" + adress + "'";
    }

    @Override
    public String valuesForUpdate() {
        return "name='" + name + "',lastName='" + lastName + "',phone='" + phone + "',email='" + email + "',idMesto=" + mesto.getIdMesto() + ",adress='" + adress + "'";
    }

    @Override
    public String requirementForSelect(Object o) {
        HashMap<Integer, String> needSort = (HashMap<Integer, String>) o;
        int key = needSort.keySet().iterator().next();
        switch (key) {
            case 0:
                return "";
            case 1:
                return "ORDER BY nu.name ASC";
            case 2:
                return "ORDER BY nu.name DESC";
            case 3:
                return "ORDER BY nu.lastName ASC";
            case 4:
                return "ORDER BY nu.lastName DESC";
            case 5:
                return "ORDER BY m.location ASC";
            case 6:
                return "ORDER BY m.location DESC";
            case 7:
                return "WHERE nu.email LIKE \"" + needSort.get(key) + "%\"";

        }
        return "";
    }
}
