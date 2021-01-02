package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class RESIZEController extends  Controller{

    private GUIController gui;
    @FXML
    private TextField W;

    @FXML
    private TextField H;

    public TextField getW() {
        return W;
    }

    public TextField getH() {
        return H;
    }

    @FXML
    void Height(ActionEvent event) {
        System.out.println(H.getText());
        H.setText(H.getText());
    }

    @FXML
    void Width(ActionEvent event) {
        System.out.println(W.getText());
        W.setText(W.getText());
    }

    public void init(GUIController mainGui){
        this.gui=mainGui;
    }
    @FXML
    void ApplyBtnAction(ActionEvent event) {
        gui.inflate(this);
    }

    /*public void inflateUI(GUIController gui){
        //W.setText(gui.getTabPanee().getTabs().get(gui.getTabPanee().getSelectionModel().getSelectedIndex()).getText());
        ImageView img= (ImageView) gui.getTabPanee().getTabs().get(gui.getTabPanee().getSelectionModel().getSelectedIndex()).getContent();
        W.setText(Double.toString(img.getFitWidth()));
        H.setText(Double.toString(img.getFitHeight()));

    }*/
}
