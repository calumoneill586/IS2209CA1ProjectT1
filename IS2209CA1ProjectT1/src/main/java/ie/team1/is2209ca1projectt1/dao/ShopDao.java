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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author cdola
 */
public class ShopDao {
    private Connection conn;
    private String connectionString = "jdbc:derby://localhost:1527/pizzadatabase";
    
    public ShopDao() {
        
     try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection(connectionString, "username", "password");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShopDao.class.getName()).log(Level.SEVERE, "can't load driver", ex);
        }   catch (SQLException ex) {
                Logger.getLogger(ShopDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public List<Shop> getShop() {

        //List<Shop> shops = new ArrayList<Shop>();
         ObservableList<Shop>shops =  FXCollections.observableArrayList();
        try {

            Statement stmt = conn.createStatement();



            String sql = "SELECT ID, LOCATION FROM SHOP";


            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("ID");
                
              
              

                  
                String location = rs.getString("LOCATION");
               
                
                //double price = rs.getInt("PRICE");
                
                Shop shop = new Shop(id, location);
                shops.add(shop);

                 }
            
       
            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

        return shops;
    }
           
    
        
    
    }

