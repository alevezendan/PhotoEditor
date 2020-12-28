package Presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EditorGUI extends Application {

    public Scene scene;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "src\\main\\java\\Presentation\\gui_test.fxml";
        FileInputStream fxmlStream = null;
        try {
            fxmlStream = new FileInputStream(fxmlDocPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Create the Pane and all Details
        VBox root = null;
        try {
            root = (VBox) loader.load(fxmlStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

         scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("PhotoEditor");
        stage.show();
    }
}
