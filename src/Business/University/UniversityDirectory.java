/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.University;

import Business.WorkQueue.ArticleQueue;
import Business.WorkQueue.EventQueue;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class UniversityDirectory {
    
    
    private ArrayList<University> unilist;
    private StudentDirectory studentdir;
    private VolunteerDirectory volunteerdir;
    private ForumAdminDirectory forumdir;
    private ArticleQueue articlequeue;
    private EventQueue eventqueue;
    
    
    

    public ArrayList<University> getUnilist() {
        return unilist;
    }

    public StudentDirectory getStudentdir() {
        return studentdir;
    }

    public VolunteerDirectory getVolunteerdir() {
        return volunteerdir;
    }

    public ForumAdminDirectory getForumdir() {
        return forumdir;
    }

    public UniversityDirectory() {
        unilist = new ArrayList();
        studentdir = new StudentDirectory();
        volunteerdir = new VolunteerDirectory();
        forumdir = new ForumAdminDirectory();
        articlequeue = new ArticleQueue();
        eventqueue = new EventQueue();
    }

    public ArticleQueue getArticlequeue() {
        return articlequeue;
    }

    public void setArticlequeue(ArticleQueue articlequeue) {
        this.articlequeue = articlequeue;
    }

    public EventQueue getEventqueue() {
        return eventqueue;
    }

    public void setEventqueue(EventQueue eventqueue) {
        this.eventqueue = eventqueue;
    }

    public University addNewUniversity(){
        
        University uni = new University();
        unilist.add(uni);
        return uni;
    }
    
    public boolean deleteUniversity(String id){
         for(University uni: unilist){
             if(id.equals(uni.getId())){
                 unilist.remove(uni);
                 return true;
             }
             
         }
         return false;
    }

    public void setUnilist(ArrayList<University> unilist) {
        this.unilist = unilist;
    }
    
    public University RetrieveUniversity(String id){
        
        for(University uni: unilist){
            
            if(id.equals(uni.getId())){
                
                return uni;
            }
        }
        return null;
        
        
    }
    
    
}
    

