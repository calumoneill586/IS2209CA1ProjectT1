/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.control.TextField;
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
    
    
    String finalOrderDetails;
    
    
    String dataFromParent;
    
    String payMethod;
    String getMethod;
    
    
    
    //Add to Basket button
    @FXML
    private void handlePlaceOrder() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ConfirmOrder.fxml"));
    
    
    
    if (rdbCash.isSelected()) {
        payMethod = "Customer will pay with cash";
    } else {
        payMethod = "Customer will pay with card";
    }
    
    
    
    if (rdbCollection.isSelected()) {
        getMethod = "Order will be collected";
    } else {
        getMethod = "Order will be delivered";
    }
    
    customerRequest = txtRequest.getText();
    
    //System.out.println(customerRequest);
    finalOrderDetails = payMethod + ". " + getMethod + ". " + "Customer Request (if any): " + customerRequest;
    System.out.println(finalOrderDetails);
    
    
    

    /*FileWriter myWriter = new FileWriter("orders.txt");
      myWriter.write(finalOrderDetails);
      myWriter.write(dataFromParent);
      myWriter.close();*/
    

    
    
    Stage addBasket = (Stage) btnPlaceOrder.getScene().getWindow();
    addBasket.setScene(new Scene(root, 181, 249));

    }
    
    

    public void setDataFromParent(ObservableList<String> basketItems) {
        System.out.println(dataFromParent);
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
       

        
        
        
    }
    
    
}
