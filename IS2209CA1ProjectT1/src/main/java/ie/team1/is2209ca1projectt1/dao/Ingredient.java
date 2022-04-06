/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1.dao;

import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Ingredient {
    private int id;
    private String name;


    
    
    public Ingredient() {
        
    }

    public Ingredient(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }

  

  
  
    
}

