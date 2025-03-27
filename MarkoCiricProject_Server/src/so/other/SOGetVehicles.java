/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.other;

import database.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;
import util.AbstractDomainObject;

/**
 *
 * @author Marko
 */
public class SOGetVehicles extends AbstractSO {

    List<String> list = new ArrayList<>();

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        int idVozac = (int) o;
        String query = "SELECT vv.vehicle, vv.driverLicence FROM vozac v JOIN vzvv vz ON v.idVozac = vz.idVozac JOIN vrsta_vozaca vv ON vz.idVrstaVozaca = vv.idVrstaVozaca WHERE v.idVozac = " + idVozac;

        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                String vehicle = rs.getString(1);
                list.add(vehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SOGetVehicles.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<String> getVehicles() {
        return list;
    }
}
