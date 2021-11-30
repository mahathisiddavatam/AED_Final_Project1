/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PetTherapy;


import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class PetTherapyDirectory {
    
    
    private ArrayList<PetTherapy> pettherapylist;
    private PetParentDirectory petparentdir;
    private PetTherapyStaffDirectory petstaffdir;
    

    public PetTherapyDirectory() {
        pettherapylist = new ArrayList();
        petparentdir = new PetParentDirectory();
        petstaffdir = new PetTherapyStaffDirectory();
        
    }

    public ArrayList<PetTherapy> getpettherapylist() {
        return pettherapylist;
    }

   

    public PetTherapy AddPetTherapy(){
        
        PetTherapy pet = new PetTherapy();
        pettherapylist.add(pet);
        return pet;
    }
    
    public boolean DeletePetTherapy(int id){
         for(PetTherapy pet: pettherapylist){
             if(id==pet.getId()){
                 pettherapylist.remove(pet);
                 return true;
             }
             
         }
         return false;
    }
    
    public PetTherapy RetrievePetTherapy(int id){
        
        for(PetTherapy pet: pettherapylist){
            
            if(id==pet.getId()){
                
                return pet;
            }
        }
        return null;
    
}
}
