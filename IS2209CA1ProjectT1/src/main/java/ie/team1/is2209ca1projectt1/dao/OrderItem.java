/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1.dao;

/**
 *
 * @author admin
 */
public class OrderItem {
    private int id;
    private int orderid;
    private int pizzaid;
    public int quantity;
    private String pizzaName;
    
    public OrderItem() {
        
    }
    
    public OrderItem(int pizzaid, String pizzaName, int quantity) {
        this.pizzaid = pizzaid;
        this.quantity = quantity;
        this.pizzaName = pizzaName;
    }

    public OrderItem(int id, int orderid, int pizzaid, int quantity) {
        this.id = id;
        this.orderid = orderid;
        this.pizzaid = pizzaid;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getPizzaid() {
        return pizzaid;
    }

    public void setPizzaid(int pizzaid) {
        this.pizzaid = pizzaid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "" + pizzaName + " x " + quantity;
    }

    
    
}
