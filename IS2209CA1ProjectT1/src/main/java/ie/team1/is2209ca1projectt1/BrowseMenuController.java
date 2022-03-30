/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1;

//import fxml.test.Pizza;

import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import ie.team1.is2209ca1projectt1.dao.*;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class BrowseMenuController implements Initializable {
    
    @FXML
    private Button btnNext;
    @FXML
    private TextArea txtBasket;
        
    //These items are fot listview and textarea
    @FXML 
    private ListView lstPizza;
    
    @FXML 
    private ListView lstIngredient;
    
    PizzaDao pizzaDao = new PizzaDao();
    IngredientDao ingredientDao = new IngredientDao();
    
    
    //IngredientDao pizzaDao = new IngredientDao();
    
    //private static final Logger logger = LoggerFactory.getLogger(BrowseMenuController.class);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
        List<Pizza> pizzas = pizzaDao.getPizzas();
        
        lstPizza.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lstPizza.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedItem) -> {
            Pizza selectedPizza = (Pizza)selectedItem;
            
            List<Ingredient> ingredients = pizzaDao.getIngredientsForPizza(selectedPizza.getId());
            
            for (Ingredient i : ingredients) {
                lstIngredient.getItems().add(i.getName());
                //System.out.println(i.getName());
            }
        });
                
        
        for(Pizza pizza : pizzas) {
            lstPizza.getItems().add(pizza);
        }
        
       /*List<Ingredient> ingredients = ingredientDao.getIngredients();
        
        lstIngredient.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        for(Ingredient ingredient : ingredients) {
            lstIngredient.getItems().add(ingredient);
        }*/
    }
    
    
    public void onClick() {
        System.out.println("This button is working");
        
        
        
        
        /*String txtBasketString = "";
        
        ObservableList listOfItems = listView.getSelectionModel().getSelectedItems();
        
        for (Object item : listOfItems)
        {
            txtBasketString += String.format("%s%n", (String) item);
        }
        
        this.txtBasket.setText(txtBasketString)*/
    }
    
    

    public void onNextClick() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("OrderSummary.fxml"));
    
    Stage addBasket = (Stage) btnNext.getScene().getWindow();
    addBasket.setScene(new Scene(root, 562,508));
    }
        
    }

