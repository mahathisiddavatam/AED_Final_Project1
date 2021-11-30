/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class TherapyQueue {
    
    private ArrayList<Therapy> workRequestList;

    public TherapyQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<Therapy> getWorkRequestList() {
        return workRequestList;
    }
}