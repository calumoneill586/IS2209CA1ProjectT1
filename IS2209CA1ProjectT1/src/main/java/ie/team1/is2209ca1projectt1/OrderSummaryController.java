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
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class OrderSummaryController implements Initializable {

    
     @FXML
    private Button btnAddToBasket;

    //Add to Basket button
    @FXML
    private void handleAddToBasket() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLBasket.fxml"));
    
    Stage addBasket = (Stage) btnAddToBasket.getScene().getWindow();
    addBasket.setScene(new Scene(root, 562,508));
    }
    
    public void onClick() {
        //System.out.println("onclick");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
