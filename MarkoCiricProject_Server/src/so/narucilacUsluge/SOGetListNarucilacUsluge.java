/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.narucilacUsluge;

import database.DBBroker;
import util.AbstractDomainObject;
import util.NarucilacUsluge;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOGetListNarucilacUsluge extends AbstractSO{
    private ArrayList<NarucilacUsluge> list;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof NarucilacUsluge)){
            throw new Exception("Prosledjeni objekat nije instanca klase NarucilacUsluge");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        ArrayList<AbstractDomainObject> listNarucilacUsluge=DBBroker.getInstance().select(ado,o);
        list= (ArrayList<NarucilacUsluge>) (ArrayList<?>) listNarucilacUsluge;
    }
    
    public ArrayList<NarucilacUsluge> getLista(){
        return list;
    }
}
