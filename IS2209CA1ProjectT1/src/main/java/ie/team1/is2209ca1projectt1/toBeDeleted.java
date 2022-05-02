/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1;
import ie.team1.is2209ca1projectt1.dao.Customer;
import ie.team1.is2209ca1projectt1.dao.CustomerDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class toBeDeleted implements Initializable {

    @FXML
    private Button btnConfirmEdit;
    
    @FXML
    private TableView<Customer> tblCustomers;
    
    @FXML
    private TableColumn<Customer, String>name;
    private TableColumn<Customer, String>addressline1;
    private TableColumn<Customer, String>addressline2;
    private TableColumn<Customer, String>phoneno;
    private TableColumn<Customer, String>allergens;
    private TableColumn<Customer, String>username;
    private TableColumn<Customer, String>password;
    
    CustomerDao CustomerDao = new CustomerDao();
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        addressline1.setCellValueFactory(new PropertyValueFactory<Customer, String>("addressline1"));
        addressline2.setCellValueFactory(new PropertyValueFactory<Customer, String>("addressline2"));
        phoneno.setCellValueFactory(new PropertyValueFactory<Customer, String>("phoneno"));
        allergens.setCellValueFactory(new PropertyValueFactory<Customer, String>("allergens"));
        username.setCellValueFactory(new PropertyValueFactory<Customer, String>("username"));
        password.setCellValueFactory(new PropertyValueFactory<Customer, String>("password"));
        
        ObservableList<Customer> customers = CustomerDao.getCustomers();
        
        tblCustomers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        for(Customer customer : customers) {
            
            System.out.println(customer);
            tblCustomers.getItems().add(customer);
    }
    }
}
