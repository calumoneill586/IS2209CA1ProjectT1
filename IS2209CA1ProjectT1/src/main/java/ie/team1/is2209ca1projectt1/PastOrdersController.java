package ie.team1.is2209ca1projectt1;



import ie.team1.is2209ca1projectt1.dao.Order;
import ie.team1.is2209ca1projectt1.dao.OrderDao;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;


public class PastOrdersController implements Initializable {
 
 @FXML 
    private ListView listView;
 
 OrderDao orderDao = new OrderDao();
 
          @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Order> orders = orderDao.getOrders();
        
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        for(Order order : orders) {
            listView.getItems().add(order);
     
    }    
    
    }
}
