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

   

    public MindFitStaff AddMindFitStaff(){
        
        MindFitStaff mindfitstaff = new MindFitStaff();
        mindfitstafflist.add(mindfitstaff);
        return mindfitstaff;
    }
    
    public boolean DeleteMindFitStaff(int id){
         for(MindFitStaff mindfitstaff: mindfitstafflist){
             if(id==mindfitstaff.getId()){
                 mindfitstafflist.remove(mindfitstaff);
                 return true;
             }
             
         }
         return false;
    }
    
    public MindFitStaff RetrieveMindFitStaff(int id){
        
        for(MindFitStaff mindfitstaff: mindfitstafflist){
            
            if(id==mindfitstaff.getId()){
                
                return mindfitstaff;
            }
        }
        return null;
    
}
    
}
