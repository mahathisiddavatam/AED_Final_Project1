/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.University;

import java.util.ArrayList;

/**
 *
 * @author Varakumar
 */
public class VolunteerDirectory {
    
    private ArrayList<Volunteer> volunteerlist;
    
    public void VolunteerDirectory() {
        volunteerlist = new ArrayList();
        
        
    }

    public ArrayList<Volunteer> getvolunteerlist() {
        return volunteerlist;
    }

   

    public Volunteer AddVolunteer(){
        
        Volunteer volunteer = new Volunteer();
        volunteerlist.add(volunteer);
        return volunteer;
    }
    
    public boolean DeleteVolunteer(int id){
         for(Volunteer volunteer: volunteerlist){
             if(id==volunteer.getId()){
                 volunteerlist.remove(volunteer);
                 return true;
             }
             
         }
         return false;
    }
    
    public Volunteer RetrieveVolunteer(int id){
        
        for(Volunteer volunteer: volunteerlist){
            
            if(id==volunteer.getId()){
                
                return volunteer;
            }
        }
        return null;
    
}
    
    
    
}
