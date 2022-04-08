/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1;

//import fxml.test.Pizza;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import ie.team1.is2209ca1projectt1.dao.*;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 *
 * @author admin
 */
public class BrowseMenuController implements Initializable {
    
    @FXML
    private Button btnNext;
    @FXML
    private ListView lstBasket;
    
    @FXML
    private Spinner spnQuantity;
    SpinnerValueFactory<Integer> quantityValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1);
    
    @FXML
    private Button btnAddToBasket;

    //These items are fot listview and textarea
    @FXML 
    private ListView lstPizza;
    
    @FXML 
    private ListView lstIngredient;
    
    @FXML
    private Label lblQuantity;
    
    PizzaDao pizzaDao = new PizzaDao();
    IngredientDao ingredientDao = new IngredientDao();
    
    String ingredientToDelete;
    String itemToDelete;
    String selectedPizza;
    int value;
    String order = selectedPizza + " x" + value;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
        btnAddToBasket.setDisable(true);
        btnNext.setDisable(true);
        
        List<Pizza> pizzas = pizzaDao.getPizzas();
        
        //lstPizza.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lstPizza.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedItem) -> {
            Pizza selectedPizza = (Pizza)selectedItem;
            lstIngredient.getItems().clear();
            
            List<Ingredient> ingredients = pizzaDao.getIngredientsForPizza(selectedPizza.getId());
            lstIngredient.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            
            for (Ingredient i : ingredients) {
                lstIngredient.getItems().add(i.getName());

            }
        });

        for(Pizza pizza : pizzas) {
            lstPizza.getItems().add(pizza);
        }
       
    }
    
    public void onDeleteIngredient() {

        ingredientToDelete = lstIngredient.getSelectionModel().getSelectedItem().toString();
        lstIngredient.getItems().remove(ingredientToDelete);
 
    }
    
    public void onDeleteItem() {
        
        itemToDelete = lstBasket.getSelectionModel().getSelectedItem().toString();
        lstBasket.getItems().remove(itemToDelete);
        
    }
    
    public void onClick() {
        
        int value = (Integer) spnQuantity.getValue();
        
        String selectedPizza = lstPizza.getSelectionModel().getSelectedItem().toString();
        
        //String order = "";
        
        if (ingredientToDelete == null) {
            order = selectedPizza + " x" + value;
        } else {
            order = selectedPizza + " x" + value + ", no " + ingredientToDelete;
        }
        
        if (lstBasket != null) {
            btnNext.setDisable(false);
        }
        
        lstBasket.getItems().add(order);
        
        ingredientToDelete = null;
        
    }         
    
    public void onStateChanged() {
        
        lblQuantity.setVisible(false);
        this.spnQuantity.setValueFactory(quantityValueFactory);
        btnAddToBasket.setDisable(false);
            
        
        
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Select a quantity!");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
         }

    public void onNextClick() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("OrderSummary.fxml"));
    
    Stage addBasket = (Stage) btnNext.getScene().getWindow();
    addBasket.setScene(new Scene(root, 551,560));
    }


        
    }

