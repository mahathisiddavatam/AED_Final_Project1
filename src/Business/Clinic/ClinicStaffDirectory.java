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

   

    public ClinicStaff AddClinicStaff(){
        
        ClinicStaff clinicstaff = new ClinicStaff();
        clinicstafflist.add(clinicstaff);
        return clinicstaff;
    }
    
    public boolean DeleteClinicStaff(int id){
         for(ClinicStaff clinicstaff: clinicstafflist){
             if(id==clinicstaff.getId()){
                 clinicstafflist.remove(clinicstaff);
                 return true;
             }
             
         }
         return false;
    }
    
    public ClinicStaff RetrieveClinicStaff(int id){
        
        for(ClinicStaff clinicstaff: clinicstafflist){
            
            if(id==clinicstaff.getId()){
                
                return clinicstaff;
            }
        }
        return null;
    
}
    
    
    
}
