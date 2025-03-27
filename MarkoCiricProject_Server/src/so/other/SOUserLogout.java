/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.other;


import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;
import util.AbstractDomainObject;
import util.Vozac;

/**
 *
 * @author Marko
 */
public class SOUserLogout extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        String query = "DELETE FROM logged WHERE idVozac=?";
        Vozac v = (Vozac) o;
        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, v.getIdVozac());
            int result = ps.executeUpdate();
            if (result == 1) {
            }
        } catch (SQLException ex) {
            Logger.getLogger(SOUserLogout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
