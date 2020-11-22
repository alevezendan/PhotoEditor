package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.swing.*;

public class GUIController implements Initializable {

    // Add a public no-args constructor*/

    @FXML
    private MenuItem uploadImage;

    @FXML
    private Menu openRecent;

    @FXML
    private MenuItem close;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    void closeOnAction(ActionEvent event) {

    }

    @FXML
    void openRecentOnAction(ActionEvent event) {

    }
    @FXML
    void flipHorizontalOnAction(ActionEvent event) {

    }

    @FXML
    void flipVerticalOnAction(ActionEvent event) {

    }

    @FXML
    void rotateLeftOnAction(ActionEvent event) {

    }

    @FXML
    void rotateRightOnAction(ActionEvent event) {


    }

    @FXML
    void zoomInOnAction(ActionEvent event) {

    }

    @FXML
    void zoomOutOnAction(ActionEvent event) {

    }


    @FXML
    private Label label;

    @FXML
    private TextField inputText;
    @FXML
    void cropOnAction(ActionEvent event) {
        inputText.setText("Hello World!");
        System.out.println("Naiba stie ce e aici");
    }

    @FXML
    private Pane pane;
    @FXML
    void resizeOnAction(ActionEvent event) {
        JPanel p=new JPanel();
        JFrame frame=new JFrame("Resize");
        JLabel width=new JLabel("Width");
        JLabel height=new JLabel("Height");
        JTextField text1=new JTextField();
        JTextField text2=new JTextField();
        p.add(width);
        p.add(text1);
        p.add(height);
        p.add(text2);
        p.setSize(250,250);
        frame.add(p);
        frame.setSize(250,250);

        frame.pack();
        frame.setVisible(true);



    }

    @FXML
    void saveOnAction(ActionEvent event) {

    }

    @FXML
    void uploadOnACtion(ActionEvent event) {

    }

}
