/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PetTherapy;

import Business.WorkQueue.PetQueue;

/**
 *
 * @author Varakumar
 */
public class PetParent {
    
    int id;
    int count =1;
    
    String Id;
    
    
    String employeename;
    String email;
    String phone;
    String address;
    String city;
    String country;
    String zipcode;
    PetQueue petqueue;
    
    PetParent(){
        
        petqueue = new PetQueue();
        
    }
    
    public PetQueue getPetQueue(){
        
        return petqueue;
    }
    
    public void setPetQueue(PetQueue petqueue){
        
        this.petqueue=petqueue;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    
}
