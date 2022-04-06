
//https://stackoverflow.com/questions/41247329/why-doesnt-my-fxml-controller-class-move-my-button
package ie.team1.is2209ca1projectt1;

import java.net.URL;
import java.util.ResourceBundle; 
import javafx.scene.control.Button; 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode; 
import ie.team1.is2209ca1projectt1.dao.Order; 
import ie.team1.is2209ca1projectt1.dao.OrderDao;
import java.util.List;

public class PizzaManagementWindow2Controller implements Initializable {
     
    @FXML 
    //Inserting buttons
    private Button btnNext, btnExit, btnDeleteIngredients, btnCreateIngredients, btnCreateUser, btnDeleteUser, btnCreateLocation, btnDeleteLocation, btnCreateOrder, btnDeleteOrder, btnCreatePersonnel, btnDeletePersonnel;
    
    //Inserting the ListView panels
    @FXML 
    private ListView lstOrders, lstIngredients, lstLocations, lstPersonnel, lstUsers;  
    OrderDao dao = new OrderDao(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
     List<Order> orders = dao.getOrders();

        lstOrders.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for(Order order : orders) {
            lstOrders.getItems().add(order);
      
    }    

        
       
}
    }
