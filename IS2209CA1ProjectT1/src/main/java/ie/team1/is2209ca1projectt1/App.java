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
<<<<<<< HEAD


        scene = new Scene(loadFXML("BrowseMenu"));





=======
        scene = new Scene(loadFXML("Login"));
>>>>>>> 1aa8869bb02e3f7998613fd367139af494cd247c
>>>>>>> 9ca3a184b1c894b8f9cb7293c6c2f77b4d1b5766
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