/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Varakumar
 */
public class PetQueue {
    
    private ArrayList<Pet> petlist;

    public PetQueue() {
        petlist = new ArrayList();
    }

    public ArrayList<Pet> getPetlist() {
        return petlist;
    }

    public void setPetlist(ArrayList<Pet> petlist) {
        this.petlist = petlist;
    }
    
    public Pet addPet(){
        
        Pet pet = new Pet();
        Random rand = new Random();
        pet.id = rand.nextInt(12345);
        petlist.add(pet);
        return pet;
        
    }
    
    public Pet retrievePet(int id){
        
        for(Pet pet: petlist){
            
            if(pet.getId()==id){
                return pet;
            }
        }
        return null;
        
        
    }
    
    public boolean deletePet(int id){
        
        Pet pet = retrievePet(id);
        if(pet==null){
            
            return false;
        }
        petlist.remove(pet);
        return true;
        
        
        
    }
    
}
