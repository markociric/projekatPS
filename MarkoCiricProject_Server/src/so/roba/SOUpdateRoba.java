/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.roba;

import database.DBBroker;
import java.sql.SQLException;
import util.AbstractDomainObject;
import util.Roba;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOUpdateRoba extends AbstractSO {

    boolean result;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Roba)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Roba");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        result = DBBroker.getInstance().update(ado);
    }

    public boolean isUpdated() throws SQLException {
        return result;
    }
}
