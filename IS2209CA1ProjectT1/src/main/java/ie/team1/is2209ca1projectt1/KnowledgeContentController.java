package ie.team1.is2209ca1projectt1;


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



public class KnowledgeContentController implements Initializable {
    
    @FXML
    private Button btnBack;
       
    public void onNextClick() throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("BrowseMenu.fxml"));
    
    Stage back = (Stage) btnBack.getScene().getWindow();
    back.setScene(new Scene(root, 765,415));
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
