/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import database.DBBroker;
import util.AbstractDomainObject;
import java.sql.SQLException;

/**
 *
 * @author Marko
 */
public abstract class AbstractSO {
    protected abstract void validate(AbstractDomainObject ado) throws Exception;
    protected abstract void execute(AbstractDomainObject ado, Object o) throws Exception;
    
    public void templateExecute(AbstractDomainObject ado, Object o) throws Exception{
        try{
            validate(ado);
            execute(ado, o);
            commit();
        }catch(Exception e){
            rollback();
            throw e;
        }
    }
    
    public void commit() throws SQLException{
        
        DBBroker.getInstance().getConnection().commit();
    }
    
    public void rollback() throws SQLException{
        DBBroker.getInstance().getConnection().rollback();
    }
}
