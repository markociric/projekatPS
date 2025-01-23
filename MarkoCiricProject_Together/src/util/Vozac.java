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
public class Vozac extends AbstractDomainObject implements Serializable{
    private int idVozac;
    private String nameVozac;
    private String lastNameVozac;
    private String phoneNumber;
    private String email;
    private String password;
    

    public Vozac() {
    }

    public Vozac(int idVozac, String nameVozac, String lastNameVozac, String phoneNumber, String email, String password) {
        this.idVozac = idVozac;
        this.nameVozac = nameVozac;
        this.lastNameVozac = lastNameVozac;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
       
    }

    public int getIdVozac() {
        return idVozac;
    }

    public void setIdVozac(int idVozac) {
        this.idVozac = idVozac;
    }

    public String getNameVozac() {
        return nameVozac;
    }

    public void setNameVozac(String nameVozac) {
        this.nameVozac = nameVozac;
    }

    public String getLastNameVozac() {
        return lastNameVozac;
    }

    public void setLastNameVozac(String lastNameVozac) {
        this.lastNameVozac = lastNameVozac;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  nameVozac + " " + lastNameVozac;
    }

    @Override
    public String tableName() {
        return "vozac";
    }

    @Override
    public String alijas() {
        return "v";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
                int id = rs.getInt("idVozac");
                String phone = rs.getString("phoneNumber");
                String mail = rs.getString("mail");
                String pass = rs.getString("password");
                String name = rs.getString("nameVozac");
                String lastname = rs.getString("lastNameVozac");
                Vozac u = new Vozac(id, name, lastname, phone, mail, pass);
                lista.add(u);
        }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return "(nameVozac,lastNameVozac,mail,password,phoneNumber)";
    }

    @Override
    public String requirement() {
        return "idVozac = " + idVozac;
    }

    @Override
    public String valuesForInsert() {
        return nameVozac + "'','" + lastNameVozac + "','" + email + "','" + password  + "','" + phoneNumber + "'";
    }

    @Override
    public String valuesForUpdate() {
        return "nameVozac='" + nameVozac +"',lastNameVozac='" + lastNameVozac + "',phoneNumber='" + phoneNumber + "',mail='" + email + "',password='" + password + "'";
    }

    @Override
    public String requirementForSelect(Object o) {
        return "";
    }
    
    
}
