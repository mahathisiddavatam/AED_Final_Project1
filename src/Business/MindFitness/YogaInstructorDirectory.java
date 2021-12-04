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

   

    public YogaInstructor AddYogaInstructor(String id){
        
        YogaInstructor yogainst = new YogaInstructor();
        yogainst.setId(id);
        yogainstlist.add(yogainst);
        return yogainst;
    }
    
    public boolean DeleteYogaInstructor(String id){
         for(YogaInstructor yogainst: yogainstlist){
             if(id.equals(yogainst.getId())){
                 yogainstlist.remove(yogainst);
                 return true;
             }
             
         }
         return false;
    }
    
    public YogaInstructor RetrieveYogaInstructor(String id){
        
        for(YogaInstructor yogainst: yogainstlist){
            
            if(id.equals(yogainst.getId())){
                
                return yogainst;
            }
        }
        return null;
    
}
    
}
