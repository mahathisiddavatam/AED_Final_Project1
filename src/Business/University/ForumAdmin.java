/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.University;

/**
 *
 * @author Varakumar
 */
public class ForumAdmin {
    
    int id;
    int count =1;
    
    public ForumAdmin(){
        
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }
    
}
