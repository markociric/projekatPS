/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Mesto;
import util.NarucilacUsluge;
import util.Otpremnica;
import util.Vozac;
import util.VrstaVozaca;
import util.VzVV;

/**
 *
 * @author Marko
 */
public class DBBroker {

    

    public List<Vozac> getListVozac() {
        List<Vozac> list = new ArrayList<>();
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
                list.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean updateVozac(int id, String name, String lastname, String phone, String mail, String pass) {
        String query = "UPDATE vozac SET nameVozac=?,lastNameVozac=?,phoneNumber=?,mail=?,vozac.password=? WHERE idVozac=?";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, lastname);
            ps.setString(3, phone);
            ps.setString(4, mail);
            ps.setString(5, pass);
            ps.setInt(6, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean deleteVozac(int deleteVozac) {
        String query = "DELETE FROM vozac WHERE idVozac=?";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, deleteVozac);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void createVozac() {

        String query = "INSERT INTO vozac(nameVozac,lastNameVozac) VALUES('','')";

        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            s.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Otpremnica> getListOtpremnica() {
        List<Otpremnica> list = new ArrayList<>();
        String query = "SELECT * FROM otpremnica o JOIN vozac v ON o.idVozac = v.idVozac JOIN narucilac_usluge nu ON o.idNarucilacUsluge = nu.idNarucilacUsluge JOIN mesto m ON m.idMesto = nu.idMesto";
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                //ovde treba ucitati sve za otpremnicu
                int idOtpremnica = rs.getInt("o.idOtpremnica");
                Date datum = rs.getDate("o.date");

                int idVozac = rs.getInt("v.idVozac");
                String nameVozac = rs.getString("v.nameVozac");
                String lastNameVozac = rs.getString("v.lastNameVozac");
                String phoneNumber = rs.getString("v.phoneNumber");
                String mail = rs.getString("v.mail");
                String pass = rs.getString("v.password");
                Vozac v = new Vozac(idVozac, nameVozac, lastNameVozac, phoneNumber, mail, pass);

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

                Otpremnica o = new Otpremnica(idOtpremnica, datum, v, n);

                list.add(o);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<String> getVehicles(int idVozac) {
        List<String> list = new ArrayList<>();
        String query = "SELECT vv.vehicle, vv.driverLicence FROM vozac v JOIN vzvv vz ON v.idVozac = vz.idVozac JOIN vrsta_vozaca vv ON vz.idVrstaVozaca = vv.idVrstaVozaca WHERE v.idVozac = " + idVozac;

        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                String vehicle = rs.getString(1);
                list.add(vehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean deleteOtpremnica(Otpremnica deleteOtpremnica) {
        String query = "DELETE FROM otpremnica WHERE idOtpremnica=?";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, deleteOtpremnica.getIdOtpremnica());
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<VzVV> getVzVV(int idVozac) {
        List<VzVV> list = new ArrayList<>();
        String query = "SELECT * FROM vzvv WHERE idVozac=" + idVozac;
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {

                int idVrstaVozaca = rs.getInt("idVrstaVozaca");
                Date expireDateLicence = rs.getDate("expireDateLicence");
                VzVV vzVV = new VzVV(idVozac, idVrstaVozaca, expireDateLicence);
                list.add(vzVV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public VrstaVozaca findVrstaVozaca(int idVrstaVozaca) {
        VrstaVozaca result = new VrstaVozaca();
        String query = "SELECT vehicle, driverLicence FROM vrsta_vozaca WHERE idVrstaVozaca=" + idVrstaVozaca;
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) { 
            String driverLicence = rs.getString("driverLicence");
             String vehicle = rs.getString("vehicle");
             return new VrstaVozaca(idVrstaVozaca, driverLicence, vehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

    public int insertNewVozac(String mail, String randomPass) {
        String query = "INSERT INTO vozac(mail,password) VALUES(?,?)";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           
            ps.setString(1, mail);
            ps.setString(2, randomPass);
            
           int affectedRows = ps.executeUpdate();
           if(affectedRows==0)
               return -1;
           ResultSet generatedKeys = ps.getGeneratedKeys();
           if(generatedKeys.next()){
            int newVozacId = generatedKeys.getInt(1);
            return newVozacId;
           }
              
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

   
        return -1;
    }



}
