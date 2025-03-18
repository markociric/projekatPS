/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import controller.Controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Mesto;
import util.NarucilacUsluge;
import util.Otpremnica;
import util.Roba;
import util.StavkaOtpremnice;
import util.Vozac;
import util.VrstaVozaca;
import util.VzVV;
import util.AbstractDomainObject;

/**
 *
 * @author Marko
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection connection;

    private DBBroker() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("dbconfig.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("username");
        String pass = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, user, pass);
            connection.setAutoCommit(false);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBBroker getInstance() throws Exception {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public ArrayList<AbstractDomainObject> select(AbstractDomainObject ado, Object o) throws SQLException {
        String upit = "SELECT * FROM " + ado.tableName() + " " + ado.alijas()
                + " " + ado.join() + " " + ado.requirementForSelect(o);

        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.getList(rs);
    }

    public int insert(AbstractDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.tableName() + " "
                + ado.columnsForInsert() + " VALUES (" + ado.valuesForInsert() + ")";

        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);

        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0) {
            return -1;
        }
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            int newId = generatedKeys.getInt(1);
            return newId;
        }
        return -1;
    }

    public boolean update(AbstractDomainObject ado) throws SQLException {
        String upit = "UPDATE " + ado.tableName() + " SET "
                + ado.valuesForUpdate() + " WHERE " + ado.requirement();

        Statement s = connection.createStatement();
        int result = s.executeUpdate(upit);
        return result == 1;
    }

    public boolean delete(AbstractDomainObject ado) throws SQLException {
        String upit = "DELETE FROM " + ado.tableName() + " WHERE " + ado.requirement();

        Statement s = connection.createStatement();
        int result = s.executeUpdate(upit);
        return result == 1;
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

    public double sumPrices(int idOtpremnica) {
        double total = 0;
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
        return total;
    }

    public VzVV getVzVV(VzVV vozac) {
        VzVV v = new VzVV();
        String query = "SELECT * FROM vzvv WHERE idVozac=" + vozac.getIdVozac() + " AND idVrstaVozaca=" + vozac.getIdVrstaVozaca();
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {

                int idVrstaVozaca = vozac.getIdVrstaVozaca();
                Date expireDateLicence = rs.getDate("expireDateLicence");
                Date startDateLicence = rs.getDate("startDateLicence");
                int id = rs.getInt("id");
                VzVV vzVV = new VzVV(vozac.getIdVozac(), idVrstaVozaca, expireDateLicence, startDateLicence, id);
                return vzVV;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public List<Vozac> getListLogged() throws Exception {
        List<Vozac> list = new ArrayList<>();
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
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public void userLogout(Vozac v) throws Exception {
        String query = "DELETE FROM logged WHERE idVozac=?";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, v.getIdVozac());
            int result = ps.executeUpdate();
            if (result == 1) {
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashMap<Integer, Vozac> login(String email, String password) {
        HashMap<Integer, Vozac> map = new HashMap<>();
        List<Vozac> listVozac = new ArrayList<>();
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
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Vozac> listLogged = new ArrayList<>();
        try {
            listLogged = getListLogged();
        } catch (Exception ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Vozac vozac : listVozac) {
            if (vozac.getEmail().equals(email) && vozac.getPassword().equals(password)) {
                for (Vozac vozac1 : listLogged) {
                    if (vozac1.getEmail().equals(email)) {
                        map.put(0, null);
                        return map; //0 znaci da je vozac vec ulogovan na sistem
                    }
                }
                String query2 = "INSERT INTO logged(idVozac) VALUES(?)";
                try {
                    PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query2);
                    ps.setInt(1, vozac.getIdVozac());
                    ps.executeUpdate();
                    map.put(1, vozac);
                    return map; //1 znaci vozac ulogovan
                } catch (SQLException ex) {
                    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        map.put(-1, null);
        return map;//-1 znaci nema takvog vozaca u bazi
    }

    /*
------------------------insert stare fje---------------------
    public int insertStavkaOtpremnice(StavkaOtpremnice stavka) {
        String query = "INSERT INTO stavka_otpremnice(idOtpremnica,idRoba,qtySO) VALUES(?,?,?)";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, stavka.getIdOtpremnica());
            ps.setInt(2, stavka.getRoba().getIdRoba());
            ps.setDouble(3, stavka.getQty());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return -1;
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int newStavkaId = generatedKeys.getInt(1);
                return newStavkaId;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int insertOtpremnica(Otpremnica o) {
        String query = "INSERT INTO otpremnica(idVozac,idNarucilacUsluge,date) VALUES(?,?,?)";
        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            Date danas = o.getDatum();
            Calendar c = Calendar.getInstance();
            c.setTime(danas);
            int d = c.get(Calendar.DAY_OF_MONTH);
            int m = c.get(Calendar.MONTH) + 1;
            int y = c.get(Calendar.YEAR);
            String dan = y + "-" + m + "-" + d;
            ps.setInt(1, o.getVozac().getIdVozac());
            ps.setInt(2, o.getNarucilacUsluge().getIdNarucilacUsluge());
            ps.setString(3, dan);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return -1;
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int newId = generatedKeys.getInt(1);
                return newId;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int insertNarucilacUsluge(NarucilacUsluge nu) {
        String query = "INSERT INTO narucilac_usluge(name,lastName,phone,email,idMesto,adress) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nu.getName());
            ps.setString(2, nu.getLastName());
            ps.setString(3, nu.getPhone());
            ps.setString(4, nu.getEmail());
            ps.setInt(5, nu.getMesto().getIdMesto());
            ps.setString(6, nu.getAdress());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return -1;
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int newNUId = generatedKeys.getInt(1);
                return newNUId;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public boolean insertRoba(Roba roba) {
        String query = "INSERT INTO roba(nameRoba,qty,unitOfMeasure,price) VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);

            ps.setString(1, roba.getNameRoba());
            ps.setDouble(2, roba.getQty());
            ps.setString(3, roba.getUnitOfMeasure());
            ps.setDouble(4, roba.getPrice());
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean insertVrstaVozaca(VrstaVozaca vrsta) {
        String query = "INSERT INTO vrsta_vozaca(vehicle,driverLicence) VALUES(?,?)";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);

            ps.setString(1, vrsta.getVehicle());
            ps.setString(2, vrsta.getDriverLicence());
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
  public boolean insertVzVV(VzVV vozac) {
        String query = "INSERT INTO vzvv(idVozac,idVrstaVozaca,startDateLicence,expireDateLicence) VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, vozac.getIdVozac());
            ps.setInt(2, vozac.getIdVrstaVozaca());
            ps.setString(3, Controller.getInstance().convertDateForDB(vozac.getStartDateLicence()));
            ps.setString(4, Controller.getInstance().convertDateForDB(vozac.getExpireDateLicence()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
 public int insertNewVozac(Vozac vozac) {
        String query = "INSERT INTO vozac(nameVozac,lastNameVozac,mail,password,phoneNumber) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, vozac.getNameVozac());
            ps.setString(2, vozac.getLastNameVozac());
            ps.setString(3, vozac.getEmail());
            ps.setString(4, vozac.getPassword());
            ps.setString(5, vozac.getPhoneNumber());
            

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return -1;
            }
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int newVozacId = generatedKeys.getInt(1);
                return newVozacId;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }    
     */
 /* 
---------------------------------------delete stare fje--------------------------------------------------
    
    public boolean deleteVrstaVozaca(int delete) {
        String query = "DELETE FROM vrsta_vozaca WHERE idVrstaVozaca=?";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, delete);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteRoba(int delete) {
        String query = "DELETE FROM roba WHERE idRoba=?";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, delete);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteVzVV(int delete) {
        String query = "DELETE FROM vzvv WHERE id=?";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, delete);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteStavkaOtpremnice(int delete) {
        String query = "DELETE FROM stavka_otpremnice WHERE rb=?";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, delete);
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteOtpremnica(Otpremnica deleteOtpremnica) {
        String query = "DELETE FROM otpremnica WHERE idOtpremnica=? AND idVozac=? AND idNarucilacUsluge=?";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, deleteOtpremnica.getIdOtpremnica());
            ps.setInt(2, deleteOtpremnica.getVozac().getIdVozac());
            ps.setInt(3, deleteOtpremnica.getNarucilacUsluge().getIdNarucilacUsluge());
            int result = ps.executeUpdate();
            if (result == 1) {
                return true;
            }
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
     */
 /*
-----------------------------------------------getList stare fje-------------------------------------------------------------------
      
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
    
      public List<VrstaVozaca> getListVrstaVozaca() {
        List<VrstaVozaca> list = new ArrayList<>();
        String query = "SELECT * FROM vrsta_vozaca";
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idVrstaVozaca");
                String driverLicence = rs.getString("driverLicence"); List<Vozac> list = new ArrayList<>();
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
                String vehicle = rs.getString("vehicle");
                VrstaVozaca u = new VrstaVozaca(id, driverLicence, vehicle);
                list.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
     public List<Roba> getListRoba() {
        List<Roba> list = new ArrayList<>();
        String query = "SELECT * FROM roba";
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idRoba");
                String name = rs.getString("nameRoba");
                double qty = rs.getDouble("qty");
                double price = rs.getDouble("price");
                String unitOfMeasure = rs.getString("unitOfMeasure");
                Roba r = new Roba(id, name, qty, unitOfMeasure, price);
                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
      public List<NarucilacUsluge> getListNarucilacUsluge(HashMap<Integer, String> needSort) {
        int key = needSort.keySet().iterator().next();
        System.out.println(key + " " + needSort.get(key));
        List<NarucilacUsluge> list = new ArrayList<>();
        String query = "SELECT * FROM narucilac_usluge nu JOIN mesto m ON nu.idMesto = m.idMesto";
        switch (key) {
            case 0:
                query += "";
                break;
            case 1:
                query += " ORDER BY nu.name ASC";
                break;
            case 2:
                query += " ORDER BY nu.name DESC";
                break;
            case 3:
                query += " ORDER BY nu.lastName ASC";
                break;
            case 4:
                query += " ORDER BY nu.lastName DESC";
                break;
            case 5:
                query += " ORDER BY m.location ASC";
                break;
            case 6:
                query += " ORDER BY m.location DESC";
                break;
            case 7:
                query += " WHERE nu.email LIKE \"" + needSort.get(key) + "%\"";
        }
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
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
                list.add(n);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
     
     public List<Otpremnica> getListOtpremnica() {
        List<Otpremnica> list = new ArrayList<>();
        String query = "SELECT * FROM otpremnica o JOIN vozac v ON o.idVozac = v.idVozac JOIN narucilac_usluge nu ON o.idNarucilacUsluge = nu.idNarucilacUsluge JOIN mesto m ON m.idMesto = nu.idMesto";

        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                
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

    

    public List<VzVV> getListVzVV(int idVozac) {
        List<VzVV> list = new ArrayList<>();
        String query = "SELECT * FROM vzvv WHERE idVozac=" + idVozac;
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {

                int idVrstaVozaca = rs.getInt("idVrstaVozaca");
                Date expireDateLicence = rs.getDate("expireDateLicence");
                Date startDateLicence = rs.getDate("startDateLicence");
                int id = rs.getInt("id");
                VzVV vzVV = new VzVV(idVozac, idVrstaVozaca, expireDateLicence, startDateLicence, id);
                list.add(vzVV);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public List<Mesto> getListMesto() {
        List<Mesto> list = new ArrayList<>();
        String query = "SELECT * FROM mesto";
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idMesto");
                String location = rs.getString("location");
                int zipcode = rs.getInt("zipcode");
                Mesto m = new Mesto(id, location, zipcode);
                list.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   
    public List<StavkaOtpremnice> getListStavkeOtpremnice(int idOtpremnica) {
        List<StavkaOtpremnice> list = new ArrayList<>();
        String query = "SELECT * FROM stavka_otpremnice so JOIN otpremnica o ON o.idOtpremnica = so.idOtpremnica JOIN vozac v ON o.idVozac = v.idVozac JOIN narucilac_usluge nu ON o.idNarucilacUsluge = nu.idNarucilacUsluge JOIN mesto m ON m.idMesto = nu.idMesto JOIN roba r ON r.idRoba = so.idRoba WHERE o.idOtpremnica =" + idOtpremnica;
        try {
            Statement s = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {

                int idRoba = rs.getInt("r.idRoba");
                String nameRoba = rs.getString("r.nameRoba");
                double qty = rs.getDouble("r.qty");
                double price = rs.getDouble("r.price");
                String unitOfMeasure = rs.getString("r.unitOfMeasure");
                Roba r = new Roba(idRoba, nameRoba, qty, unitOfMeasure, price);

                int rb = rs.getInt("so.rb");
                double priceRoba = rs.getDouble("r.price");
                double qtySO = rs.getDouble("so.qtySO");

                StavkaOtpremnice so = new StavkaOtpremnice(idOtpremnica, rb, r, qtySO);
                list.add(so);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     */

 /*
---------------------------------update stare fje----------------------------------------------
     public boolean updateStavkaOtpremnice(StavkaOtpremnice so) {
        String query = "UPDATE stavka_otpremnice SET qtySO=? WHERE idOtpremnica=? AND idRoba=?";
        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setDouble(1, so.getQty());
            ps.setInt(2, so.getRb());
            ps.setInt(3, so.getRoba().getIdRoba());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    } 
    
    public boolean updateVzVV(VzVV update) {
        String query = "UPDATE vzvv SET startDateLicence=?, expireDateLicence=? WHERE id=?";
        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, update.getStartDateLicence().toString());
            ps.setString(2, update.getExpireDateLicence().toString());
            ps.setInt(3, update.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public boolean updateVozac(Vozac vozac) {
        String query = "UPDATE vozac SET nameVozac=?,lastNameVozac=?,phoneNumber=?,mail=?,vozac.password=? WHERE idVozac=?";

        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, vozac.getNameVozac());
            ps.setString(2, vozac.getLastNameVozac());
            ps.setString(3, vozac.getPhoneNumber());
            ps.setString(4, vozac.getEmail());
            ps.setString(5, vozac.getPassword());
            ps.setInt(6, vozac.getIdVozac());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public boolean updateRoba(Roba update) {
        String query = "UPDATE roba SET qty=? WHERE idRoba=?";
        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setDouble(1, update.getQty());
            ps.setInt(2, update.getIdRoba());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
 public boolean updateOtpremnica(Otpremnica o) {
        String query = "UPDATE otpremnica SET idVozac=?,idNarucilacUsluge=? WHERE idOtpremnica=?";
        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, o.getVozac().getIdVozac());
            ps.setInt(2, o.getNarucilacUsluge().getIdNarucilacUsluge());
            ps.setInt(3, o.getIdOtpremnica());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateNarucilacUsluge(NarucilacUsluge nu) {
        String query = "UPDATE narucilac_usluge SET name=?,lastName=?,phone=?,email=?,idMesto=?,adress=? WHERE idNarucilacUsluge=?";
        try {
            PreparedStatement ps = DBConnection.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, nu.getName());
            ps.setString(2, nu.getLastName());
            ps.setString(3, nu.getPhone());
            ps.setString(4, nu.getEmail());
            ps.setInt(5, nu.getMesto().getIdMesto());
            ps.setString(6, nu.getAdress());
            ps.setInt(7, nu.getIdNarucilacUsluge());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

     */

}
