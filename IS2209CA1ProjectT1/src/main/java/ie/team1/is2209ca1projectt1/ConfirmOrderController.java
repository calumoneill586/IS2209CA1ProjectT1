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
    
    //Tool Bar
    
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
    viewHelp.setScene(new Scene(root, 306, 328)); //Change dimensions to fit 
    }
       
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
 
}
