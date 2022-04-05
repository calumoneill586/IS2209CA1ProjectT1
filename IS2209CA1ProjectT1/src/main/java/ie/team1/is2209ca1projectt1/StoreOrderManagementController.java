package ie.team1.is2209ca1projectt1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import ie.team1.is2209ca1projectt1.dao.Order;
import ie.team1.is2209ca1projectt1.dao.OrderDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daram
 */
public class StoreOrderManagementController implements Initializable {
@FXML
    private Button btnBack, btnDeleteOrder, btnAddOrder;
     
     // @FXML
    //private TableView tblViewManage;
      
     //  @FXML
   // private TableColumn colOrder, colCustomer, colPay, colGet, colMethod;
       
        @FXML
    private TableView<Order> tblViewManage;
        @FXML
    private TableColumn<Order, Integer>orderid;  
        
        @FXML
    private TableColumn<Order, Integer>customerid;
        
          @FXML
    private TableColumn<Order, String >paymethod;  
          
          @FXML
    private TableColumn<Order, String >getmethod;
          
          @FXML
    private TableColumn<Order, String >request;
    //private TableColumn<Order, int >colOrder;        
                
               // colOrder, colCustomer, colPay, colGet, colMethod;
      
      
       OrderDao OrderDao = new OrderDao();
    
       
    @FXML 
    public void onBack() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
    
    Stage onBack = (Stage) btnBack.getScene().getWindow();
    onBack.setScene(new Scene(root, 602,299));
    }
     
       
       
       
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paymethod.setCellValueFactory(new PropertyValueFactory<Order, String>("paymethod"));
        getmethod.setCellValueFactory(new PropertyValueFactory<Order, String>("getmethod"));
       request.setCellValueFactory(new PropertyValueFactory<Order, String>("request"));
       orderid.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderid"));
       customerid.setCellValueFactory(new PropertyValueFactory<Order, Integer>("customerid"));
        
        

//ObservableList<> orders = FXCollections.observableArrayList();
        ObservableList<Order> orders = OrderDao.getOrders();
        
        tblViewManage.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        for(Order order : orders) {
            tblViewManage.getItems().add(order);
            
            
            
    }    
    
}
}


