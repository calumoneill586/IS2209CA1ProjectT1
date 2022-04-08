/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
//120463034
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CustomerDao2 {
        private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    
    
    public List<Customer> getCustomers() {
 ObservableList<Customer>customers =  FXCollections.observableArrayList();
        //List<Customer>customers = new ArrayList<Customer>();
        
        try {

            Statement stmt = conn.createStatement(); 
            //name, addressline1, addressline2, creditcardno, phoneno, allergies, username, password

            String sql = "SELECT PASSWORD, USERNAME, NAME, ADRESSLINE1, ADDRESSLINE2, CREDITCARDNO, PHONENO, ALLERGIES FROM CUSTOMER";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String password = rs.getString("PASSWORD");
                String username = rs.getString("USERNAME"); 
                String name = rs.getString("NAME"); 
                String addressline1 = rs.getString("ADDRESSLINE1"); 
                String addressline2 = rs.getString("ADDRESSLINE2"); 
                String creditcardno = rs.getString("CREDITCARDNO"); 
                String phoneno = rs.getString("PHONENO"); 
                String allergies = rs.getString("ALLERGIES");
                
            

                Customer customer = new Customer(password, username, name, addressline1, addressline2, creditcardno, phoneno, allergies );
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

      
   
    
        
 

