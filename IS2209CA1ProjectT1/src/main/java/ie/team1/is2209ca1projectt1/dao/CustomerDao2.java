
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


public class CustomerDao2 {
    private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    private Label lblNumber;
    
    public CustomerDao2() {
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(connectionString, "username", "password");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, "can't load driver", ex);
        }   catch (SQLException ex) {
                Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public ObservableList<Customer> getCustomers() {


      // List<Order>orders = new ArrayList<Order>();
            ObservableList<Customer>customers =  FXCollections.observableArrayList();
            
 
          //  orders.add(new Order(1,2, "sds", "uhg", "hghg"));

            

       // List<Order> orders = new ArrayList<Order>();
        


        try {

          Statement stmt = conn.createStatement(); 
            //name, addressline1, addressline2, creditcardno, phoneno, allergies, username, password

            String sql = "SELECT * FROM CUSTOMER";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID");
                String name = rs.getString("NAME"); 
                String addressline1 = rs.getString("ADDRESSLINE1"); 
                String addressline2 = rs.getString("ADDRESSLINE2"); 
               String creditcardno = rs.getString("CREDITCARDNO"); 
                String phoneno = rs.getString("PHONENO"); 
                String allergies = rs.getString("ALLERGIES");
                String username = rs.getString("USERNAME");
                 String password = rs.getString("PASSWORD");
                
            

                Customer customer = new Customer( id, name, addressline1,addressline2, creditcardno, phoneno, allergies, username, password );
                customers.add(customer); 
                
            }

            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println("something went wrong with select from customer");
        }
        return customers;
    }
}

    
   
       /*     String orderNumber = rs.toString();
            lblNumber.setText(String.valueOf(orderNumber)); 
         
            return orderNumber ;*/  
        
     //   return orderToAdd;
    


  


  

      
   
    
        
 

