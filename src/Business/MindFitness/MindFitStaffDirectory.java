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
public class MindFitStaffDirectory {
    
    private ArrayList<MindFitStaff> mindfitstafflist;
    
    public MindFitStaffDirectory() {
        mindfitstafflist = new ArrayList();
        
        
    }

    public ArrayList<MindFitStaff> getmindfitstafflist() {
        return mindfitstafflist;
    }

    public ArrayList<MindFitStaff> getMindfitstafflist() {
        return mindfitstafflist;
    }

    public void setMindfitstafflist(ArrayList<MindFitStaff> mindfitstafflist) {
        this.mindfitstafflist = mindfitstafflist;
    }

   

    public MindFitStaff AddMindFitStaff(String id){
        
        MindFitStaff mindfitstaff = new MindFitStaff();
        mindfitstaff.setId(id);
        mindfitstafflist.add(mindfitstaff);
        return mindfitstaff;
    }
    
    public boolean DeleteMindFitStaff(String id){
         for(MindFitStaff mindfitstaff: mindfitstafflist){
             if(id.equals(mindfitstaff.getId())){
                 mindfitstafflist.remove(mindfitstaff);
                 return true;
             }
             
         }
         return false;
    }
    
    public MindFitStaff RetrieveMindFitStaff(String id){
        
        for(MindFitStaff mindfitstaff: mindfitstafflist){
            
            if(id.equals(mindfitstaff.getId())){
                
                return mindfitstaff;
            }
        }
        return null;
    
}
    
}
