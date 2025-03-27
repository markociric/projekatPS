/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.other;

import database.DBBroker;
import database.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;
import util.AbstractDomainObject;

/**
 *
 * @author Marko
 */
public class SOSumPrices extends AbstractSO {

    double total = 0;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        int idOtpremnica = (int) o;

        String query = "SELECT so.qtySO, r.price FROM stavka_otpremnice so JOIN roba r ON r.idRoba = so.idRoba WHERE so.idOtpremnica =" + idOtpremnica;
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                double qty = rs.getDouble("so.qtySO");
                double priceRoba = rs.getDouble("r.price");
                total += qty * priceRoba;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public double getPrice() {
        return total;
    }
}
 

