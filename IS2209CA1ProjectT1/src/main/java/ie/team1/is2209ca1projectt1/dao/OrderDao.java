
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;


public class OrderDao {
    private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    private static final String insert_query = "INSERT INTO orders (ID, CUSTOMERID, PAYMETHOD, GETMETHOD, REQUEST) VALUES(?,?,?,?,?,?,?,?)";
    private static final String select_query = "SELECT Id FROM customer WHERE username = ? and password = ?";
    private Label lblNumber;
    public String customerid = getId();
    
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
    
    public ObservableList<Order> getOrders() {
            ObservableList<Order>orders =  FXCollections.observableArrayList();
        
        try {

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM ORDERS";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {


                int orderid = Integer.parseInt(rs.getString("ID"));

                int customerid = Integer.parseInt(rs.getString("CUSTOMERID"));

                String paymethod = rs.getString("PAYMETHOD");
                String getmethod = rs.getString("GETMETHOD");
                String request = rs.getString("REQUEST");
                
                
                Order order = new Order( orderid, customerid, paymethod, getmethod, request);
                orders.add(order);

                 }
            
       
            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

        return orders;
    }
   
   public String getId() { 
       String ids = new String();
       
     try {/*(Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/pizzadatabase", "username", "password");*/
            Statement stmt = conn.createStatement() ;
            ResultSet rs = stmt.executeQuery(select_query);
            
            while (rs.next()) {
    
                int Id = Integer.parseInt(rs.getString("ID"));
                String name = rs.getString("NAME");
                String addressline1 = rs.getString("ADDRESSLINE1");
                String addressline2 = rs.getString("ADDRESSLINE2");
                String creditcardno = rs.getString("CREDITCARDNO");
                String phoneno = rs.getString("PHONENO");
                String allergies = rs.getString("ALLERGIES");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                
             //  Customer ids = new Customer(Id, name,addressline1,addressline2,creditcardno,phoneno,allergies,username,password);
             //  ids.add(ids);
                
            }  rs.close();
            stmt.close();
        
            } catch(Exception ex) {
            System.out.println(ex);
            }

        return ids;
   }


   
    
    
    
    public static void insertOrder(String customerid, String paymethod, String getmethod, String request) {
        
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/pizzadatabase", "username", "password");
            PreparedStatement preparedStatement = conn.prepareStatement(insert_query)) {      
       
            preparedStatement.setString(1, customerid);
            preparedStatement.setString(2, paymethod);
            preparedStatement.setString(3, getmethod);
            preparedStatement.setString(4, request);
            
            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); 

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
     }
   }

          
            
            /*  Statement stmt = conn.createStatement();

            String sqlOrdersUpdate = "INSERT INTO orders (CUSTOMERID) VALUES('" + orderToAdd.getCustomerid() + ")";
           
            
            System.out.println(sqlOrdersUpdate);
            
            stmt.executeUpdate(sqlOrdersUpdate);
            
            stmt.close();
            
        } catch(Exception ex) {
            System.out.println("something went wrong...");
            System.out.println(ex.getMessage());
        }
        
        return orderToAdd;
    }*/
   
 }



  


  

