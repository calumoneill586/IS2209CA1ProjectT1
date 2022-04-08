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

public class ManagementMenuController implements Initializable {
    @FXML
    private Button btnStoreOrders, btnManagePizzas, btnManageStore;
   
    @FXML
    public void onManageOrders() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("StoreOrderManagement.fxml"));
    
    Stage manageStoreOrders = (Stage) btnStoreOrders.getScene().getWindow();
    manageStoreOrders.setScene(new Scene(root, 620,269));
    }
    
    @FXML 
    public void onManagePizzas() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("StorePizzaManagemnt.fxml"));
    
    Stage managePizzas = (Stage) btnManagePizzas.getScene().getWindow();
    managePizzas.setScene(new Scene(root, 805,502));
    }
    
    @FXML
    public void onManageStores() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("PizzaManagementWindowmark3.fxml"));
    
    Stage manageStores = (Stage) btnManageStore.getScene().getWindow();
    manageStores.setScene(new Scene(root, 620,500));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
