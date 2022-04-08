package ie.team1.is2209ca1projectt1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import ie.team1.is2209ca1projectt1.dao.Ingredient;
import ie.team1.is2209ca1projectt1.dao.IngredientDao;
import ie.team1.is2209ca1projectt1.dao.Pizza;
import ie.team1.is2209ca1projectt1.dao.PizzaDao;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.jar.Attributes.Name;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StorePizzaManagemntController implements Initializable {
    
     @FXML
    private Button btnAddPizza, btnDeletePizza, btnAddingredient, btnRemoveIngredient, btnBack, btnConfirmSpecialOffers;
     
      @FXML
    private ListView lstPizza, lstIngredients, lstSpecialOffers;
      
      @ FXML
          private Button btnConfirm, btnConfirmIngredient, btnAddIngredient, btnAddOffer;
        @ FXML
          private Label lblNewPizza, lblNewIngredient, lblOffer;
         @ FXML
          private TextField txtAddPizza, txtAddIngredient, txtSpecialOffers;
         
         
         String[] Deals = {"buy 5 get one free", "Buy two get a drink", "buy 10 get free delivery"};
       PizzaDao dao = new PizzaDao();
       IngredientDao dao1 = new IngredientDao();
     
 @FXML 
    public void onBack() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ManagementMenu.fxml"));
    
    Stage onBack = (Stage) btnBack.getScene().getWindow();
    onBack.setScene(new Scene(root, 602,299));
    }
       
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 txtSpecialOffers.setVisible(false);
   btnConfirmSpecialOffers.setVisible(false);
     lblOffer.setVisible(false);
   
        
        
        lstSpecialOffers.getItems().addAll(Deals);
        
        
        txtAddPizza.setVisible(false);
        btnConfirm.setVisible(false); 
          lblNewPizza.setVisible(false); 
          
            txtAddIngredient.setVisible(false);
        btnConfirmIngredient.setVisible(false); 
          lblNewIngredient.setVisible(false); 
        
  
       
       
        List<Pizza> pizzas = dao.getPizzas();
        
        lstPizza.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        for(Pizza pizza : pizzas) {
            lstPizza.getItems().add(pizza);
            
            
        }
            
            List<Ingredient> ingredients = dao1.getIngredients();

        lstIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (Ingredient ingredient : ingredients) {
            lstIngredients.getItems().add(ingredient);
        }
            
            
            
       // List<Ingredient> ingredients = dao1.getIngredients();
        
        //lstIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        //for(Ingredient ingredient : ingredients) {
          //  lstIngredients.getItems().add(ingredient);
        // TODO
   // }    
    
}
    
    
 //   public HideText (){
    
   // }
    
    
      @FXML
     void onPizzaClick(ActionEvent event) {
 
     int selectedPizza = lstPizza.getSelectionModel().getSelectedIndex();
  // lstPizza.getItems().remove(selectedPizza);
     if (lstPizza.getSelectionModel().getSelectedIndex()==-1){
         System.out.println("No Pizza selected");
        
     }else{
         
           lstPizza.getItems().remove(selectedPizza);
     }
     }
      @FXML  
     void onAddPizzaClick(ActionEvent event) {
  txtAddPizza.setVisible(true);
   btnConfirm.setVisible(true);
     lblNewPizza.setVisible(true);
     btnAddPizza.setVisible(false);

   //lstPizza.getItems().add(txtAddPizza.getText());
     }
         @FXML  
     void onConfirmClick(ActionEvent event) {
    
         
     

         
         lstPizza.getItems().add(txtAddPizza.getText());

   //lstPizza.getItems().add(txtAddPizza.getText());
     }
     
     
      @FXML  
     void onAddIngredientClick(ActionEvent event) {
  txtAddIngredient.setVisible(true);
   btnConfirmIngredient.setVisible(true);
     lblNewIngredient.setVisible(true);
     btnConfirmIngredient.setVisible(true);
       btnAddIngredient.setVisible(false);
       
     

   //lstPizza.getItems().add(txtAddPizza.getText());
     }
              @FXML  
     void onConfirmIngredientClick(ActionEvent event) {
 lstIngredients.getItems().add(txtAddIngredient.getText());

   //lstPizza.getItems().add(txtAddPizza.getText());
     }
     
       @FXML
     void onDeleteIngredientClick(ActionEvent event) {
 
    int selectedIngredient = lstIngredients.getSelectionModel().getSelectedIndex();
  // lstPizza.getItems().remove(selectedPizza);
     if (lstIngredients.getSelectionModel().getSelectedIndex()==-1){
         System.out.println("No Ingredient selected");
        
     }else{
         
           lstIngredients.getItems().remove(selectedIngredient);
     }
   
     }

         @FXML  
     void onAddOfferClick(ActionEvent event) {
  txtSpecialOffers.setVisible(true);
   btnConfirmSpecialOffers.setVisible(true);
     lblOffer.setVisible(true);
   
       btnAddOffer.setVisible(false);
       
     

   //lstPizza.getItems().add(txtAddPizza.getText());
     }
        @FXML
     void onDeleteOfferClick(ActionEvent event) {
 
    int selectedOffers = lstSpecialOffers.getSelectionModel().getSelectedIndex();
  // lstPizza.getItems().remove(selectedPizza);
     if (lstSpecialOffers.getSelectionModel().getSelectedIndex()==-1){
         System.out.println("No Offer selected");
        
     }else{
         
           lstSpecialOffers.getItems().remove(selectedOffers);
     }
     }

     
                 @FXML  
     void onConfirmOffersClick(ActionEvent event) {
 lstSpecialOffers.getItems().add(txtSpecialOffers.getText());

   //lstPizza.getItems().add(txtAddPizza.getText());
     }
     
     
 
//String sqlc = "DELETE FROM PIZZA WHERE NAME="+ Name;
       
    


//    PreparedStatement stmt = conn.prepareStatment(sqlc);
    //lstPizza.getItems().remove(selectedPizza);
    //java.sql.Statement statement = conn.createStatement();
            
            
 
    
   
    }


