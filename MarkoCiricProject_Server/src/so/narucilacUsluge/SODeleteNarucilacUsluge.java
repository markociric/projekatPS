/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.narucilacUsluge;

import database.DBBroker;
import java.sql.SQLException;
import util.AbstractDomainObject;
import so.AbstractSO;
import util.NarucilacUsluge;

/**
 *
 * @author Marko
 */
public class SODeleteNarucilacUsluge extends AbstractSO{
    boolean result;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof NarucilacUsluge)) {
            throw new Exception("Prosledjeni objekat nije instanca klase NarucilacUsluge!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado, Object o) throws Exception {
        try {    
        result =  DBBroker.getInstance().delete(ado);
        } catch (SQLException e) {
        
        }
    }
    
    public boolean isDeleted() throws SQLException {
        return result;
    }
}
