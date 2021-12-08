/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MindFitness;

import Business.WorkQueue.NutritionRequestQueue;
import Business.WorkQueue.NutritionistAppointmentQueue;
import Business.WorkQueue.YogaAppointmentQueue;
import Business.WorkQueue.YogaRequestQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class MindFitnessDirectory {
    
    private ArrayList<MindFitness> mindfitlist;
    private YogaInstructorDirectory yogadir;
    private NutrionistDirectory nutridir;
    private MindFitStaffDirectory mindstaffdir;
    private NutritionistAppointmentQueue nutriqueue;
    private YogaAppointmentQueue yogaqueue;
    private YogaRequestQueue yogarequestqueue;
    private NutritionRequestQueue nutrirequestqueue;

    public void setMindfitlist(ArrayList<MindFitness> mindfitlist) {
        this.mindfitlist = mindfitlist;
    }

    public MindFitnessDirectory() {
        mindfitlist = new ArrayList();
        yogadir = new YogaInstructorDirectory();
        nutridir = new NutrionistDirectory();
        mindstaffdir = new MindFitStaffDirectory();
        this.yogaqueue = new YogaAppointmentQueue();
        this.nutriqueue = new NutritionistAppointmentQueue();
        this.yogarequestqueue = new YogaRequestQueue();
        this.nutrirequestqueue = new NutritionRequestQueue();
    }

    public YogaRequestQueue getYogarequestqueue() {
        return yogarequestqueue;
    }

    public void setYogarequestqueue(YogaRequestQueue yogarequestqueue) {
        this.yogarequestqueue = yogarequestqueue;
    }

    public NutritionRequestQueue getNutrirequestqueue() {
        return nutrirequestqueue;
    }

    public void setNutrirequestqueue(NutritionRequestQueue nutrirequestqueue) {
        this.nutrirequestqueue = nutrirequestqueue;
    }

    public NutritionistAppointmentQueue getNutriqueue() {
        return nutriqueue;
    }

    public void setNutriqueue(NutritionistAppointmentQueue nutriqueue) {
        this.nutriqueue = nutriqueue;
    }

    public YogaAppointmentQueue getYogaqueue() {
        return yogaqueue;
    }

    public void setYogaqueue(YogaAppointmentQueue yogaqueue) {
        this.yogaqueue = yogaqueue;
    }

    public ArrayList<MindFitness> getMindfitlist() {
        return mindfitlist;
    }

    public YogaInstructorDirectory getYogadir() {
        return yogadir;
    }

    public NutrionistDirectory getNutridir() {
        return nutridir;
    }

    public MindFitStaffDirectory getMindstaffdir() {
        return mindstaffdir;
    }

    public MindFitness addNewMindFitness(){
        
        MindFitness mind = new MindFitness();
        mindfitlist.add(mind);
        return mind;
    }
    
    public boolean deleteMindFitness(String id){
         for(MindFitness mind: mindfitlist){
             if(id.equals(mind.getId())){
                 mindfitlist.remove(mind);
                 return true;
             }
             
         }
         return false;
    }
    
    public MindFitness RetrieveMindFitness(String id){
        
        for(MindFitness mind: mindfitlist){
            
            if(id.equals(mind.getId())){
                
                return mind;
            }
        }
        return null;
        
        
    }
    
    
}