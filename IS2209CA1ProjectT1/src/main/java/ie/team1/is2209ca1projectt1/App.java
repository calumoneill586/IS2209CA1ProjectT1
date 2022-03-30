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
        scene = new Scene(loadFXML("StoreOrderManagement"));
=======
        scene = new Scene(loadFXML("Login"));
>>>>>>> 58dba71589cbc752c0e45917acb5ed3ace528626
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