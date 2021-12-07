/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raunak
 */
public class Therapy {

    int id;
    int count=1;
    String studentid;
    String therapistid;
    String ques11;
    String ques12;
    String ques13;
    String ques14;
    String ques15;
    Boolean terminate=false;
    String date;
    String time;
    Boolean payment=false;
    
    

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
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

    public Boolean getTerminate() {
        return terminate;
    }

    public void setTerminate(Boolean terminate) {
        this.terminate = terminate;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getTherapistid() {
        return therapistid;
    }

    public void setTherapistid(String therapistid) {
        this.therapistid = therapistid;
    }

    public String getQues11() {
        return ques11;
    }

    public void setQues11(String ques11) {
        this.ques11 = ques11;
    }

    public String getQues12() {
        return ques12;
    }

    public void setQues12(String ques12) {
        this.ques12 = ques12;
    }

    public String getQues13() {
        return ques13;
    }

    public void setQues13(String ques13) {
        this.ques13 = ques13;
    }

    public String getQues14() {
        return ques14;
    }

    public void setQues14(String ques14) {
        this.ques14 = ques14;
    }

    public String getQues15() {
        return ques15;
    }

    public void setQues15(String ques15) {
        this.ques15 = ques15;
    }
    
    public void Therapy(){
        
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
