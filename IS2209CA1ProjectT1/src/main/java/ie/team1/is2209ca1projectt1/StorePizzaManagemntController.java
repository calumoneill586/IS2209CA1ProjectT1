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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class StorePizzaManagemntController implements Initializable {
    
     @FXML
    private Button btnAddPizza, btnDeletePizza, btnAddingredient, btnRemoveIngredient, btnBack;
     
      @FXML
    private ListView lstPizza, lstIngredients;
      
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
    
    
    
      @FXML
     void onPizzaClick(ActionEvent event) {
 
    int selectedPizza = lstPizza.getSelectionModel().getSelectedIndex();
   
    


//String sqlc = "DELETE FROM PIZZA WHERE NAME="+ Name;
       
    


//    PreparedStatement stmt = conn.prepareStatment(sqlc);
    //lstPizza.getItems().remove(selectedPizza);
    //java.sql.Statement statement = conn.createStatement();
            
            
 
    
   
    }
}

