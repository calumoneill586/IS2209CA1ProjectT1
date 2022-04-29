package ie.team1.is2209ca1projectt1;



import ie.team1.is2209ca1projectt1.dao.Order;
import ie.team1.is2209ca1projectt1.dao.OrderDao;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;


public class PastOrdersController implements Initializable {
 
 @FXML 
    private ListView listView;
 
 @FXML 
    private Button btnBack;
 
 OrderDao orderDao = new OrderDao();
 
 @FXML
    private void handleBack() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("CustomerMenu.fxml")); 
    
    
    Stage homeConfirmation = (Stage) btnBack.getScene().getWindow();
    homeConfirmation.setScene(new Scene(root, 607 ,282));
    }
 
          @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Order> orders = orderDao.getOrders();
        
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        for(Order order : orders) {
            listView.getItems().add(order);
     
    }    
    
    }
}
