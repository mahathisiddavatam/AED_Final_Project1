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
public class TherapistDirectory {
    
    private ArrayList<Therapist> therapistlist;
    
    public TherapistDirectory() {
        therapistlist = new ArrayList();
        
        
    }

    public ArrayList<Therapist> gettherapistlist() {
        return therapistlist;
    }

   

    public Therapist AddTherapist(String id){
        
        Therapist therapist = new Therapist();
        therapist.setId(id);
        therapistlist.add(therapist);
        return therapist;
    }
    
    public boolean DeleteTherapist(String id){
         for(Therapist therapist: therapistlist){
             if(id.equals(therapist.getId())){
                 therapistlist.remove(therapist);
                 return true;
             }
             
         }
         return false;
    }
    
    public Therapist RetrieveTherapist(String id){
        
        for(Therapist therapist: therapistlist){
            
            if(id.equals(therapist.getId())){
                
                return therapist;
            }
        }
        return null;
    
}
    
}
