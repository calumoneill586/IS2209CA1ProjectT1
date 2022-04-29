/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Daram
 */
public class StaffDao {
     private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    
    public StaffDao() {
        
     try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection(connectionString, "username", "password");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShopDao.class.getName()).log(Level.SEVERE, "can't load driver", ex);
        }   catch (SQLException ex) {
                Logger.getLogger(ShopDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public ObservableList<Staff> getStaff() {

        //List<Shop> shops = new ArrayList<Shop>();
         ObservableList<Staff>staffs =  FXCollections.observableArrayList();
        try {

            Statement stmt = conn.createStatement();



            String sql = "SELECT * FROM STAFF";


            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID");
                
               int ShopId = rs.getInt("SHOPID");
              

                  
                String StaffRole = rs.getString("STAFFROLE");
               
                
                //double price = rs.getInt("PRICE");
                
                Staff staff = new Staff( id, ShopId, StaffRole);
                staffs.add(staff);
                
                //Order order = new Order( orderid, customerid, paymethod, getmethod, request);
               // orders.add(order);

                 }
            
       
            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

        return staffs;
    }
           
    
        
    
    }



