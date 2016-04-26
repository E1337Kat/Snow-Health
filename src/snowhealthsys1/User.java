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
public interface User {
    
    /*
    * 
    */
    public void login();
    
    /*
    * @return Entity for the db item to look up
    * @param String dbQuery for the string user uses to query the db
    */
    public Entity getPatient(String dbQuery);
    
    /*
    * @param Entity patient to update
    */
    public void updatePatient(Entity patient);
    
    /*
    * @return Entity for the db item to look up
    * @param String dbQuery for the string user uses to query the db
    */
    public Entity getRecord(String dbQuery);
    
    /*
    * @param Entity patient for which patient record to update
    */
    public void updateRecord(Entity patient);
    
    /*
    * @return MHSDate for system date object
    * @param Entity patient for which patient to query
    */
    public MHSDate getAppointment(Entity patient);
    
    /*
    * @param Entity patient for which patient to associate the appt with
    * @param MHSDate apptDate to set apptDate in system
    */
    public void setAppointment(Entity patient, MHSDate apptDate);
    
    /*
    * @return Entity returns diagnosis for patient
    * @param Entity patient for which patient to query
    */
    public Entity getDiagnosis(Entity patient);
    
    /*
    * @param Entity patient for which patient to apply diagnosis to
    * @param Entity diagnosis for what diagnosis to apply to patient
    */
    public void setDiagnosis(Entity patient, Entity diagnosis);
    
    /*
    * @return Entity for treatments patient already has
    * @param Entity patient for which patient to query
    */
    public Entity getTreatment(Entity patient);
    
    /*
    * @param Entity patient for which patient to give a treatment
    */
    public void setTreatment(Entity patient);
}
