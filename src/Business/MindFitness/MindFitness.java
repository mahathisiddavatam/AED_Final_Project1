/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MindFitness;

/**
 *
 * @author raunak
 */
public class MindFitness {
    
    int id;
    int count =1;
    
    public MindFitness(){
        
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }
    
    
}
