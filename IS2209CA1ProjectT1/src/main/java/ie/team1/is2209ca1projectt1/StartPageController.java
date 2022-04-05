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


public class StartPageController implements Initializable {
    //Button for moving to Login Page
    @FXML
    private Button btnStart, btnStaffLogin;
 
    @FXML
    private void handleGetStarted() throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Stage getStarted = (Stage) btnStart.getScene().getWindow();
        getStarted.setScene(new Scene(root, 602,299));
    }
    
    @FXML
    private void handleStaffLogin() throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("StaffLogin.fxml"));

        Stage getStarted = (Stage) btnStaffLogin.getScene().getWindow();
        getStarted.setScene(new Scene(root, 320,299));
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    
    
}
