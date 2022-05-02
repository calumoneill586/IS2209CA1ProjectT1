/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1.dao;

public class Order {
    private int orderid;
    private int customerid;
    private String paymethod;
    private String getmethod;
    private String request;
    

    public Order(int orderid, int customerid, String paymethod, String getmethod, String request) { //change data types to fit 
        this.orderid = orderid;
        this.customerid = customerid;
        this.paymethod = paymethod;
        this.getmethod = getmethod;
        this.request = request;
    }

    public int getId () {
        return orderid;
    }

    public void setId(int orderid) {
        this.orderid = orderid;
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
    
     public String getGetmethod() {
        return getmethod;
    }

    public void setGetmethod(String getmethod) {
        this.getmethod = getmethod;
    }
    
    
    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

   public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

        
        
    
    
   
  
   //@Override
    //public String toString() {
     //return this.orderid;
        
        
       
        
     
 
      //  }

    @Override
    public String toString() {
        return "Order{" + "orderid=" + orderid + ", customerid=" + customerid + ", paymethod=" + paymethod + ", getmethod=" + getmethod + ", request=" + request + '}';
    }
}
        
    
   
    

    

