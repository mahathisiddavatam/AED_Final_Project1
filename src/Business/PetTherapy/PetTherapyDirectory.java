/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PetTherapy;


import Business.WorkQueue.PetTherapyQueue;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class PetTherapyDirectory {
    
    
    private ArrayList<PetTherapy> pettherapylist;
    private PetParentDirectory petparentdir;
    private PetTherapyStaffDirectory petstaffdir;
    private PetTherapyQueue pettherapyqueue;
    

    public PetTherapyDirectory() {
        pettherapylist = new ArrayList();
        petparentdir = new PetParentDirectory();
        petstaffdir = new PetTherapyStaffDirectory();
        pettherapyqueue = new PetTherapyQueue();
        
    }

    public PetTherapyQueue getPettherapyqueue() {
        return pettherapyqueue;
    }

    public void setPettherapyqueue(PetTherapyQueue pettherapyqueue) {
        this.pettherapyqueue = pettherapyqueue;
    }

    public ArrayList<PetTherapy> getpettherapylist() {
        return pettherapylist;
    }

    public PetParentDirectory getPetparentdir() {
        return petparentdir;
    }



    public PetTherapyStaffDirectory getPetstaffdir() {
        return petstaffdir;
    }
  

    public PetTherapy AddPetTherapy(){
        
        PetTherapy pet = new PetTherapy();
        pettherapylist.add(pet);
        return pet;
    }
    
    public boolean DeletePetTherapy(String id){
         for(PetTherapy pet: pettherapylist){
             if(id.equals(pet.getId())){
                 pettherapylist.remove(pet);
                 return true;
             }
             
         }
         return false;
    }
    
    public PetTherapy RetrievePetTherapy(String id){
        
        for(PetTherapy pet: pettherapylist){
            
            if(id.equals(pet.getId())){
                
                return pet;
            }
        }
        return null;
    
}

    public void setPettherapylist(ArrayList<PetTherapy> pettherapylist) {
        this.pettherapylist = pettherapylist;
    }
}
