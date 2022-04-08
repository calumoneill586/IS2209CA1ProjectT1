/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class OrderSummaryController implements Initializable {

    
    @FXML private AnchorPane apOrderDetails;
    
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private ListView lstMyOrder;

    @FXML
    private RadioButton rdbCash;
    
    @FXML
    private RadioButton rdbCard;
    
    @FXML
    private RadioButton rdbCollection;
    
    @FXML
    private RadioButton rdbDelivery;
    
    @FXML
    private TextArea txtRequest;
    
    String customerRequest;
    
    //String myOrder = lst
    
    String dataFromParent;
    
    
    
    
    
    //Add to Basket button
    @FXML
    private void handlePlaceOrder() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ConfirmOrder.fxml"));
    
    if (rdbCash.isSelected()) {
        System.out.println("Customer will pay with cash");
    } else {
        System.out.println("Customer will pay with card");
    }
    
    if (rdbCollection.isSelected()) {
        System.out.println("Order will be collected");
    } else {
        System.out.println("Order will be delivered");
    }
    
    customerRequest = txtRequest.getText();
    
    System.out.println(customerRequest);
    

    Stage addBasket = (Stage) btnPlaceOrder.getScene().getWindow();
    addBasket.setScene(new Scene(root, 181,249));

    }

    public void setDataFromParent(ObservableList<String> basketItems) {
        
        for (String item : basketItems) {
            lstMyOrder.getItems().add(item);

            
            /*String REGEX = ".*x.*";
            Pattern pattern = Pattern.compile(REGEX);
            
            Matcher matcher = pattern.matcher(item);
            
            boolean matches = matcher.matches();
 
            System.out.println("actualString "
                           + "contains REGEX = "
                           + matches);
            
            String[] pizzas = item.split(" ");
            String pizza = pizzas[0];
            
            String[] quantities = item.split("^[0-9]+$");
            String quantity = quantities[0];
                        
            
            
            System.out.println(pizza);
            System.out.println(quantity);
            System.out.println(pattern);*/
        }
        
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
       // Stage addBasket = (Stage) btnPlaceOrder.getScene().getWindow();
    
   
       //String dataFromBrowseMenu = (String)apOrderDetails.getUserData();
       //System.out.println(dataFromParent);

        
        
        
    }
    
    
}
