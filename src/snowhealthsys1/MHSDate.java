/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snowhealthsys1;

import java.util.Date;

/**
 *
 * @author ellie
 */
public interface MHSDate {
    
    /*
    * @return MHSDate formatted MHSDate obj for appt
    */
    public MHSDate getApptDate();
    
    /*
    * 
    */
    public void setApptDate();
    
    /*
    * @return MHSDate formatted date from java Date obj
    * @param Date date for java date obj to be converted to MHSDate obj
    */
    public MHSDate toMHSDate(Date date);
}
