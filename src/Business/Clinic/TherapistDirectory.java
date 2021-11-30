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

   

    public Therapist AddTherapist(){
        
        Therapist therapist = new Therapist();
        therapistlist.add(therapist);
        return therapist;
    }
    
    public boolean DeleteTherapist(int id){
         for(Therapist therapist: therapistlist){
             if(id==therapist.getId()){
                 therapistlist.remove(therapist);
                 return true;
             }
             
         }
         return false;
    }
    
    public Therapist RetrieveTherapist(int id){
        
        for(Therapist therapist: therapistlist){
            
            if(id==therapist.getId()){
                
                return therapist;
            }
        }
        return null;
    
}
    
}
