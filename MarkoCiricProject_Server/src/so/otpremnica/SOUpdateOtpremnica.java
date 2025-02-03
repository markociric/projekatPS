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
import java.util.List;
import operations.Status;
import so.AbstractSO;
import so.stavkaOtpremnice.SOAddStavkaOtpremnice;
import so.stavkaOtpremnice.SODeleteStavkaOtpremnice;
import so.stavkaOtpremnice.SOUpdateStavkaOtpremnice;
import util.StavkaOtpremnice;

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
        List<Object> param = (List<Object>) o;
        List<StavkaOtpremnice> listStavkaOtpremnice = (List<StavkaOtpremnice>) param.get(0);
        List<StavkaOtpremnice> listStavkaOtpremniceEdited = (List<StavkaOtpremnice>) param.get(1);
        for (StavkaOtpremnice stavkaOtpremnice : listStavkaOtpremnice) {
            if (stavkaOtpremnice.getStatus() == Status.DELETED) {
                SODeleteStavkaOtpremnice so = new SODeleteStavkaOtpremnice();
                so.templateExecute(new StavkaOtpremnice(0, stavkaOtpremnice.getRb(), null, 0), null);
            }
        }
        for (StavkaOtpremnice stavkaOtpremnice : listStavkaOtpremniceEdited) {
            if (stavkaOtpremnice.getStatus() == Status.ADDED) {
                SOAddStavkaOtpremnice so = new SOAddStavkaOtpremnice();
                so.templateExecute(stavkaOtpremnice, null);
            }
            if (stavkaOtpremnice.getStatus() == Status.UPDATED) {
                SOUpdateStavkaOtpremnice s = new SOUpdateStavkaOtpremnice();
                s.templateExecute(stavkaOtpremnice, null);
            }
        }
        result = DBBroker.getInstance().update(ado);
    }

    public boolean isUpdated() throws SQLException {
        return result;
    }
}
