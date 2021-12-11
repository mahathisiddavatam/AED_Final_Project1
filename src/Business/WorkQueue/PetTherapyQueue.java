/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;


import java.util.ArrayList;

/**
 *
 * @author Varakumar
 */
public class PetTherapyQueue {
    
    private ArrayList<PTherapy> pettherapylist;

    public PetTherapyQueue() {
        pettherapylist = new ArrayList();
    }

    public ArrayList<PTherapy> getPTherapylist() {
        return pettherapylist;
    }

    public void setPTherapylist(ArrayList<PTherapy> pettherapylist) {
        this.pettherapylist = pettherapylist;
    }
    
    public PTherapy addPTherapy(){
        
        PTherapy pettherapy = new PTherapy();
        pettherapylist.add(pettherapy);
        return pettherapy;
        
    }
    
    public PTherapy retrievePTherapy(int id){
        
        for(PTherapy pettherapy: pettherapylist){
            
            if(pettherapy.getId()==id){
                return pettherapy;
            }
        }
        return null;
        
        
    }
    
    public boolean deletePTherapy(int id){
        
        PTherapy pettherapy = retrievePTherapy(id);
        if(pettherapy==null){
            
            return false;
        }
        pettherapylist.remove(pettherapy);
        return true;
        
        
        
    }
    
}
