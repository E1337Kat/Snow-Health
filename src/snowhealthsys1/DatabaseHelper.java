/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snowhealthsys1;

import java.sql.SQLException;

/**
 *
 * @author ellie
 */
public interface DatabaseHelper {
    
    /*
    *@throws SQLException when opening db
    */
    public void Open() throws SQLException;
    
    /*
    *@param String for db name
    */
    public void Close(String name);
    
    /*
    * @param long id for id of what you are looking for
    */
    public void Query(long id);
    
    /*
    * @return long returns position of newly added obj
    * @param Object obj for generic object to add to the db
    */
    public long Add(Object[] obj);
    
    /*
    * @param Object obj for the generic obj passed to the db for updating
    */
    public void Update(Object obj);
    
    /*
    * @param String name for name of db
    * @param int version for version of db
    */
    public void Create(String name, int version);
}
