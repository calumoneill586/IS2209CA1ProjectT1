

import ie.team1.is2209ca1projectt1.dao.Pizza;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;


public class PastOrdersController implements Initializable {
 @FXML
    private Button btnAddtoBasket;
    
 
 
 
          @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Pizza> pizzas = dao.getPizzas();
        
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        for(Pizza pizza : pizzas) {
            listView.getItems().add(pizza);
     
    }    
    
}
