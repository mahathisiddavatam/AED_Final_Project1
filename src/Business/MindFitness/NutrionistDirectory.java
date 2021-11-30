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
public class NutrionistDirectory {
    
    private ArrayList<Nutritionist> nutritionistlist;
    
    public void NutritionistDirectory() {
        nutritionistlist = new ArrayList();
        
        
    }

    public ArrayList<Nutritionist> getnutritionistlist() {
        return nutritionistlist;
    }

   

    public Nutritionist AddNutritionist(){
        
        Nutritionist nutritionist = new Nutritionist();
        nutritionistlist.add(nutritionist);
        return nutritionist;
    }
    
    public boolean DeleteNutritionist(int id){
         for(Nutritionist nutritionist: nutritionistlist){
             if(id==nutritionist.getId()){
                 nutritionistlist.remove(nutritionist);
                 return true;
             }
             
         }
         return false;
    }
    
    public Nutritionist RetrieveNutritionist(int id){
        
        for(Nutritionist nutritionist: nutritionistlist){
            
            if(id==nutritionist.getId()){
                
                return nutritionist;
            }
        }
        return null;
    
}
    
}
