
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
import javafx.stage.Stage;

public class HelpController implements Initializable {
    @FXML
    private Button btnHome;  
   
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
}
    
     //Home Button
        public void onHome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerMenu.fxml"));
    
        Stage homeHelp = (Stage) btnHome.getScene().getWindow();
        homeHelp.setScene(new Scene(root, 607,282));
    } 
}  
