/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.otpremnica;

import database.DBBroker;
import java.sql.SQLException;
import util.AbstractDomainObject;
import util.Otpremnica;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Marko
 */
public class SOUpdateOtpremnica extends AbstractSO {

    boolean result;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Otpremnica)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Otpremnica!");
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
