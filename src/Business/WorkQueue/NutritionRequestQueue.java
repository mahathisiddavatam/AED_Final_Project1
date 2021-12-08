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
public class NutritionRequestQueue {
    
    private ArrayList<NutritionRequest> nutritionrequestlist;

    public NutritionRequestQueue() {
        nutritionrequestlist = new ArrayList();
    }

    public ArrayList<NutritionRequest> getNutritionRequestlist() {
        return nutritionrequestlist;
    }

    public void setNutritionRequestlist(ArrayList<NutritionRequest> nutritionrequestlist) {
        this.nutritionrequestlist = nutritionrequestlist;
    }
    
    public NutritionRequest addNutritionRequest(){
        
        NutritionRequest nutritionrequest = new NutritionRequest();
        nutritionrequestlist.add(nutritionrequest);
        return nutritionrequest;
        
    }
    
    public NutritionRequest retrieveNutritionRequest(int id){
        
        for(NutritionRequest nutritionrequest: nutritionrequestlist){
            
            if(nutritionrequest.getId()==id){
                return nutritionrequest;
            }
        }
        return null;
        
        
    }
    
    public boolean deleteNutritionRequest(int id){
        
        NutritionRequest nutritionrequest = retrieveNutritionRequest(id);
        if(nutritionrequest==null){
            
            return false;
        }
        nutritionrequestlist.remove(nutritionrequest);
        return true;
        
        
        
    }
    
}
