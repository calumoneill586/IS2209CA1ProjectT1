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
    //test
    // hi Orla

    public void start(Stage stage) throws IOException {



        scene = new Scene(loadFXML("BrowseMenu"));




  


<<<<<<< HEAD
        scene = new Scene(loadFXML("PizzaManagementWindowmarkIII"));

=======
>>>>>>> 33244c0310b61497db520e13b7a891c10ae32a1f
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
