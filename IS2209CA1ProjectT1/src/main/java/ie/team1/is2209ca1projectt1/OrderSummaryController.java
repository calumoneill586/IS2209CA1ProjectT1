/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class OrderSummaryController implements Initializable {

    
    @FXML
    private Button btnPlaceOrder;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
        
        
    }
    
    
}
