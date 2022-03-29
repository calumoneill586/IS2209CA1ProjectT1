package ie.team1.is2209ca1projectt1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class ConfirmOrderController implements Initializable {
    
    

    //Confirmation Page Methods Section
    @FXML
    private Button btnViewOrders, btnHelpConfirmation, btnHomeConfirmation;
    @FXML
    private Label lblOrderPlaced;
    @FXML
    private Label lblUniqueCode;
    @FXML
    private Label lblNumber;
    @FXML
    private Label lblThankYou;
    @FXML
    private MenuBar mnuConfirmation;
    @FXML
    private Menu btnViewOrderConfirmation;
    
    //Menu Bar
    
    @FXML
    private void handleHomeConfirmation() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("BrowseMenu.fxml")); 
    
    
    Stage homeConfirmation = (Stage) btnHomeConfirmation.getScene().getWindow();
    homeConfirmation.setScene(new Scene(root, 713,400));
    }
      
    @FXML
    private void handleViewOrderConfirmation() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("OrderSummary.fxml")); //Change to Past Order Page
    
    
    Stage viewOrdersConfirmation = (Stage) btnViewOrders.getScene().getWindow();
    viewOrdersConfirmation.setScene(new Scene(root, 713,400)); //Change dimensions to fit
    }
     
    @FXML
    private void handleHelpConfirmation() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Help.fxml")); //Change to Help Page
    
    
    Stage viewHelp = (Stage) btnHelpConfirmation.getScene().getWindow();
    viewHelp.setScene(new Scene(root, 713,400)); //Change dimensions to fit 
    }
    
   
    
//Help Page Methods Section
     private Button btnHomeHelp, btnViewOrderHelp, btnLogOutHelp;  
    

        //Menu Bar  
         private void handleHomeHelp() throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("BrowseMenu.fxml"));   //Order Page acting as Homepage  
    
         Stage homeConfirmation = (Stage) btnHomeHelp.getScene().getWindow();
         homeConfirmation.setScene(new Scene(root, 713,400));
        }
      
         private void handleViewOrderHelp() throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource(".fxml"));   // Change to Past Order Page   
    
         Stage viewOrdersHelp = (Stage) btnViewOrderHelp.getScene().getWindow();
         viewOrdersHelp.setScene(new Scene(root, 713,400)); //Change dimensions to fit
         }
     
         private void handleLogOutHelp() throws IOException {
         TilePane tpLogout = new TilePane(); 
         Label lblLogout = new Label("You have logged out");
         Popup Logout = new Popup();
          
         tpLogout.getChildren().add(btnLogOutHelp); 
        
         Parent root = FXMLLoader.load(getClass().getResource(".fxml"));   
    
         Stage logoutHelp = (Stage) btnLogOutHelp.getScene().getWindow();
         logoutHelp.setScene(new Scene(root, 713,400)); //Change dimensions to fit
         }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
