/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1.dao;

import java.util.logging.Logger;

/**
 *
 * @author 120463034
 */
public class Ingredient {

    public static void add(Ingredient ingredient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
      return this.id +" "+ this.name;
   
    }

  

  
  
    
}

