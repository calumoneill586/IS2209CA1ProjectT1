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

            String sql = "SELECT * FROM ORDERS";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID");
                int customerid = rs.getInt("CUSTOMERID");
                
                String paymethod = rs.getString("PAYMETHOD");
                String getmethod = rs.getString("GETMETHOD");
                String request = rs.getString("REQUEST");
                
                //double price = rs.getInt("PRICE");
                
                Order order = new Order(id, customerid, paymethod, getmethod, request);
                orders.add(order);
                 }
            
       
            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

        return orders;
    }
           
    
        
     //   return orderToAdd;
    }

  


  

