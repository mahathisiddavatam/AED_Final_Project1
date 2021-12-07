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

    public void setNutritionistlist(ArrayList<Nutritionist> nutritionistlist) {
        this.nutritionistlist = nutritionistlist;
    }

   

    public Nutritionist AddNutritionist(String id){
        
        Nutritionist nutritionist = new Nutritionist();
        nutritionist.setId(id);
        nutritionistlist.add(nutritionist);
        return nutritionist;
    }
    
    public boolean DeleteNutritionist(String id){
         for(Nutritionist nutritionist: nutritionistlist){
             if(id.equals(nutritionist.getId())){
                 nutritionistlist.remove(nutritionist);
                 return true;
             }
             
         }
         return false;
    }
    
    public Nutritionist RetrieveNutritionist(String id){
        
        for(Nutritionist nutritionist: nutritionistlist){
            
            if(id.equals(nutritionist.getId())){
                
                return nutritionist;
            }
        }
        return null;
    
}
    
}
