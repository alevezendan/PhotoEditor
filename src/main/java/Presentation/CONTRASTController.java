package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class CONTRASTController extends  Controller{

    private GUIController gui;

    @FXML
    private Slider slider;

    public Slider getSlider() {
        return slider;
    }

    @FXML
    void ApplyOnAction(ActionEvent event) {
        gui.inflateC(this);
    }

    @FXML
    void slide(MouseEvent event) {

    }

    public void init(GUIController mainGui) {
        this.gui=mainGui;
    }
}
