/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MindFitness;

import Business.WorkQueue.YogaRequest;
import java.util.ArrayList;
import java.util.Iterator;

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

    public void setYogainstlist(ArrayList<YogaInstructor> yogainstlist) {
        this.yogainstlist = yogainstlist;
    }

   

    public YogaInstructor AddYogaInstructor(String id){
        
        YogaInstructor yogainst = new YogaInstructor();
        yogainst.setId(id);
        yogainstlist.add(yogainst);
        return yogainst;
    }
    
    public boolean DeleteYogaInstructor(String id){
         
        Iterator<YogaInstructor> itr7 = yogainstlist.iterator();
                
            
            while(itr7.hasNext()){
            
            YogaInstructor ua = itr7.next();
            if(ua.getId().equals(id)){
                itr7.remove();
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
