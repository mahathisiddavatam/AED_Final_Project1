/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PetTherapy;

import java.util.ArrayList;

/**
 *
 * @author Varakumar
 */
public class PetTherapyStaffDirectory {
    
    
    private ArrayList<PetTherapyStaff> pettherapystafflist;
    
    public void PetTherapyStaffDirectory() {
        pettherapystafflist = new ArrayList();
        
        
    }

    public ArrayList<PetTherapyStaff> getpettherapystafflist() {
        return pettherapystafflist;
    }

   

    public PetTherapyStaff AddPetTherapyStaff(){
        
        PetTherapyStaff pettherapystaff = new PetTherapyStaff();
        pettherapystafflist.add(pettherapystaff);
        return pettherapystaff;
    }
    
    public boolean DeletePetTherapyStaff(int id){
         for(PetTherapyStaff pettherapystaff: pettherapystafflist){
             if(id==pettherapystaff.getId()){
                 pettherapystafflist.remove(pettherapystaff);
                 return true;
             }
             
         }
         return false;
    }
    
    public PetTherapyStaff RetrievePetTherapyStaff(int id){
        
        for(PetTherapyStaff pettherapystaff: pettherapystafflist){
            
            if(id==pettherapystaff.getId()){
                
                return pettherapystaff;
            }
        }
        return null;
    
}
    
}
