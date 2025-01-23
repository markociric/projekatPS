/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vzvv;

import database.DBBroker;
import util.AbstractDomainObject;
import util.VzVV;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOGetListVzVV extends AbstractSO{
    private ArrayList<VzVV> list;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof VzVV)){
            throw new Exception("Prosledjeni objekat nije instanca klase VzVV");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        ArrayList<AbstractDomainObject> listVzVV=DBBroker.getInstance().select(ado,o);
        list= (ArrayList<VzVV>) (ArrayList<?>) listVzVV;
       
    }
    
    public ArrayList<VzVV> getList(){
        return list;
    }
}
