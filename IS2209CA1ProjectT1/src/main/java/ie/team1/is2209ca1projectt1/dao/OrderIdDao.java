/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1.dao;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author admin
 */
    public class OrderIdDao {
        private Connection conn;
        private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    
    public OrderIdDao () {
            
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver"); conn = DriverManager.getConnection(connectionString, "username", "password");
            
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PizzaDao.class.getName()).log(Level.SEVERE, "can't load driver", ex);
        }   catch (SQLException ex) {
                Logger.getLogger(PizzaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
        
        public OrderId addSelectedPizza(OrderId selectedPizzaToAdd) {
        
        try {

            Statement stmt = conn.createStatement();
            
            String sql = "INSERT INTO orderitem (selectedItem) VALUES('" + selectedPizzaToAdd.getPizzaid() + "', " + selectedPizzaToAdd.getOrderid()+ "', " + selectedPizzaToAdd.getQuantity() + ")";
            
            System.out.println(sql);
            
            stmt.executeUpdate(sql);
            
            stmt.close();
            
        } catch(Exception ex) {
            System.out.println("something went wrong...");
            System.out.println(ex.getMessage());
        }
        
        return selectedPizzaToAdd;
    }
        
        
    }

    
