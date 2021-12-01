/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Clinic;

import java.util.ArrayList;

/**
 *
 * @author Varakumar
 */
public class ClinicStaffDirectory {
    
    private ArrayList<ClinicStaff> clinicstafflist;
    
    

    public ClinicStaffDirectory() {
        clinicstafflist = new ArrayList();
        
        
    }

    public ArrayList<ClinicStaff> getclinicstafflist() {
        return clinicstafflist;
    }

   

    public ClinicStaff AddClinicStaff(String id){
        
        ClinicStaff clinicstaff = new ClinicStaff();
        clinicstaff.setId(id);
        clinicstafflist.add(clinicstaff);
        return clinicstaff;
    }
    
    public boolean DeleteClinicStaff(String id){
         for(ClinicStaff clinicstaff: clinicstafflist){
             if(id.equals(clinicstaff.getId())){
                 clinicstafflist.remove(clinicstaff);
                 return true;
             }
             
         }
         return false;
    }
    
    public ClinicStaff RetrieveClinicStaff(String id){
        
        for(ClinicStaff clinicstaff: clinicstafflist){
            
            if(id.equals(clinicstaff.getId())){
                
                return clinicstaff;
            }
        }
        return null;
    
}
    
    
    
}
