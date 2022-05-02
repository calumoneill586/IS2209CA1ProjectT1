package ie.team1.is2209ca1projectt1;


import ie.team1.is2209ca1projectt1.dao.CustomerDao;
import ie.team1.is2209ca1projectt1.dao.Customer;
import ie.team1.is2209ca1projectt1.dao.CustomerDao2;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class EditCustomersController implements Initializable {
    //TableView:
       @FXML
    private TableView<Customer> tblCustomers;
         
       @FXML
    private TableColumn<Customer, String>cname;
        
       @FXML
    private TableColumn<Customer, String >caddressline1;  
          
       @FXML
    private TableColumn<Customer, String >caddressline2;
          
       @FXML
    private TableColumn<Customer, String >ccreditcardno;
      
       @FXML
    private TableColumn<Customer, String >cphoneno;
       
        @FXML
    private TableColumn<Customer, String >callergies;
        
         @FXML
    private TableColumn<Customer, String >cusername;
         
          @FXML
    private TableColumn<Customer, String >cpassword;
          
          
    public void changeNameCellEvent(CellEditEvent editedCell){
        
        Customer customerSelected = tblCustomers.getSelectionModel().getSelectedItem();
        customerSelected.setName(editedCell.getNewValue().toString());
    }      
          
          
          
    CustomerDao2 customerdao2 = new CustomerDao2();
    
//TextFields:
    @FXML
    private TextField txtName, txtAddress1, txtAddress2, txtCCNumber, txtPhoneNumber, txtAllergies,txtUsername;
  
    @FXML
    private PasswordField txtPassword;
       
    private Button btnConfirmEdit;
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    //Setting Values for TableView
       
        cname.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        caddressline1.setCellValueFactory(new PropertyValueFactory<>("addressline1"));
        
        caddressline2.setCellValueFactory(new PropertyValueFactory<>("addressline2"));
        
        ccreditcardno.setCellValueFactory(new PropertyValueFactory<>("creditcardno"));
        
        cphoneno.setCellValueFactory(new PropertyValueFactory<>("phoneno"));
        
        callergies.setCellValueFactory(new PropertyValueFactory<>("allergies"));
        
        cusername.setCellValueFactory(new PropertyValueFactory<>("username"));
        
        cpassword.setCellValueFactory(new PropertyValueFactory<>("password")); 
   
        ObservableList<Customer> customers = (ObservableList<Customer>) customerdao2.getCustomers();

        tblCustomers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        tblCustomers.setEditable(true);
        cname.setCellFactory(TextFieldTableCell.forTableColumn());

        for (Customer customer : customers) {
            tblCustomers.getItems().add(customer);

        }  
    } 
        
    @FXML
    public void Update(ActionEvent event) throws SQLException, IOException {
     /* ObservableList<Customer> data = FXCollections.observableArrayList();
       ResultSet rs= conn.createStatement().executeQuery("SELECT * FROM customer");
            while(rs.next()) {
                data.add(new Customer(rs.getString("name"), rs.getString("addressline1"), rs.getString("addressline2"), rs.getString("creditcardno"), rs.getString("phoneno"), rs.getString("allergies"), rs.getString("username"), rs.getString("password")));//RENAMED FROM "rs.getString(2),"
                tblCustomers.setItems(data);
       
       //Setting values for the columns
       
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressline1.setCellValueFactory(new PropertyValueFactory<>("addressline1"));
        addressline2.setCellValueFactory(new PropertyValueFactory<>("addressline2"));
        creditcardno.setCellValueFactory(new PropertyValueFactory<>("creditcardno"));
        phoneno.setCellValueFactory(new PropertyValueFactory<>("phoneno"));
        allergies.setCellValueFactory(new PropertyValueFactory<>("allergies"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password")); 
        
        tblCustomers.setItems(null);
        tblCustomers.setItems(data); */
        
        //Setting values for update query
        
        String name = txtName.getText();
        String addressline1 = txtAddress1.getText();
        String addressline2 = txtAddress2.getText();
        String creditcardno = txtCCNumber.getText();
        String phoneno = txtPhoneNumber.getText();
        String allergies = txtAllergies.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
                
        CustomerDao.updateRecord(name, addressline1, addressline2, creditcardno, phoneno, allergies, username, password);  
        
          Parent root = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
          Stage onNewClick = (Stage) btnConfirmEdit.getScene().getWindow();
          onNewClick.setScene(new Scene(root, 607,282)) ;
  
        
        }
    }

