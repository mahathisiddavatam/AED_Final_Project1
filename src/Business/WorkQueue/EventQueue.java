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
public class EventQueue {
    
    private ArrayList<Event> eventlist;

    public EventQueue() {
        eventlist = new ArrayList();
    }

    public ArrayList<Event> getEventlist() {
        return eventlist;
    }

    public void setEventlist(ArrayList<Event> eventlist) {
        this.eventlist = eventlist;
    }
    
    public Event addEvent(){
        
        Event event = new Event();
        eventlist.add(event);
        return event;
        
    }
    
    public Event retrieveEvent(int id){
        
        for(Event event: eventlist){
            
            if(event.getId()==id){
                return event;
            }
        }
        return null;
        
        
    }
    
    public boolean deleteEvent(int id){
        
        Event event = retrieveEvent(id);
        if(event==null){
            
            return false;
        }
        eventlist.remove(event);
        return true;
        
        
        
    }
    
}
