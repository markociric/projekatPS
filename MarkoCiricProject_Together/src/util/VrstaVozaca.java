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
public class VrstaVozaca extends AbstractDomainObject {

    private int idVrstaVozaca;
    private String driverLicence;
    private String vehicle;

    public VrstaVozaca() {
    }

    public VrstaVozaca(int idVrstaVozaca, String driverLicence, String vehicle) {
        this.idVrstaVozaca = idVrstaVozaca;
        this.driverLicence = driverLicence;
        this.vehicle = vehicle;
    }

    public int getIdVrstaVozaca() {
        return idVrstaVozaca;
    }

    public void setIdVrstaVozaca(int idVrstaVozaca) {
        this.idVrstaVozaca = idVrstaVozaca;
    }

    public String getDriverLicence() {
        return driverLicence;
    }

    public void setDriverLicence(String driverLicence) {
        this.driverLicence = driverLicence;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return vehicle;
    }

    @Override
    public String tableName() {
        return "vrsta_vozaca";
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
            int id = rs.getInt("idVrstaVozaca");
            String driverLicence = rs.getString("driverLicence");
            String vehicle = rs.getString("vehicle");
            VrstaVozaca u = new VrstaVozaca(id, driverLicence, vehicle);
            lista.add(u);
        }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return "(vehicle,driverLicence)";
    }

    @Override
    public String requirement() {
        return "idVrstaVozaca =" + idVrstaVozaca;
    }

    @Override
    public String valuesForInsert() {
        return "'" + vehicle + "','" + driverLicence + "'";
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
