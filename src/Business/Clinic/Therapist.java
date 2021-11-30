/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Clinic;

/**
 *
 * @author Varakumar
 */
public class Therapist {
    
    int id;
    int count =1;
    
    public Therapist(){
        
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }
    
}
