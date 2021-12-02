/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class TherapyQueue {
    
    private ArrayList<Therapy> therapylist;

    public TherapyQueue() {
        therapylist = new ArrayList();
    }

    public ArrayList<Therapy> getTherapylist() {
        return therapylist;
    }

    public void setTherapylist(ArrayList<Therapy> therapylist) {
        this.therapylist = therapylist;
    }
    
    public Therapy addTherapy(){
        
        Therapy therapy = new Therapy();
        therapylist.add(therapy);
        return therapy;
        
    }
    
    public Therapy retrieveTherapy(int id){
        
        for(Therapy therapy: therapylist){
            
            if(therapy.getId()==id){
                return therapy;
            }
        }
        return null;
        
        
    }
    
    public boolean deleteTherapy(int id){
        
        Therapy therapy = retrieveTherapy(id);
        if(therapy==null){
            
            return false;
        }
        therapylist.remove(therapy);
        return true;
        
        
        
    }

    
}