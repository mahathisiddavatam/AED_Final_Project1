/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Clinic;

import Business.WorkQueue.TherapyQueue;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class ClinicDirectory {
    
    private ArrayList<Clinic> cliniclist;
    private TherapistDirectory therapistdir;
    private ClinicStaffDirectory clinicstaffdir;
    private TherapyQueue therapyqueue;
    

    public ClinicDirectory() {
        cliniclist = new ArrayList();
        therapistdir = new TherapistDirectory();
        clinicstaffdir = new ClinicStaffDirectory();
        therapyqueue = new TherapyQueue();
       
    }

    public TherapyQueue getTherapyqueue() {
        return therapyqueue;
    }

    public void setTherapyqueue(TherapyQueue therapyqueue) {
        this.therapyqueue = therapyqueue;
    }

    public ArrayList<Clinic> getCliniclist() {
        return cliniclist;
    }

    public TherapistDirectory getTherapistdir() {
        return therapistdir;
    }

    public ClinicStaffDirectory getClinicstaffdir() {
        return clinicstaffdir;
    }

    public Clinic addNewClinic(){
        
        Clinic clinic = new Clinic();
        cliniclist.add(clinic);
        return clinic;
    }
    
    public boolean deleteClinic(String id){
         for(Clinic clinic: cliniclist){
             if(id.equals(clinic.getId())){
                 cliniclist.remove(clinic);
                 return true;
             }
             
         }
         return false;
    }
    
    public Clinic RetrieveClinic(String id){
        
        for(Clinic clinic: cliniclist){
            
            if(id.equals(clinic.getId())){
                
                return clinic;
            }
        }
        return null;
        
        
    }

    public void setCliniclist(ArrayList<Clinic> cliniclist) {
        this.cliniclist = cliniclist;
    }
    
    
    
}
