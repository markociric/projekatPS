/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.other;

import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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
public class SOLogin extends AbstractSO {

    HashMap<Integer, Vozac> result;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        HashMap<Integer, Vozac> map = new HashMap<>();
        List<Vozac> listVozac = new ArrayList<>();
        List<String> params = (List<String>) o;
        String email = params.get(0);
        String password = params.get(1);
        String query = "SELECT * FROM vozac";
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
                listVozac.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SOGetListLogged.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Vozac> listLogged = new ArrayList<>();
        try {
            listLogged = new SOGetListLogged().getListLogged();
        } catch (Exception ex) {
            Logger.getLogger(SOGetListLogged.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Vozac vozac : listVozac) {
            if (vozac.getEmail().equals(email) && vozac.getPassword().equals(password)) {
                for (Vozac vozac1 : listLogged) {
                    if (vozac1.getEmail().equals(email)) {
                        map.put(0, null);
                        result = map; //0 znaci da je vozac vec ulogovan na sistem
                        return;
                    }
                }
                String query2 = "INSERT INTO logged(idVozac) VALUES(?)";
                try {
                    PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query2);
                    ps.setInt(1, vozac.getIdVozac());
                    ps.executeUpdate();
                    map.put(1, vozac);
                    result = map; //1 znaci vozac ulogovan
                    return;
                } catch (SQLException ex) {
                    Logger.getLogger(SOLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        map.put(-1, null);
        result = map;//-1 znaci nema takvog vozaca u bazi
        return;
    }

    public HashMap<Integer, Vozac> getMap() {
        return result;
    }
}
