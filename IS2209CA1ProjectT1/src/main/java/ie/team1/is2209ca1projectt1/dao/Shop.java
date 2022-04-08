/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1.dao;

/**
 *
 * @author 120463034
 */
public class Shop {
    
    private int id;
    private String location;
    ;
    

    public Shop(int id, String location) { //change data types to fit 
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setCustomerId(String location) {
        this.location = location;
    }

   
        
        
    
    
   
  
   @Override
    public String toString() {
     return this.id +" "+ this.location;
        
        
       
        }
     
 
        }
        
    
   
    

