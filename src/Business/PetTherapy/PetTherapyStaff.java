/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PetTherapy;

/**
 *
 * @author Varakumar
 */
public class PetTherapyStaff {
    
    int id;
    int count =1;
    
    public PetTherapyStaff(){
        
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }
    
}
