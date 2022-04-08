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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;


public class RegisterDetailsController implements Initializable {

   //Register Details Fields Section
    @FXML
    private Button btnCreateAccount, btnDetailsBack;
    
    @FXML
    private TextField txtName, txtAddress1, txtAddress2, txtCCNumber, txtPhoneNumber, txtAllergies,txtUsername;
 
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    public ComboBox cboAllergies; 
         
   CustomerDao customerDao = new CustomerDao();
    
   
    //Back button 
    @FXML
    private void handleDetailsBack() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    
    Stage back = (Stage) btnDetailsBack.getScene().getWindow();
    back.setScene(new Scene(root, 600,316));
    }
  
    //Create Account button  
    @FXML 
    public void handleCreateAccount() throws IOException, SQLException{   
    
        //Validation for entering details        
        Window owner = btnCreateAccount.getScene().getWindow();

        System.out.println(txtName.getText());
        System.out.println(txtAddress1.getText());
        System.out.println(txtAddress2.getText());
        if (txtName.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your name");
            return;
        }
        if (txtAddress1.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your address");
            return;
        }
          if (txtAddress2.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your address");
            return;
        }
            if (txtCCNumber.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your credit card number");
            return;
        }
              if (txtPhoneNumber.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your phone number");
            return;
        }
              if (txtUsername.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a username");
            return;
        }
        if (txtPassword.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
            return;
        }
        
        String name = txtName.getText();
        String addressline1 = txtAddress1.getText();
        String addressline2 = txtAddress2.getText();
        String creditcardno = txtCCNumber.getText();
        String phoneno = txtPhoneNumber.getText();
        String allergies = txtAllergies.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
                
        CustomerDao.insertRecord(name, addressline1, addressline2, creditcardno, phoneno, allergies, username, password);          
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

