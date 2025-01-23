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
public class SOAddVozac extends AbstractSO{
    int id;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Vozac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Vozac!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
      id =  DBBroker.getInstance().insert(ado);
    }
    
    public int getId(){
        return id;
    }
}
