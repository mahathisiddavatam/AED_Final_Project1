/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MindFitness;

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

    public void setMindfitlist(ArrayList<MindFitness> mindfitlist) {
        this.mindfitlist = mindfitlist;
    }

    public MindFitnessDirectory() {
        mindfitlist = new ArrayList();
        yogadir = new YogaInstructorDirectory();
        nutridir = new NutrionistDirectory();
        mindstaffdir = new MindFitStaffDirectory();
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