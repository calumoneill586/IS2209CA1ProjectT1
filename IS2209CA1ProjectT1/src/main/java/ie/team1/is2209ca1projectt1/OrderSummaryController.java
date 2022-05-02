/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.team1.is2209ca1projectt1;

import ie.team1.is2209ca1projectt1.dao.Customer;
import ie.team1.is2209ca1projectt1.dao.OrderDao;
import ie.team1.is2209ca1projectt1.dao.OrderItem;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OrderSummaryController implements Initializable {

    @FXML
    private AnchorPane apOrderDetails;

    @FXML
    private Button btnPlaceOrder, btnBack;

    @FXML
    private ListView lstMyOrder;

    @FXML
    private RadioButton rdbCash;

    @FXML
    private RadioButton rdbCard;

    @FXML
    private RadioButton rdbCollection;

    @FXML
    private RadioButton rdbDelivery;

    @FXML
    private TextArea txtRequest;

    @FXML
    private Label lblCost;

    String customerRequest;

    String finalOrderDetails;

    String dataFromParent;

    String payMethod;
    String getMethod;

    private Customer customer;

    OrderDao orderDao = new OrderDao();
    BrowseMenuController browseMenu = new BrowseMenuController();

    //Add to Basket button
    @FXML
    private void handlePlaceOrder() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ConfirmOrder.fxml"));
        Stage addBasket = (Stage) btnPlaceOrder.getScene().getWindow();
        addBasket.setScene(new Scene(root, 181, 249));

        if (rdbCash.isSelected()) {
            payMethod = "Customer will pay with cash";
        } else {
            payMethod = "Customer will pay with card";
        }

        if (rdbCollection.isSelected()) {
            getMethod = "Order will be collected";
        } else {
            getMethod = "Order will be delivered";
        }

        customerRequest = txtRequest.getText();

        //System.out.println(customerRequest);
        finalOrderDetails = payMethod + ". " + getMethod + ". " + "Customer Request (if any): " + customerRequest;
        System.out.println(finalOrderDetails);

        String customerid = " " + customer.getId();
        String paymethod = payMethod;
        String getmethod = getMethod;
        String request = customerRequest;
        Double total = browseMenu.orderTotal;

        OrderDao.insertOrder(customerid, paymethod, getmethod, request, total);

    }

    @FXML
    private void handleBack() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BrowseMenu.fxml"));
        Stage goBack = (Stage) btnBack.getScene().getWindow();
        goBack.setScene(new Scene(root, 747, 400));
    }

    public void setDataFromParent(ObservableList<OrderItem> basketItems) {

        System.out.println(basketItems);
        for (OrderItem item : basketItems) {
            lstMyOrder.getItems().add(item);
        }

    }

    public void setDataFromParent2(Customer customer) {

        this.customer = customer;

        System.out.println("CustomerMenu:");
        System.out.println(customer);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BrowseMenuController browseMenu = new BrowseMenuController();
        System.out.println(browseMenu.orderTotal);
        lblCost.setText("€ " + browseMenu.orderTotal);

    }

}
