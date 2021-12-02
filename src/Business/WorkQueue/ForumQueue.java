/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Varakumar
 */
public class ForumQueue {
    
    private ArrayList<Forum> forumlist;

    public ForumQueue() {
        forumlist = new ArrayList();
    }

    public ArrayList<Forum> getForumlist() {
        return forumlist;
    }

    public void setForumlist(ArrayList<Forum> forumlist) {
        this.forumlist = forumlist;
    }
    
    public Forum addForum(){
        
        Forum forum = new Forum();
        forumlist.add(forum);
        return forum;
        
    }
    
    public Forum retrieveForum(int id){
        
        for(Forum forum: forumlist){
            
            if(forum.getId()==id){
                return forum;
            }
        }
        return null;
        
        
    }
    
    public boolean deleteForum(int id){
        
        Forum forum = retrieveForum(id);
        if(forum==null){
            
            return false;
        }
        forumlist.remove(forum);
        return true;
        
        
        
    }

    
}
