package ie.team1.is2209ca1projectt1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.fxml.FXML; 
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import ie.team1.is2209ca1projectt1.dao.*;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode; 
import ie.team1.is2209ca1projectt1.dao.Order;
import ie.team1.is2209ca1projectt1.dao.OrderDao;
import ie.team1.is2209ca1projectt1.dao.Ingredient;
import ie.team1.is2209ca1projectt1.dao.IngredientDao;
import ie.team1.is2209ca1projectt1.dao.Customer;
import ie.team1.is2209ca1projectt1.dao.CustomerDao2;
import ie.team1.is2209ca1projectt1.dao.Shop;
import ie.team1.is2209ca1projectt1.dao.ShopDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List; 
import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView; 
import javafx.scene.control.cell.PropertyValueFactory; 
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author 120463034
 */
public class PizzaManagementWindowmarkIIIController implements Initializable {
    /*OrderDao dao = new OrderDao();
    IngredientDao idao = new IngredientDao();
    ShopDao sdao = new ShopDao();// = new ShopDao();
    CustomerDao2 cdao = new CustomerDao2(); */
    /**
     * Initializes the controller class.
     */   
      @FXML
    //Inserting buttons
    private Button btnNext, btnPrevious, btnDeleteIngredients, btnCreateIngredients, btnCreateUser, btnDeleteUser, btnCreateLocation, btnDeleteLocation, btnCreateOrder, btnDeleteOrder, btnCreatePersonnel, btnDeletePersonnel;
    //Inserting the TableView panels 
      //Order tableview, code based on other management windows throughout project...
@FXML
    private TableView<Order> tblOrders = null;
        @FXML
    private TableColumn<Order, String>orderid;  
        
        @FXML
    private TableColumn<Order, Integer>customerid;
        
          @FXML
    private TableColumn<Order, String >paymethod;  
          
          @FXML
    private TableColumn<Order, String >getmethod;
          
          @FXML
    private TableColumn<Order, String >request; 
   
   
          
              //Ingredients   
    @FXML
   private TableView<Ingredient> tblIngredients = null; 
    @FXML 
   private TableColumn <Ingredient,  Integer> colIngredientID;  
    @FXML
   private TableColumn <Ingredient,  String> colIngredientName; 

 
    
    
    //Locations/Shop
    @FXML
    private TableView <Shop> tblLocations = null;  
     @FXML 
   private TableColumn <Shop, Integer> colShopID;  
     @FXML
   private TableColumn <Shop, String> colLocation;  
    
     
     
     //Personnel  
     //**Ran out of time to figure out personnel
    @FXML 
    private TableView  tblPersonnel = null; 
   
     
     
     
    //Users 
    @FXML 
    private TableView<Customer> tblUsers = null; 
     @FXML 
   private TableColumn <Customer, Integer> id;  
     @FXML
   private TableColumn <Customer, String>name; 
     @FXML
   private TableColumn <Customer, String>addressline1; 
     @FXML
   private TableColumn <Customer, String> phoneno; 
  //   @FXML
   //private TableColumn <Customer, String> creditcardno;  
   //  @FXML
   //private TableColumn <Customer,String> username; 
     //  @FXML
  // private TableColumn <Customer ,String> password;
           @FXML
   private TableColumn <Customer ,String> allergies;
            @FXML
   private TableColumn <Customer, String>addressline2;
           
                   
       
     
         @FXML
   private TableColumn <Staff ,Integer> StaffId;
             @FXML
   private TableColumn <Staff ,Integer> ShopId;
                 @FXML
   private TableColumn <Staff ,String> StaffRole; 
         
 
          
    @FXML 
   public void onBack() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
    
    Stage onBack = (Stage) btnPrevious.getScene().getWindow();
    onBack.setScene(new Scene(root, 602,299));
    } 
     @FXML 
   public void onNext() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
    
    Stage onBack = (Stage) btnNext.getScene().getWindow();
    onBack.setScene(new Scene(root, 602,299));
    }
      
      
    OrderDao orderdao = new OrderDao();
    IngredientDao ingredientdao = new IngredientDao();
    ShopDao shopdao = new ShopDao();// = new ShopDao();
    CustomerDao2 customerdao2 = new CustomerDao2();  
    StaffDao staffdao = new StaffDao();
    
       
       
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
      paymethod.setCellValueFactory(new PropertyValueFactory<Order, String>("paymethod"));
      
       getmethod.setCellValueFactory(new PropertyValueFactory<Order, String>("getmethod"));
       request.setCellValueFactory(new PropertyValueFactory<Order, String>("request"));
       orderid.setCellValueFactory(new PropertyValueFactory<Order, String>("orderid"));
       customerid.setCellValueFactory(new PropertyValueFactory<Order, Integer>("customerid"));
     //Ingredients 
     colIngredientID.setCellValueFactory(new PropertyValueFactory<Ingredient, Integer>("id"));
     colIngredientName.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
     //Users 
     id.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id")); 
     name.setCellValueFactory(new PropertyValueFactory<Customer, String>("name")); 
     addressline1.setCellValueFactory(new PropertyValueFactory<Customer, String>("addressline1")); 
       addressline2.setCellValueFactory(new PropertyValueFactory<Customer, String>("addressline2")); 
     phoneno.setCellValueFactory(new PropertyValueFactory<Customer, String>("phoneno")); 
    // creditcardno.setCellValueFactory(new PropertyValueFactory<Customer, String>("creditcardno")); 
     //username.setCellValueFactory(new PropertyValueFactory<Customer, String>("username")); 
     // password.setCellValueFactory(new PropertyValueFactory<Customer, String>("password")); 
      allergies.setCellValueFactory(new PropertyValueFactory<Customer, String>("allergies")); 
     
     //Locations 
     colShopID.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("id"));  
     colLocation.setCellValueFactory(new PropertyValueFactory<Shop, String>("location")); 
     
       StaffId.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("id"));  
       ShopId.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("ShopId")); 
      
       StaffRole.setCellValueFactory(new PropertyValueFactory<Staff, String>("StaffRole")); 
      
        

      //ObservableList<> orders = FXCollections.observableArrayList();
        ObservableList<Order> orders = (ObservableList<Order>) orderdao.getOrders();

        tblOrders.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    
        for(Order order : orders) {
            
            System.out.println(order);
            tblOrders.getItems().add(order);
            
        }


        // TODO  
        //Order tableview
        //ObservableList<Order> orders = FXCollections.observableArrayList(); 
       

        //sdao = 
        //idao 

       // tblOrders.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

       // for (Order order : orders) {
            //tblOrders.getItems().add(order); 
            
       // }

        //Ingredients tableview   
       
        ObservableList<Ingredient> ingredients = (ObservableList<Ingredient>) ingredientdao.getIngredients();

        tblIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (Ingredient ingredient : ingredients) {
            tblIngredients.getItems().add(ingredient); 
        
        }

        //Store locations listview 
           
        ObservableList<Shop> shops = (ObservableList<Shop>) shopdao.getShop();

        tblLocations.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (Shop shop : shops) {
            tblLocations.getItems().add(shop); 
            
        }

        //User listview 
        ObservableList<Customer> customers = (ObservableList<Customer>) customerdao2.getCustomers();

        tblUsers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (Customer customer : customers) {
            tblUsers.getItems().add(customer);

        }
        
        //User listview 
        ObservableList<Staff> staffs = (ObservableList<Staff>) staffdao.getStaff();

        tblPersonnel.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (Staff staff : staffs) {
            tblPersonnel.getItems().add(staff);

        }
        
    
    }  
       @FXML
     void onDeleteUserClick(ActionEvent event) {
 //Initially meant for users...except the FX:ID wouldn't allow users to be displayed so I moved it to ingredients
    int selectedIngredient = tblUsers.getSelectionModel().getSelectedIndex();
    tblIngredients.getItems().remove(selectedIngredient); 
    System.out.println("Deletion completed"); 
    
     } 
     
} 
 

       
    

