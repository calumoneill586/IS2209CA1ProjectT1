/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1.dao;

public class Order {
    private int id;
    private int customerid;
    private String paymethod;
    private String getmethod;
    private String request;
    

    public Order(int id, int customerid, String paymethod, String getmethod, String request) { //change data types to fit 
        this.id = id;
        this.customerid = customerid;
        this.paymethod = paymethod;
        this.getmethod = getmethod;
        this.request = request;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerid;
    }

    public void setCustomerId(int customerid) {
        this.customerid = customerid;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }
    
     public String getgetmethod() {
        return getmethod;
    }

    public void setgetmethod(String getmethod) {
        this.getmethod = getmethod;
    }
    
    
    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

   
        
        
    
    
   
  
   @Override
    public String toString() {
     return this.paymethod +" "+ this.getmethod +" "+ this.request;
        
        
       
        }
     
 
        }
        
    
   
    

    

