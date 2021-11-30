/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Clinic.ClinicDirectory;
import Business.MindFitness.MindFitnessDirectory;
import Business.PetTherapy.PetTherapyDirectory;
import Business.Role.Role;
import Business.University.UniversityDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.TherapyQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organisation {

    private String name;
    //private TherapyQueue workQueue;
    private MindFitnessDirectory mindfitnessdir;
    private UniversityDirectory universitydirectory;
    private ClinicDirectory clinicdirectory;
    private PetTherapyDirectory pettherapydirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        RestaurantAdmin("RestaurantAdmin"),
        Customer("Customer"),
        DeliveryMan("Delivery"),
        SysAdmin("Sysadmin");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organisation(String name) {
        this.name = name;
        //workQueue = new TherapyQueue();
        mindfitnessdir= new MindFitnessDirectory();
        universitydirectory = new UniversityDirectory();
        pettherapydirectory = new PetTherapyDirectory();
        clinicdirectory = new ClinicDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }
    public Organisation(){
        
    }
    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public MindFitnessDirectory getMindfitnessdir() {
        return mindfitnessdir;
    }

    public UniversityDirectory getUniversitydirectory() {
        return universitydirectory;
    }

    public ClinicDirectory getClinicdirectory() {
        return clinicdirectory;
    }

    public PetTherapyDirectory getPettherapydirectory() {
        return pettherapydirectory;
    }

    
    
    public String getName() {
        return name;
    }

    

    public void setName(String name) {
        this.name = name;
    }

    

    @Override
    public String toString() {
        return name;
    }
    
    
}
