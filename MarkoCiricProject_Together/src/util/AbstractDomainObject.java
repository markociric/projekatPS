/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public abstract class AbstractDomainObject implements Serializable{
    public abstract String tableName();
    public abstract String alijas();
    public abstract String join();
    public abstract ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException;
    public abstract String columnsForInsert();
    public abstract String requirement();
    public abstract String valuesForInsert();
    public abstract String valuesForUpdate();
    public abstract String requirementForSelect(Object o);
}
