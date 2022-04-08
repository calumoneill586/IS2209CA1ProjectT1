package ie.team1.is2209ca1projectt1;

import ie.team1.is2209ca1projectt1.dao.Order;
import ie.team1.is2209ca1projectt1.dao.OrderDao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.SelectionMode;


public class ConfirmOrderController implements Initializable {
   
    //Confirmation Page Methods Section
    @FXML
    private Button btnHome;


    @FXML
    private void handleHome() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("BrowseMenu.fxml")); //Change to Menu
    
    
    Stage homeConfirmation = (Stage) btnHome.getScene().getWindow();
    homeConfirmation.setScene(new Scene(root, 713,400));
    }

       
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
        }
 
    }

