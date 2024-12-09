/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Marko
 */
public class Roba {
   
    private int idRoba;
    private String nameRoba;
    private double Qty;

    public Roba() {
    }

    public Roba(int idRoba, String nameRoba, double Qty) {
        this.idRoba = idRoba;
        this.nameRoba = nameRoba;
        this.Qty = Qty;
    }

    public int getIdRoba() {
        return idRoba;
    }

    public void setIdRoba(int idRoba) {
        this.idRoba = idRoba;
    }

    public String getNameRoba() {
        return nameRoba;
    }

    public void setNameRoba(String nameRoba) {
        this.nameRoba = nameRoba;
    }

    public double getQty() {
        return Qty;
    }

    public void setQty(double Qty) {
        this.Qty = Qty;
    }
    
    
}
