/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import operations.Status;

/**
 *
 * @author Marko
 */
public class StavkaOtpremnice  extends  AbstractDomainObject{
    private int idOtpremnica;
    private int rb;
    private Roba roba;
    private double qty;
    private Status status;

    public StavkaOtpremnice() {
    }

    public StavkaOtpremnice(int idOtpremnica, int id, Roba idRoba, double qty) {
        this.idOtpremnica = idOtpremnica;
        this.rb = id;
        this.roba = idRoba;
        this.qty = qty;
    }
    
     public StavkaOtpremnice(int idOtpremnica, int id, Roba idRoba, double qty, Status status) {
        this.idOtpremnica = idOtpremnica;
        this.rb = id;
        this.roba = idRoba;
        this.qty = qty;
        this.status = status;
    }
    
    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public int getIdOtpremnica() {
        return idOtpremnica;
    }

    public void setIdOtpremnica(int idOtpremnica) {
        this.idOtpremnica = idOtpremnica;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public Roba getRoba() {
        return roba;
    }

    public void setRoba(Roba roba) {
        this.roba = roba;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    
    
    @Override
    public String toString() {
        return "StavkaOtpremnice{" + "idOtpremnica=" + idOtpremnica + ", id=" + rb + ", idRoba=" + roba + ", qty=" + qty + '}';
    }
    
     @Override
    public String tableName() {
        return "stavka_otpremnice";
    }

    @Override
    public String alijas() {
        return "so";
    }

    @Override
    public String join() {
        return "JOIN otpremnica o ON o.idOtpremnica = so.idOtpremnica JOIN vozac v ON o.idVozac = v.idVozac JOIN narucilac_usluge nu ON o.idNarucilacUsluge = nu.idNarucilacUsluge JOIN mesto m ON m.idMesto = nu.idMesto JOIN roba r ON r.idRoba = so.idRoba ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

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
                lista.add(so);

            }

        rs.close();
        return lista;
    }

    @Override
    public String columnsForInsert() {
        return "(idOtpremnica,idRoba,qtySO)";
    }

    @Override
    public String requirement() {
        return "rb = " + rb;
    }

    @Override
    public String valuesForInsert() {
        return idOtpremnica + "," + roba.getIdRoba() + "," + qty;
    }

    @Override
    public String valuesForUpdate() {
        return "qtySO=" + qty;
    }

    @Override
    public String requirementForSelect(Object o) {
        int otpremnica = (int) o;
        return "WHERE o.idOtpremnica =" + otpremnica;
    }
}
