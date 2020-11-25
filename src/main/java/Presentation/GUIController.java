package Presentation;

import Business.IPhotoEditor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class GUIController {
    private IPhotoEditor photoEditor;

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
    }

    @FXML
    private void printOutput()
    {
        outputText.setText(inputText.getText());
    }

    public void OpenImageBtnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG files", "*.png"),
                new FileChooser.ExtensionFilter("JOEG files", "*.jpeg"));

        if (selectedFile != null) {
            photoEditor.loadImage(selectedFile.getAbsolutePath());
        }
    }
}
