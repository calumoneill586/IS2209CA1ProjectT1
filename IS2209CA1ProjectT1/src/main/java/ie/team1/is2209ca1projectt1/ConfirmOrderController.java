package ie.team1.is2209ca1projectt1;

import ie.team1.is2209ca1projectt1.dao.Order;
import ie.team1.is2209ca1projectt1.dao.OrderDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.SelectionMode;


public class ConfirmOrderController implements Initializable {
   
    //Confirmation Page Methods Section
    @FXML
    private Button btnViewOrders, btnHelpConfirmation, btnHomeConfirmation;
    
    @FXML
    private Label lblNumber;
    private Connection conn;
    private ListView lstNumber;
    
    OrderDao dao = new OrderDao();
    
    //Tool Bar
    
    @FXML
    private void handleHomeConfirmation() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("BrowseMenu.fxml")); 
    
    
    Stage homeConfirmation = (Stage) btnHomeConfirmation.getScene().getWindow();
    homeConfirmation.setScene(new Scene(root, 713,400));
    }
      
    @FXML
    private void handleViewOrderConfirmation() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("PastOrders.fxml")); 
    
    
    Stage viewOrdersConfirmation = (Stage) btnViewOrders.getScene().getWindow();
    viewOrdersConfirmation.setScene(new Scene(root, 713,400)); //Change dimensions to fit
    }
     
    @FXML
    private void handleHelpConfirmation() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Help.fxml")); 
    
    
    Stage viewHelp = (Stage) btnHelpConfirmation.getScene().getWindow();
    viewHelp.setScene(new Scene(root, 306, 328)); 
    }

  /*  @FXML
    private void getOrderNumber() {
        
         List<Order>orders = new ArrayList<Order>();
         
         try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT ORDERID FROM ORDERS ORDER BY ID DESC LIMIT 1;"; //Order by found online at:https://www.tutorialspoint.com/get-the-last-record-from-a-table-in-mysql-database-with-java
            ResultSet rs = stmt.executeQuery(sql);
                       
            if (lblNumber.getText().isEmpty()) {
                int orderno = rs.getInt("ID");
                int customerid = rs.getInt("CustomerID");
                String paymethod = rs.getString("PAYMETHOD");
                String getmethod = rs.getString("GETMETHOD");
                String request = rs.getString("REQUEST");
               
                Order order = new Order(orderno, customerid, paymethod, getmethod, request);
                orders.add(order);
            }
            rs.close();
            stmt.close();
        } catch(Exception ex) {
            System.out.println("something went wrong with select from pizza");
        }  
    }  */
 
       
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
        }
 
    }

