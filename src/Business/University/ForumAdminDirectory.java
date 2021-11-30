/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.University;


import java.util.ArrayList;

/**
 *
 * @author Varakumar
 */
public class ForumAdminDirectory {
    
    private ArrayList<ForumAdmin> forumadminlist;
    
    public void ForumAdminDirectory() {
        forumadminlist = new ArrayList();
        
        
    }

    public ArrayList<ForumAdmin> getforumadminlist() {
        return forumadminlist;
    }

   

    public ForumAdmin AddForumAdmin(){
        
        ForumAdmin forumadmin = new ForumAdmin();
        forumadminlist.add(forumadmin);
        return forumadmin;
    }
    
    public boolean DeleteForumAdmin(int id){
         for(ForumAdmin forumadmin: forumadminlist){
             if(id==forumadmin.getId()){
                 forumadminlist.remove(forumadmin);
                 return true;
             }
             
         }
         return false;
    }
    
    public ForumAdmin RetrieveForumAdmin(int id){
        
        for(ForumAdmin forumadmin: forumadminlist){
            
            if(id==forumadmin.getId()){
                
                return forumadmin;
            }
        }
        return null;
    
}
    
}
