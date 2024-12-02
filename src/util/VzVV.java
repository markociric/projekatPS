/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Date;

/**
 *
 * @author Marko
 */
public class VzVV {
    private int idVozac;
    private int idVrstaVozaca;
    private Date expireDateLicence;

    public VzVV() {
    }

    public VzVV(int idVozac, int idVrstaVozaca, Date expireDateLicence) {
        this.idVozac = idVozac;
        this.idVrstaVozaca = idVrstaVozaca;
        this.expireDateLicence = expireDateLicence;
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
    
    
}
