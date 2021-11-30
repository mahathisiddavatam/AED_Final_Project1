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

   

    public Student AddStudent(){
        
        Student student = new Student();
        studentlist.add(student);
        return student;
    }
    
    public boolean DeleteStudent(int id){
         for(Student student: studentlist){
             if(id==student.getId()){
                 studentlist.remove(student);
                 return true;
             }
             
         }
         return false;
    }
    
    public Student RetrieveStudent(int id){
        
        for(Student student: studentlist){
            
            if(id==student.getId()){
                
                return student;
            }
        }
        return null;
    
}
    
}
