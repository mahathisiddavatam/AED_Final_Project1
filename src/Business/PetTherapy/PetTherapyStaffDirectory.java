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

   

    

    public void setPettherapystafflist(ArrayList<PetTherapyStaff> pettherapystafflist) {
        this.pettherapystafflist = pettherapystafflist;
    }
    
    public PetTherapyStaff AddPetTherapyStaff(String id){
        
        PetTherapyStaff pettherapystaff = new PetTherapyStaff();
        pettherapystaff.setId(id);
        if(pettherapystafflist==null){
            ArrayList <PetTherapyStaff> pettherapystafflist = new ArrayList();
            setPettherapystafflist(pettherapystafflist);
        }
        pettherapystafflist.add(pettherapystaff);
        return pettherapystaff;
    }
    
    public boolean DeletePetTherapyStaff(String id){
         for(PetTherapyStaff pettherapystaff: pettherapystafflist){
             if(id.equals(pettherapystaff.getId())){
                 pettherapystafflist.remove(pettherapystaff);
                 return true;
             }
         }
         return false;
    }
    
    public PetTherapyStaff RetrievePetTherapyStaff(String id){
        
        for(PetTherapyStaff pettherapystaff: pettherapystafflist){
            
            if(id.equals(pettherapystaff.getId())){
                
                return pettherapystaff;
            }
        }
        return null;
    
}
    
}
