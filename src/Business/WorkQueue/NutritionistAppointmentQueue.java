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
public class NutritionistAppointmentQueue {
    
    private ArrayList<NutritionistAppointment> nutritionistappointmentlist;

    public NutritionistAppointmentQueue() {
        nutritionistappointmentlist = new ArrayList();
    }

    public ArrayList<NutritionistAppointment> getNutritionistAppointmentlist() {
        return nutritionistappointmentlist;
    }

    public void setNutritionistAppointmentlist(ArrayList<NutritionistAppointment> nutritionistappointmentlist) {
        this.nutritionistappointmentlist = nutritionistappointmentlist;
    }
    
    public NutritionistAppointment addNutritionistAppointment(){
        
        NutritionistAppointment nutritionistappointment = new NutritionistAppointment();
        nutritionistappointmentlist.add(nutritionistappointment);
        return nutritionistappointment;
        
    }
    
    public NutritionistAppointment retrieveNutritionistAppointment(int id){
        
        for(NutritionistAppointment nutritionistappointment: nutritionistappointmentlist){
            
            if(nutritionistappointment.getId()==id){
                return nutritionistappointment;
            }
        }
        return null;
        
        
    }
    
    public boolean deleteNutritionistAppointment(int id){
        
        NutritionistAppointment nutritionistappointment = retrieveNutritionistAppointment(id);
        if(nutritionistappointment==null){
            
            return false;
        }
        nutritionistappointmentlist.remove(nutritionistappointment);
        return true;
        
        
        
    }
    
}
