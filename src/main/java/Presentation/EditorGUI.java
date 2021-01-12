package Presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


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
        //String fxmlDocPath = "src\\main\\java\\Presentation\\FXMLfiles\\gui_test.fxml";
        String fxmlDocPath = "src\\main\\java\\Presentation\\gui_test.fxml";
        FileInputStream fxmlStream = null;
        try {
            fxmlStream = new FileInputStream(fxmlDocPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error");
        }

        // Create the Pane and all Details
        VBox root = null;
        try {
            root = (VBox) loader.load(fxmlStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }

         scene = new Scene(root);
      // scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Roboto");
      /*  File file = new File("style.css");
        URL url = null;
        try {
            url = file.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        scene.getStylesheets().add(url.toExternalForm());*/
        //scene.getStylesheets().add("src/main/resources/css/style.css");
       // scene.getStylesheets().add(getClass().getResource().);
       //getClass().getClassLoader().getResource("css/style.css").toExternalForm();
       // scene.getStylesheets().add(getClass().getResource("Presentation.style").toExternalForm());
       // scene.getStylesheets().add
         //       (Login.class.getResource("Login.css").toExternalForm());
        //primaryStage.show();
        scene.getStylesheets().add("file:/C:/Ale/AN3/IS/PhotoEditor/src/main/java/Presentation/style.css");
        stage.setScene(scene);
        stage.setTitle("PhotoEditor");
        stage.show();
    }
}
