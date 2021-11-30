/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MindFitness;

/**
 *
 * @author Varakumar
 */
public class Nutritionist {
    
    int id;
    int count =1;
    
    public Nutritionist(){
        
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }
    
}
