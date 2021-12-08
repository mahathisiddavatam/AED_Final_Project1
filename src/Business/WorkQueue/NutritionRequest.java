/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Varakumar
 */
public class NutritionRequest {
    
    int id;
    String studentid;
    String yogaid;
    boolean accept=false;
    boolean reject = false;
    Date date;
    
    NutritionRequest(){
        
        Random rand = new Random();
        int random = rand.nextInt(12345);
        id = random;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getYogaid() {
        return yogaid;
    }

    public void setYogaid(String yogaid) {
        this.yogaid = yogaid;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public boolean isReject() {
        return reject;
    }

    public void setReject(boolean reject) {
        this.reject = reject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
