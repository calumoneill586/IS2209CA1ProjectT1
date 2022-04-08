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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;


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
    //this.spnQuantity.setValueFactory(quantityValueFactory);
    
    
    
    //These items are fot listview and textarea
    @FXML 
    private ListView lstPizza;
    
    @FXML 
    private ListView lstIngredient;
    
    PizzaDao pizzaDao = new PizzaDao();
    IngredientDao ingredientDao = new IngredientDao();
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
        List<Pizza> pizzas = pizzaDao.getPizzas();
        
        //lstPizza.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lstPizza.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedItem) -> {
            Pizza selectedPizza = (Pizza)selectedItem;
            lstIngredient.getItems().clear();
            
            List<Ingredient> ingredients = pizzaDao.getIngredientsForPizza(selectedPizza.getId());
            
            for (Ingredient i : ingredients) {
                lstIngredient.getItems().add(i.getName());
                
            
            }
        });
                
        
        for(Pizza pizza : pizzas) {
            lstPizza.getItems().add(pizza);
        }
       
    }
    //java.lang.ClassCastException: ie.team1.is2209ca1projectt1.dao.Pizza cannot be cast to java.lang.String
    /*public void addToBasket() {
        System.out.println("This button is working");
        
        String basketString = "";
        
        ObservableList listOfPizzas = lstPizza.getSelectionModel().getSelectedItems();
        
        for (Object pizza : listOfPizzas)
        {
            basketString += String.format("%s%n", (String) pizza);
        }
        
        this.lstBasket.setText(basketString);
    }*/
    
    public void onDelClick() {
    
        /*String ingredientToDelete = lstIngredient.getSelectionModel().getSelectedItem().toString();
        lstIngredient.getItems().remove(ingredientToDelete);
        System.out.println(ingredientToDelete);*/
        
    }
    
    
    
    
    public void onClick() {
        
        String ingredientToDelete = lstIngredient.getSelectionModel().getSelectedItem().toString();
        lstIngredient.getItems().remove(ingredientToDelete);
        int value = (Integer) spnQuantity.getValue();
        System.out.println(lstPizza.getSelectionModel().getSelectedItem() + " x" + value + " with no " + ingredientToDelete);
        
        
        
        //System.out.println(ingredientToDelete);
        
        
        /*@FXML
          void onPizzaClick(ActionEvent event) {
 
          int selectedPizza = tblViewManage.getSelectionModel().getSelectedIndex();
          tblViewManage.getItems().remove(selectedPizza);*/


    }
        
        //String basketString = lstPizza.getSelectionModel().getSelectedItem().toString();
        
        //ObservableList listOfPizzas = lstPizza.getSelectionModel().getSelectedItems();
        
        //int value = (Integer) spnQuantity.getValue();
        
        //System.out.println(value);
        
        
        
        
        
        
        
        /*for (Object pizza : listOfPizzas)
        {
            basketString += String.format("%s%n", (String) pizza);
        }
        
        this.lstBasket.setText(basketString);
        
        System.out.println(basketString);*/
        
        //lstPizza.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, selectedItem) -> {
        
        //Pizza selectedPizza = (Pizza)selectedItem;
        
        //System.out.println(selectedItem);
        
        
    //});
    
        
               
    
    public void onStateChanged() {
        
        this.spnQuantity.setValueFactory(quantityValueFactory);
        
    }
    
    
    
    
    
    
    
    
    
    

    public void onNextClick() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("OrderSummary.fxml"));
    
    Stage addBasket = (Stage) btnNext.getScene().getWindow();
    addBasket.setScene(new Scene(root, 562,508));
    }


        
    }

