/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.narucilacUsluge;

import util.AbstractDomainObject;
import util.NarucilacUsluge;
import database.DBBroker;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOAddNarucilacUsluge extends AbstractSO {
    int id;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof NarucilacUsluge)) {
            throw new Exception("Prosledjeni objekat nije instanca klase NarucilacUsluge");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado, Object os) throws Exception {
       id = DBBroker.getInstance().insert(ado);
    }

    public int getId() {
        return id;
    }

}
