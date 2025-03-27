/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.other;

import database.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;
import util.AbstractDomainObject;
import util.VzVV;

/**
 *
 * @author Marko
 */
public class SOGetVzVV extends AbstractSO {

     VzVV v = new VzVV();
     
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        VzVV vozac = (VzVV) o;
        
        String query = "SELECT * FROM vzvv WHERE idVozac=" + vozac.getIdVozac() + " AND idVrstaVozaca=" + vozac.getIdVrstaVozaca();
        System.out.println(query);
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {

                int idVrstaVozaca = vozac.getIdVrstaVozaca();
                Date expireDateLicence = rs.getDate("expireDateLicence");
                Date startDateLicence = rs.getDate("startDateLicence");
                int id = rs.getInt("id");
                VzVV vzVV = new VzVV(vozac.getIdVozac(), idVrstaVozaca, expireDateLicence, startDateLicence, id);
                v = vzVV;
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SOGetVzVV.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public VzVV getVzVV() {
        return v;
    }
}
