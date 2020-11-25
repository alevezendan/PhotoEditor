package Presentation;

import Business.IPhotoEditor;
import Business.PhotoEditor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUIController {
    private IPhotoEditor photoEditor;

    @FXML
    public ImageView imageView;
    @FXML
    private javafx.scene.control.MenuItem openImageBtn;
    @FXML
    // The reference of inputText will be injected by the FXML loader
    private TextField inputText;

    // The reference of outputText will be injected by the FXML loader
    @FXML
    private TextArea outputText;

    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    // Add a public no-args constructor
    public void FxFXMLController()
    {
    }

    @FXML
    private void initialize()
    {
        System.out.println("Initialized");
        imageView = new ImageView();
        photoEditor = new PhotoEditor();
    }

    @FXML
    private void printOutput()
    {
        outputText.setText(inputText.getText());
    }

    public void OpenImageBtnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files", "*.png"));

        try {
            System.out.println("Showing image " + selectedFile.getName());
            FileInputStream stream = new FileInputStream(selectedFile.getAbsolutePath());
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        photoEditor.loadImage(selectedFile.getAbsolutePath());
    }
}
