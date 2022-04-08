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


public class CustomerMenuController implements Initializable {
 @FXML
    private Button btnOrderPizza, btnPastOrders, btnHelp;
   
    @FXML
    public void onOrderPizza() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("BrowseMenu.fxml"));
    
    Stage orderPizza = (Stage) btnOrderPizza.getScene().getWindow();
    orderPizza.setScene(new Scene(root, 765,415));
    }
    
    @FXML 
    public void onViewPastOrders() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("PastOrders.fxml"));
    
    Stage viewPastOrders = (Stage) btnPastOrders.getScene().getWindow();
    viewPastOrders.setScene(new Scene(root, 290,299));
    }
    
    @FXML
    public void onHelp() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("Help.fxml"));
    
    Stage help = (Stage) btnHelp.getScene().getWindow();
    help.setScene(new Scene(root, 309,331));
    }
    
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
