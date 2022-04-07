package ie.team1.is2209ca1projectt1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application { 


    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

<<<<<<< HEAD
        scene = new Scene(loadFXML("StartPage"));

=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ba2be4e41979085a8a62a7d4da50987890a8f9fb
>>>>>>> dca288db0027009a01ad58395ef2d76a18b1de65



        scene = new Scene(loadFXML("BrowseMenu"));







>>>>>>> 33a206dbf28243d0637f2f5daffef7559be18b09
        stage.setScene(scene);
        stage.setTitle("Pizza Me");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}