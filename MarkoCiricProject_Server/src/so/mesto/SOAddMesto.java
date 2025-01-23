/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.mesto;

import database.DBBroker;
import util.AbstractDomainObject;
import util.Mesto;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOAddMesto extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Mesto)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Mesto!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
    
}
