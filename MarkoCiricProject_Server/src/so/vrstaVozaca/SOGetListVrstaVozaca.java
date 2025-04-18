/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vrstaVozaca;

import database.DBBroker;
import util.AbstractDomainObject;
import util.VrstaVozaca;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOGetListVrstaVozaca extends AbstractSO{

    private ArrayList<VrstaVozaca> list;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof VrstaVozaca)) {
            throw new Exception("Prosledjeni objekat nije instanca klase VrstaVozaca");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        ArrayList<AbstractDomainObject> listVrstaVozaca = DBBroker.getInstance().select(ado,o);
        list = (ArrayList<VrstaVozaca>) (ArrayList<?>) listVrstaVozaca;
       
    }
    
    public ArrayList<VrstaVozaca> getList(){
        return list;
    }
}
