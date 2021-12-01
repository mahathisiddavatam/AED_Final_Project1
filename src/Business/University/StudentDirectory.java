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
public class StudentDirectory {
    
    private ArrayList<Student> studentlist;
    
    public void StudentDirectory() {
        studentlist = new ArrayList();
        
        
    }

    public ArrayList<Student> getstudentlist() {
        return studentlist;
    }

    public void setStudentlist(ArrayList<Student> studentlist) {
        this.studentlist = studentlist;
    }

   

    public Student AddStudent(){
       
        Student student = new Student();
        studentlist.add(student);
        return student;
    }
    
    public boolean DeleteStudent(String id){
         for(Student student: studentlist){
             if(id.equals(student.getId())){
                 studentlist.remove(student);
                 return true;
             }
             
         }
         return false;
    }
    
    public Student RetrieveStudent(String id){
        
        for(Student student: studentlist){
            
            if(id.equals(student.getId())){
                
                return student;
            }
        }
        return null;
    
}
    
}
