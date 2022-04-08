
package ie.team1.is2209ca1projectt1;

import ie.team1.is2209ca1projectt1.dao.CustomerDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;


public class LoginController implements Initializable {

//Login Methods Section
    @FXML
    private Button btnLogIn, btnCreateAccount;   
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;  
    
    //Log In Button  
    //Validation code adapted from: https://www.javaguides.net/2019/07/login-form-using-javafx-with-mysql-database.html 
    @FXML
    private void handleLogIn() throws IOException, SQLException { //This section validates username/password entry
    Window owner = btnLogIn.getScene().getWindow();
    
        System.out.println(txtUsername.getText());
        System.out.println(txtPassword.getText());
        
    
        if (txtUsername.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your username");
            return;
        }   
        if (txtPassword.getText().isEmpty()) {
          showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
              "Please enter your password");
          return;
        }
        
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        CustomerDao loginDao = new CustomerDao();
        boolean flag = loginDao.validate(username, password); //validate will go into DAO
        
           if (!flag) {
            infoBox("Please enter correct Username and Password", null, "Failed");
        } else {
            infoBox("Login Successful!", null, "Success");
            Parent root = FXMLLoader.load(getClass().getResource("CustomerMenu.fxml"));
    
            Stage login = (Stage) btnLogIn.getScene().getWindow();
            login.setScene(new Scene(root, 607,282));
    }
            
        }
    
        //Click Here Hyperlink
        @FXML
        private void handleClickHere() throws IOException { 
        Parent root = FXMLLoader.load(getClass().getResource("RegisterDetails.fxml"));

        Stage clickHere = (Stage) btnCreateAccount.getScene().getWindow();
        clickHere.setScene(new Scene(root, 681,597));
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
        

    
 
    
    
  
 

    

