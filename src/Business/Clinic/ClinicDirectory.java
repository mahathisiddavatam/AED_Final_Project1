/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Clinic;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class ClinicDirectory {
    
    private ArrayList<Clinic> cliniclist;
    private TherapistDirectory therapistdir;
    private ClinicStaffDirectory clinicstaffdir;
    

    public ClinicDirectory() {
        cliniclist = new ArrayList();
        therapistdir = new TherapistDirectory();
        clinicstaffdir = new ClinicStaffDirectory();
       
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
    
    public boolean deleteClinic(int id){
         for(Clinic clinic: cliniclist){
             if(id==clinic.getId()){
                 cliniclist.remove(clinic);
                 return true;
             }
             
         }
         return false;
    }
    
    public Clinic RetrieveClinic(int id){
        
        for(Clinic clinic: cliniclist){
            
            if(id==clinic.getId()){
                
                return clinic;
            }
        }
        return null;
        
        
    }
    
    
    
}
