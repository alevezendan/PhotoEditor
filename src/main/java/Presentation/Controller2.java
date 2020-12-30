package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class Controller2 {

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

        /*ImageView img= (ImageView) gui.getTabPanee().getTabs().get(gui.getTabPanee().getSelectionModel().getSelectedIndex()).getContent();
        W.setText(Double.toString(img.getFitWidth()));
        H.setText(Double.toString(img.getFitHeight()));*/
/*

        ImageView img=(ImageView) GUIController.getTabs().get(c.getTabPanee().getSelectionModel().getSelectedIndex()).getContent();

        int newW=Integer.parseInt(W.getText());
        int newH=Integer.parseInt(H.getText());
        //System.out.println(W.getText());
        img.setFitHeight(newH);
        img.setFitWidth(newW);

       c.getTabPanee().getTabs().get(c.getTabPanee().getSelectionModel().getSelectedIndex()).setContent(img);
    }*/
        gui.inflate(this);
    }

    public void inflateUI(GUIController gui){
        //W.setText(gui.getTabPanee().getTabs().get(gui.getTabPanee().getSelectionModel().getSelectedIndex()).getText());
        ImageView img= (ImageView) gui.getTabPanee().getTabs().get(gui.getTabPanee().getSelectionModel().getSelectedIndex()).getContent();
        W.setText(Double.toString(img.getFitWidth()));
        H.setText(Double.toString(img.getFitHeight()));

    }
}
