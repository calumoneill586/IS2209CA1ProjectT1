package ie.team1.is2209ca1projectt1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Window;


public class StaffLoginController implements Initializable {

//Login Methods Section
    @FXML
    private Button btnStaffLogIn;   
    @FXML
    private PasswordField txtStaffPassword;  
    
    //Log In Button  
    @FXML
    private void handleLogIn() throws IOException { //This section validates password entry
    Window owner = btnStaffLogIn.getScene().getWindow();
    
     
        System.out.println(txtStaffPassword.getText());
           
        if (txtStaffPassword.getText().isEmpty()) {
          showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
              "Please enter the password");
          return;
        }
        
        String password = txtStaffPassword.getText();
               
           if (!"password".equals(password)) {
            infoBox("Please enter correct Password", null, "Failed");
        } else {
            infoBox("Login Successful!", null, "Success");
            Parent root = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
    
            Stage login = (Stage) btnStaffLogIn.getScene().getWindow();
            login.setScene(new Scene(root, 607,282));
    }
            
        }
        
        public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    } 
        private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
} 
        
