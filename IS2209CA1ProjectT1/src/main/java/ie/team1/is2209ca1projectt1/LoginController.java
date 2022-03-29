
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
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;


public class LoginController implements Initializable {

//Login Methods Section
    @FXML
    private Button btnLogIn, btnCreateAccount;
    private Hyperlink hypCreateAccount;    
    
    //Log In Button       
    @FXML
    private void handleLogIn() throws IOException { //CODE TO VERIFY INPUT AGAINST DATABASE HERE!!
    Parent root = FXMLLoader.load(getClass().getResource("BrowseMenu.fxml"));
    
    Stage login = (Stage) btnLogIn.getScene().getWindow();
    login.setScene(new Scene(root, 713,400));
    }
    
    //Click Here Hyperlink
    @FXML
    private void handleClickHere() throws IOException { 
    Parent root = FXMLLoader.load(getClass().getResource("RegisterDetails.fxml"));
    
    Stage clickHere = (Stage) btnCreateAccount.getScene().getWindow();
    clickHere.setScene(new Scene(root, 681,597));
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
