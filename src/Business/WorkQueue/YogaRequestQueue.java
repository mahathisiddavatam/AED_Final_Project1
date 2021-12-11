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
public class YogaRequestQueue {
    
    private ArrayList<YogaRequest> yogarequestlist;

    public YogaRequestQueue() {
        yogarequestlist = new ArrayList();
    }

    public ArrayList<YogaRequest> getYogaRequestlist() {
        return yogarequestlist;
    }

    public void setYogaRequestlist(ArrayList<YogaRequest> yogarequestlist) {
        this.yogarequestlist = yogarequestlist;
    }
    
    public YogaRequest addYogaRequest(){
        
        YogaRequest yogarequest = new YogaRequest();
        yogarequestlist.add(yogarequest);
        return yogarequest;
        
    }
    
    public YogaRequest retrieveYogaRequest(int id){
        
        for(YogaRequest yogarequest: yogarequestlist){
            
            if(yogarequest.getId()==id){
                return yogarequest;
            }
        }
        return null;
        
        
    }
    
    public boolean deleteYogaRequest(int id){
        
        YogaRequest yogarequest = retrieveYogaRequest(id);
        if(yogarequest==null){
            
            return false;
        }
        yogarequestlist.remove(yogarequest);
        return true;
        
        
        
    }
    
    
    
}
