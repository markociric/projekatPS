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
import util.Vozac;

/**
 *
 * @author Marko
 */
public class SOGetListLogged extends AbstractSO {
    
    List<Vozac> list = new ArrayList<>();
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        String query = "SELECT * FROM logged JOIN vozac ON logged.idVozac=vozac.idVozac";
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {

                int id = rs.getInt("idVozac");
                String phone = rs.getString("phoneNumber");
                String mail = rs.getString("mail");
                String pass = rs.getString("password");
                String name = rs.getString("nameVozac");
                String lastname = rs.getString("lastNameVozac");
                Vozac u = new Vozac(id, name, lastname, phone, mail, pass);
                list.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SOGetListLogged.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    public List<Vozac> getListLogged() {
        return list;
    }
}
