/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.otpremnica;

import database.DBBroker;
import util.AbstractDomainObject;
import util.Otpremnica;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOGetListOtpremnica extends AbstractSO{

    private ArrayList<Otpremnica> list;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Otpremnica)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Otpremnica");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        ArrayList<AbstractDomainObject> listOtpremnica = DBBroker.getInstance().select(ado,o);
        list = (ArrayList<Otpremnica>) (ArrayList<?>) listOtpremnica;
    }
    
    public ArrayList<Otpremnica> getList(){
        return list;
    }
}
