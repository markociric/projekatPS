/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Marko
 */
public class Otpremnica extends AbstractDomainObject{
    private int idOtpremnica;
    private Date datum;
    private Vozac vozac;
    private NarucilacUsluge narucilacUsluge;
    
    public Otpremnica() {
        
    }

    public Otpremnica(int idOtpremnica, Date datum, Vozac vozac, NarucilacUsluge narucilacUsluge) {
        this.idOtpremnica = idOtpremnica;
        this.datum = datum;
        this.vozac = vozac;
        this.narucilacUsluge = narucilacUsluge;
        
    }


    public int getIdOtpremnica() {
        return idOtpremnica;
    }

    public void setIdOtpremnica(int idOtpremnica) {
        this.idOtpremnica = idOtpremnica;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public NarucilacUsluge getNarucilacUsluge() {
        return narucilacUsluge;
    }

    public void setNarucilacUsluge(NarucilacUsluge narucilacUsluge) {
        this.narucilacUsluge = narucilacUsluge;
    }
    
     @Override
    public String tableName() {
        return "otpremnica";
    }

    @Override
    public String alijas() {
        return "o";
    }

    @Override
    public String join() {
        return "JOIN vozac v ON o.idVozac = v.idVozac JOIN narucilac_usluge nu ON o.idNarucilacUsluge = nu.idNarucilacUsluge JOIN mesto m ON m.idMesto = nu.idMesto";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

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

                lista.add(o);

            }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return "(idVozac,idNarucilacUsluge,date)";
    }

    @Override
    public String requirement() {
        return "idOtpremnica =" + idOtpremnica;
    }

    @Override
    public String valuesForInsert() {
        Calendar c = Calendar.getInstance();
        c.setTime(datum);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH) + 1;
        int y = c.get(Calendar.YEAR);
        String dan = y + "-" + m + "-" + d;
        return vozac.getIdVozac() + "," + narucilacUsluge.getIdNarucilacUsluge() + ",'" + dan + "'";
    }

    @Override
    public String valuesForUpdate() {
        return "idVozac=" + vozac.getIdVozac() +",idNarucilacUsluge=" + narucilacUsluge.getIdNarucilacUsluge();
    }

    @Override
    public String requirementForSelect(Object o) {
        return "";
    }
}
