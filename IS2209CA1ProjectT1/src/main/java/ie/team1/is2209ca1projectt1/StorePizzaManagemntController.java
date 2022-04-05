package ie.team1.is2209ca1projectt1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import ie.team1.is2209ca1projectt1.dao.Ingredient;
import ie.team1.is2209ca1projectt1.dao.IngredientDao;
import ie.team1.is2209ca1projectt1.dao.Pizza;
import ie.team1.is2209ca1projectt1.dao.PizzaDao;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 * FXML Controller class

 * @author Daram
 */


    //@FXML
   // private TextArea txtBasket;
        
    //These items are fot listview and textarea
    //@FXML 
    //private ListView listView;
public class StorePizzaManagemntController implements Initializable {
    
     @FXML
    private Button btnAddPizza, btnDeletePizza, btnAddingredient, btnRemoveIngredient;
     
      @FXML
    private ListView lstPizza, lstIngredients;
      
       PizzaDao dao = new PizzaDao();
       IngredientDao dao1 = new IngredientDao();
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<Pizza> pizzas = dao.getPizzas();
        
        lstPizza.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        for(Pizza pizza : pizzas) {
            lstPizza.getItems().add(pizza);
            
            
            
            
       // List<Ingredient> ingredients = dao1.getIngredients();
        
        //lstIngredients.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        //for(Ingredient ingredient : ingredients) {
          //  lstIngredients.getItems().add(ingredient);
        // TODO
   // }    
    
}
}
}
