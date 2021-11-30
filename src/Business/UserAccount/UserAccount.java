/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.MindFitness.MindFitness;
import Business.Role.Role;
import Business.WorkQueue.TherapyQueue;

/**
 *
 * @author raunak
 */
public class UserAccount {
    
    private String username;
    private String password;
    //private MindFitness employee;
    private Role role;
    private TherapyQueue workQueue;

    public UserAccount() {
        workQueue = new TherapyQueue();
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    

    public void setRole(Role role) {
        this.role = role;
    }

    

    public TherapyQueue getWorkQueue() {
        return workQueue;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}