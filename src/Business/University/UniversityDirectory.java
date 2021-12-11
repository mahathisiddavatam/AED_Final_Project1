/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.University;

import Business.WorkQueue.AccessRequestQueue;
import Business.WorkQueue.ForumQueue;
import Business.WorkQueue.EventQueue;
import Business.WorkQueue.RegistrationRequestWorkQueue;
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
    private ForumQueue articlequeue;
    private EventQueue eventqueue;
    private AccessRequestQueue reqaccessq;
    private RegistrationRequestWorkQueue registrationrequestworkqueue;
    
    
    

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
        articlequeue = new ForumQueue();
        eventqueue = new EventQueue();
        reqaccessq = new AccessRequestQueue();
        registrationrequestworkqueue = new RegistrationRequestWorkQueue();
    }

    public RegistrationRequestWorkQueue getRegistrationrequestworkqueue() {
        return registrationrequestworkqueue;
    }

    public void setRegistrationrequestworkqueue(RegistrationRequestWorkQueue registrationrequestworkqueue) {
        this.registrationrequestworkqueue = registrationrequestworkqueue;
    }

    public ForumQueue getForumqueue() {
        return articlequeue;
    }

    public void setForumqueue(ForumQueue articlequeue) {
        this.articlequeue = articlequeue;
    }
    
    

    public EventQueue getEventqueue() {
        return eventqueue;
    }

    public void setEventqueue(EventQueue eventqueue) {
        this.eventqueue = eventqueue;
    }

    public AccessRequestQueue getReqaccessq() {
        return reqaccessq;
    }

    public void setReqaccessq(AccessRequestQueue reqaccessq) {
        this.reqaccessq = reqaccessq;
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
    

