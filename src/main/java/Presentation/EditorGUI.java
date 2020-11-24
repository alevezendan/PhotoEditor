package Presentation;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EditorGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        /*
        Parent root = null;
        try {
            root = new FXMLLoader(this.getClass().getResource("GUI//gui_test.fxml")).load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Dice Roller");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/

        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "src\\main\\java\\GUI\\gui_test.fxml";
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

        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("A simple FXML Example");
        // Display the Stage
        stage.show();
    }
}