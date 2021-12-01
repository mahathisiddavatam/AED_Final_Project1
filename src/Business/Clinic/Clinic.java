/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Clinic;

/**
 *
 * @author harold
 */
public class Clinic {
    int id;
    int count =1;
    //name, email, phone, address, city, country, zipcode
    String username;
    String password;
    String employeename;
    String email;
    String phone;
    String address;
    String city;
    String country;
    int zipcode;
    ClinicAdmin clinicadmin;

    public ClinicAdmin getClinicadmin() {
        return clinicadmin;
    }

    public void setClinicadmin(ClinicAdmin clinicadmin) {
        this.clinicadmin = clinicadmin;
    }
    
    
    
    public Clinic(){
        
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setName(String name) {
        this.employeename = name;
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

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
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
    
}
