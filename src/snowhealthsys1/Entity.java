/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snowhealthsys1;

/**
 *
 * @author ellie
 */
public interface Entity {
    
    /*
    * @return String for name of Entity
    */
    public String getName();
    
    /*
    * @return String for desc of Entity
    */
    public String getDescription();
    
    /*
    * @return int for num of whatever
    */
    public int getQuantity();
}
