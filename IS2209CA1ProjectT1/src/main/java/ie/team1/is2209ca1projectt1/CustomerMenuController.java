package ie.team1.is2209ca1projectt1;

import ie.team1.is2209ca1projectt1.dao.Customer;
import ie.team1.is2209ca1projectt1.dao.CustomerDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CustomerMenuController implements Initializable {

    @FXML
    private Button btnOrderPizza, btnPastOrders, btnHelp;

    private Customer customer;

    @FXML
    public void onOrderPizza() throws IOException {

       // CustomerDao loginDao = new CustomerDao();
      //  Customer customer = loginDao.getCustomer(customer);

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "BrowseMenu.fxml"
                )
        );

        Stage login = (Stage) btnOrderPizza.getScene().getWindow();
        login.setScene(new Scene(loader.load(), 607, 282));

        // get the controller for the next scene
        BrowseMenuController controller = loader.getController();
        // send the user object to it.
        controller.setDataFromParent(customer);
    }

    @FXML
    public void onViewPastOrders() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PastOrders.fxml"));

        Stage viewPastOrders = (Stage) btnPastOrders.getScene().getWindow();
        viewPastOrders.setScene(new Scene(root, 290, 299));
    }

    @FXML
    public void onHelp() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Help.fxml"));

        Stage help = (Stage) btnHelp.getScene().getWindow();
        help.setScene(new Scene(root, 309, 331));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setDataFromParent(Customer customer) {

        this.customer = customer;

        System.out.println("CustomerMenu:");
        System.out.println(customer);

    }
}
