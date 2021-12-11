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
public class YogaAppointmentQueue {
    
    private ArrayList<YogaAppointment> yogaappointmentlist;

    public YogaAppointmentQueue() {
        yogaappointmentlist = new ArrayList();
    }

    public ArrayList<YogaAppointment> getYogaAppointmentlist() {
        return yogaappointmentlist;
    }

    public void setYogaAppointmentlist(ArrayList<YogaAppointment> yogaappointmentlist) {
        this.yogaappointmentlist = yogaappointmentlist;
    }
    
    public YogaAppointment addYogaAppointment(){
        
        YogaAppointment yogaappointment = new YogaAppointment();
        yogaappointmentlist.add(yogaappointment);
        return yogaappointment;
        
    }
    
    public YogaAppointment retrieveYogaAppointment(int id){
        
        for(YogaAppointment yogaappointment: yogaappointmentlist){
            
            if(yogaappointment.getId()==id){
                return yogaappointment;
            }
        }
        return null;
        
        
    }
    
    public boolean deleteYogaAppointment(int id){
        
        YogaAppointment yogaappointment = retrieveYogaAppointment(id);
        if(yogaappointment==null){
            
            return false;
        }
        yogaappointmentlist.remove(yogaappointment);
        return true;
        
        
        
    }
    
}
