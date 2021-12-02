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
public class AccessRequestQueue {
    
    private ArrayList<AccessRequest> accessrequestlist;

    public AccessRequestQueue() {
        accessrequestlist = new ArrayList();
    }

    public ArrayList<AccessRequest> getAccessRequestlist() {
        return accessrequestlist;
    }

    public void setAccessRequestlist(ArrayList<AccessRequest> accessrequestlist) {
        this.accessrequestlist = accessrequestlist;
    }
    
    public AccessRequest addAccessRequest(){
        
        AccessRequest accessrequest = new AccessRequest();
        accessrequestlist.add(accessrequest);
        return accessrequest;
        
    }
    
    public AccessRequest retrieveAccessRequest(int id){
        
        for(AccessRequest accessrequest: accessrequestlist){
            
            if(accessrequest.getId()==id){
                return accessrequest;
            }
        }
        return null;
        
        
    }
    
    public boolean deleteAccessRequest(int id){
        
        AccessRequest accessrequest = retrieveAccessRequest(id);
        if(accessrequest==null){
            
            return false;
        }
        accessrequestlist.remove(accessrequest);
        return true;
        
        
        
    }
    
}
