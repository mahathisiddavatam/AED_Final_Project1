/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MindFitness;

import java.util.ArrayList;

/**
 *
 * @author Varakumar
 */
public class YogaInstructorDirectory {
    
    private ArrayList<YogaInstructor> yogainstlist;
    
    public void YogaInstructorDirectory() {
        yogainstlist = new ArrayList();
        
        
    }

    public ArrayList<YogaInstructor> getyogainstlist() {
        return yogainstlist;
    }

   

    public YogaInstructor AddYogaInstructor(){
        
        YogaInstructor yogainst = new YogaInstructor();
        yogainstlist.add(yogainst);
        return yogainst;
    }
    
    public boolean DeleteYogaInstructor(int id){
         for(YogaInstructor yogainst: yogainstlist){
             if(id==yogainst.getId()){
                 yogainstlist.remove(yogainst);
                 return true;
             }
             
         }
         return false;
    }
    
    public YogaInstructor RetrieveYogaInstructor(int id){
        
        for(YogaInstructor yogainst: yogainstlist){
            
            if(id==yogainst.getId()){
                
                return yogainst;
            }
        }
        return null;
    
}
    
}
