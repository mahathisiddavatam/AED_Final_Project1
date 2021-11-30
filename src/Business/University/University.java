/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.University;

/**
 *
 * @author harold
 */
public class University {
    
    int id;
    int count =1;
    
    public University(){
        
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }
    
}
