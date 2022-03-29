
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
import javafx.scene.layout.TilePane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class HelpController implements Initializable {
private Button btnHomeHelp, btnViewOrderHelp, btnLogOutHelp;  
    

        //Tool Bar  
         @FXML
         private void handleHomeHelp() throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLOrder.fxml"));   //Order Page acting as Homepage  
    
         Stage homeConfirmation = (Stage) btnHomeHelp.getScene().getWindow();
         homeConfirmation.setScene(new Scene(root, 713,400));
        }
      
         @FXML
         private void handleViewOrderHelp () throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLOrder.fxml"));   // Change to Past Order Page   
    
         Stage viewOrdersHelp = (Stage) btnViewOrderHelp.getScene().getWindow();
         viewOrdersHelp.setScene(new Scene(root, 713,400)); //Change dimensions to fit
         }
     
         @FXML
         private void handleLogOutHelp() throws IOException {
         TilePane tpLogout = new TilePane(); 
         Label lblLogout = new Label("You have logged out");
         Popup Logout = new Popup();
          
         tpLogout.getChildren().add(btnLogOutHelp); 
        
         Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));   
    
         Stage logoutHelp = (Stage) btnLogOutHelp.getScene().getWindow();
         logoutHelp.setScene(new Scene(root, 713,400)); //Change dimensions to fit
         }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
