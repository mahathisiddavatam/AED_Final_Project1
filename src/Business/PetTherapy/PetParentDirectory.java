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
public class PetParentDirectory {
    
    private ArrayList<PetParent> petparentlist;
    
    public void PetParentDirectory() {
        petparentlist = new ArrayList();
        
        
    }

    public ArrayList<PetParent> getpetparentlist() {
        return petparentlist;
    }

   

    public PetParent AddPetParent(String id){
        
        PetParent petparent = new PetParent();
        petparent.setId(id);
        petparentlist.add(petparent);
        return petparent;
    }
    
    public boolean DeletePetParent(String id){
         for(PetParent petparent: petparentlist){
             if(id.equals(petparent.getId())){
                 petparentlist.remove(petparent);
                 return true;
             }
             
         }
         return false;
    }
    
    public PetParent RetrievePetParent(String id){
        
        for(PetParent petparent: petparentlist){
            
            if(id.equals(petparent.getId())){
                
                return petparent;
            }
        }
        return null;
    
}
    
}
