/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vrstaVozaca;

import database.DBBroker;
import java.sql.SQLException;
import util.AbstractDomainObject;
import util.VrstaVozaca;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SODeleteVrstaVozaca extends AbstractSO{
    boolean result;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof VrstaVozaca)) {
            throw new Exception("Prosledjeni objekat nije instanca klase VrstaVozaca!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        result = DBBroker.getInstance().delete(ado);
    }
    public boolean isDeleted() throws SQLException {
        return result;
    }
}
