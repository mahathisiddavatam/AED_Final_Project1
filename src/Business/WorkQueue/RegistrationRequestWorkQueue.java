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
public class RegistrationRequestWorkQueue {
    
     private ArrayList<RegistrationRequest> registrationrequestlist;

    public RegistrationRequestWorkQueue() {
        registrationrequestlist = new ArrayList();
    }

    public ArrayList<RegistrationRequest> getRegistrationRequestlist() {
        return registrationrequestlist;
    }

    public void setRegistrationRequestlist(ArrayList<RegistrationRequest> registrationrequestlist) {
        this.registrationrequestlist = registrationrequestlist;
    }
    
    public RegistrationRequest addRegistrationRequest(){
        
        RegistrationRequest registrationrequest = new RegistrationRequest();
        Random rand = new Random();
        registrationrequest.id = rand.nextInt(12345);
        registrationrequestlist.add(registrationrequest);
        return registrationrequest;
        
    }
    
    public RegistrationRequest retrieveRegistrationRequest(int id){
        
        for(RegistrationRequest registrationrequest: registrationrequestlist){
            
            if(registrationrequest.getId()==id){
                return registrationrequest;
            }
        }
        return null;
        
        
    }
    
    public boolean deleteRegistrationRequest(int id){
        
        RegistrationRequest registrationrequest = retrieveRegistrationRequest(id);
        if(registrationrequest==null){
            
            return false;
        }
        registrationrequestlist.remove(registrationrequest);
        return true;
        
        
        
    }
    
    
    
}
