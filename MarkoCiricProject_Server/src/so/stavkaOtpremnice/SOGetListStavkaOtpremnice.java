/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavkaOtpremnice;

import database.DBBroker;
import util.AbstractDomainObject;
import util.StavkaOtpremnice;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOGetListStavkaOtpremnice extends AbstractSO{

    private ArrayList<StavkaOtpremnice> list;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof StavkaOtpremnice)) {
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaOtpremnice");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        ArrayList<AbstractDomainObject> listStavkaOtpremnice = DBBroker.getInstance().select(ado,o);
        list = (ArrayList<StavkaOtpremnice>) (ArrayList<?>) listStavkaOtpremnice;
    }
    
    public ArrayList<StavkaOtpremnice> getList(){
        return list;
    }
}
