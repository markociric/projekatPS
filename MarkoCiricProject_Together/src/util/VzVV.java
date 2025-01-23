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
public class VzVV extends AbstractDomainObject {

    private int idVozac;
    private int idVrstaVozaca;
    private Date expireDateLicence;
    private Date startDateLicence;
    private int id;

    public VzVV() {
    }

    public VzVV(int idVozac, int idVrstaVozaca, Date expireDateLicence, Date startDateLicence, int id) {
        this.idVozac = idVozac;
        this.idVrstaVozaca = idVrstaVozaca;
        this.expireDateLicence = expireDateLicence;
        this.startDateLicence = startDateLicence;
        this.id = id;
    }

    public Date getStartDateLicence() {
        return startDateLicence;
    }

    public void setStartDateLicence(Date startDateLicence) {
        this.startDateLicence = startDateLicence;
    }

    public int getIdVozac() {
        return idVozac;
    }

    public void setIdVozac(int idVozac) {
        this.idVozac = idVozac;
    }

    public int getIdVrstaVozaca() {
        return idVrstaVozaca;
    }

    public void setIdVrstaVozaca(int idVrstaVozaca) {
        this.idVrstaVozaca = idVrstaVozaca;
    }

    public Date getExpireDateLicence() {
        return expireDateLicence;
    }

    public void setExpireDateLicence(Date expireDateLicence) {
        this.expireDateLicence = expireDateLicence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VzVV{" + "idVozac=" + idVozac + ", idVrstaVozaca=" + idVrstaVozaca + ", expireDateLicence=" + expireDateLicence + ", startDateLicence=" + startDateLicence + ", id=" + id + '}';
    }

    @Override
    public String tableName() {
        return "vzvv";
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

            int idVrstaVozaca = rs.getInt("idVrstaVozaca");
            Date expireDateLicence = rs.getDate("expireDateLicence");
            Date startDateLicence = rs.getDate("startDateLicence");
            int id = rs.getInt("id");
            VzVV vzVV = new VzVV(idVozac, idVrstaVozaca, expireDateLicence, startDateLicence, id);
            lista.add(vzVV);
        }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return "(idVozac,idVrstaVozaca,startDateLicence,expireDateLicence)";
    }

    @Override
    public String requirement() {
        return "id = " + id;
    }

    @Override
    public String valuesForInsert() {
         Calendar c = Calendar.getInstance();
        c.setTime(startDateLicence);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH) + 1;
        int y = c.get(Calendar.YEAR);
        String start = y + "-" + m + "-" + d;

        c.setTime(expireDateLicence);
        d = c.get(Calendar.DAY_OF_MONTH);
        m = c.get(Calendar.MONTH) + 1;
        y = c.get(Calendar.YEAR);
        String end = y + "-" + m + "-" + d;
        return idVozac + "," + idVrstaVozaca + ",'" + start + "','" + end +"'";
    }

    @Override
    public String valuesForUpdate() {
        Calendar c = Calendar.getInstance();
        c.setTime(startDateLicence);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH) + 1;
        int y = c.get(Calendar.YEAR);
        String start = y + "-" + m + "-" + d;

        c.setTime(expireDateLicence);
        d = c.get(Calendar.DAY_OF_MONTH);
        m = c.get(Calendar.MONTH) + 1;
        y = c.get(Calendar.YEAR);
        String end = y + "-" + m + "-" + d;

        return "startDateLicence='" + start + "',expireDateLicence='" + end + "'";
    }

    @Override
    public String requirementForSelect(Object o) {
        int idvz = (int) o;
        return "WHERE idVozac= " + idvz;
    }

}
