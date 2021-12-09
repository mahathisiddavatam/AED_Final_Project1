/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Random;

/**
 *
 * @author Varakumar
 */
public class YogaAppointment {
    
    int id;
    String yogaid;
    Boolean payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYogaid() {
        return yogaid;
    }

    public void setYogaid(String yogaid) {
        this.yogaid = yogaid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public Boolean getTerminate() {
        return terminate;
    }

    public void setTerminate(Boolean terminate) {
        this.terminate = terminate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    String studentid;
    Boolean terminate;
    String date;
    String time;
    
    public YogaAppointment(){
        
        Random rand = new Random();
        int random = rand.nextInt(12345);
        
        id=random;
        terminate=false;
        payment=false;
        
        
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }
    
    
}
