/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.roba;

import database.DBBroker;
import util.AbstractDomainObject;
import util.Roba;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOGetListRoba extends AbstractSO{
    private ArrayList<Roba> list;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Roba)){
            throw new Exception("Prosledjeni objekat nije instanca klase Roba");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        ArrayList<AbstractDomainObject> listRoba=DBBroker.getInstance().select(ado,o);
        list= (ArrayList<Roba>) (ArrayList<?>) listRoba;
    }
    
    public ArrayList<Roba> getList(){
        return list;
    }
}
