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
public class Pizza {
    private int id;
    private String name;
    public double price;
    
    public Pizza() {
        
    }

    public Pizza(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Pizza(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String type) {
        this.name = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
  
    @Override
    public String toString() {
        return name;
        
    }
    
    
}
