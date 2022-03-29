/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderDao {
    private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    
    public OrderDao() {
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(connectionString, "username", "password");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, "can't load driver", ex);
        }   catch (SQLException ex) {
                Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public List<Order> getOrders() {

        List<Order>orders = new ArrayList<Order>();
        
        try {

            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM order";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID");
                String name = rs.getString("TYPE");
                double price = rs.getInt("PRICE");
              
              //  Order order = new Order(X, Y, Z);     ADD IN DATA TYPES
             //   orders.add(order);
                 }
            
       
            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println("something went wrong...");
        }

        return orders;
    }
           
    public Order addOrder(Order orderToAdd) {
        
        try {

            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO order (TYPE, PRICE) VALUES('" + orderToAdd.getType() + "', " + orderToAdd.getPrice() + ")";
            
            System.out.println(sql);
            
            stmt.executeUpdate(sql);
            
            stmt.close();
            
        } catch(Exception ex) {
            System.out.println("something went wrong...");
            System.out.println(ex.getMessage());
        }
        
        return orderToAdd;
    }

  

}
  

