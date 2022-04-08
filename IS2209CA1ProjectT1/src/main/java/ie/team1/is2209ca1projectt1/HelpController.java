
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
private Button btnHome;  
    
        //Home Button
         @FXML
         private void handleHomeHelp() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerMenu.fxml")); 
    
    
        Stage homeConfirmation = (Stage) btnHome.getScene().getWindow();
        homeConfirmation.setScene(new Scene(root, 607 ,282));
        }
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
