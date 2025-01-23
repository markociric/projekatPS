/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vozac;

import database.DBBroker;
import util.AbstractDomainObject;
import util.Vozac;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOGetListVozac extends AbstractSO{

    private ArrayList<Vozac> list;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Vozac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Vozac");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        ArrayList<AbstractDomainObject> listVozac = DBBroker.getInstance().select(ado,o);
        list = (ArrayList<Vozac>) (ArrayList<?>) listVozac;
    }
    
    public ArrayList<Vozac> getList(){
        return list;
    }
}
