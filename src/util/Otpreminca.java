/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


/**
 *
 * @author Marko
 */
public class Otpreminca {
    private Long idOtpremnica;
    private String datum;

    public Otpreminca() {
    }

    public Otpreminca(Long idOtpremnica, String datum) {
        this.idOtpremnica = idOtpremnica;
        this.datum = datum;
    }

    public Long getIdOtpremnica() {
        return idOtpremnica;
    }

    public void setIdOtpremnica(Long idOtpremnica) {
        this.idOtpremnica = idOtpremnica;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    
   
    
}
