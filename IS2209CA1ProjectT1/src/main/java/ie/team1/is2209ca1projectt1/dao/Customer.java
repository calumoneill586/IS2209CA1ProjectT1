/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1.dao;

/**
 *
 * @author Orla
 */
public class Customer {
 private String name, addressline1, addressline2, creditcardno, phoneno, allergies, username, password;

    public Customer(String name, String addressline1, String addressline2, String creditcardno, String phoneno, String allergies, String username, String password ) {
        this.name = name;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.creditcardno = creditcardno;
        this.phoneno = phoneno;
        this.allergies = allergies;
        this.username = username;
        this.password = password;
        
    }
       
    
    String getName() {
       return name;
    }
     
    public void setName(String name) {
        this.name = name;
    }

    String getAddressLine1() {
        return addressline1;
    }
     
    public void setAddressLine1 (String addressline1) {
        this.addressline1 = addressline1;
    }

    String getAddressLine2() {
       return addressline2;
    }
    public void setAddresLine2 (String addressline2) {
        this.addressline2 = addressline2;
    }
   
    String getCreditCardNo() {
       return creditcardno;
    }

    public void setCreditCardNo (String creditcardno) {
        this.creditcardno = creditcardno;
    }
    
    String getPhoneNo() {
       return phoneno;
    }
    
    public void setPhoneNo (String phoneno) {
        this.phoneno = phoneno;
    }

    String getAllergies() {
      return allergies;
    }

    public void setAllergies (String allergies) {
        this.allergies = allergies;
    }
    
    String getUsername() {
      return username;
    }
    
    public void setUsername (String username) {
        this.username = username;
    }
 
    String getPassword() {
      return password;
    }
    
    public void setPassword (String password) {
        this.password = password;
    }
    
}


