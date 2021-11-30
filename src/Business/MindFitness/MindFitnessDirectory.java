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
    
    public boolean deleteMindFitness(int id){
         for(MindFitness mind: mindfitlist){
             if(id==mind.getId()){
                 mindfitlist.remove(mind);
                 return true;
             }
             
         }
         return false;
    }
    
    public MindFitness RetrieveMindFitness(int id){
        
        for(MindFitness mind: mindfitlist){
            
            if(id==mind.getId()){
                
                return mind;
            }
        }
        return null;
        
        
    }
    
    
}