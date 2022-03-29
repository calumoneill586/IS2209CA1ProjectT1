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


public class RegisterDetailsController implements Initializable {

   //Register Details Methods Section
    @FXML
    private Button btnCreateAccount, btnDetailsBack;
    
    //Back button 
    @FXML
    private void handleDetailsBack() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    
    Stage back = (Stage) btnDetailsBack.getScene().getWindow();
    back.setScene(new Scene(root, 600,316));
    }
   
    //Create Account button 
    @FXML 
    public void handleCreateAccount() throws IOException{   
        
    Parent root = FXMLLoader.load(getClass().getResource("BrowseMenu.fxml"));
    
    Stage order = (Stage) btnCreateAccount.getScene().getWindow();
    order.setScene(new Scene(root, 713,400));
    
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

