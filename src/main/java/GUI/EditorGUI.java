package GUI;

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
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = new FXMLLoader(this.getClass().getResource("gui_test.fxml")).load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Dice Roller");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
