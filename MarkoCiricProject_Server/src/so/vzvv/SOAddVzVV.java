/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vzvv;

import util.AbstractDomainObject;
import util.VzVV;
import database.DBBroker;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOAddVzVV extends AbstractSO {
    int id;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof VzVV)) {
            throw new Exception("Prosledjeni objekat nije instanca klase VzVV");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
      id =  DBBroker.getInstance().insert(ado);
    }

    public int getId() {
        return id;
    }

    
}
