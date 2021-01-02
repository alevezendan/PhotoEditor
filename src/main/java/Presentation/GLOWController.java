package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.security.Guard;

public class GLOWController extends  Controller{

    private GUIController gui;

    public Slider getSlider() {
        return slider;
    }

    @FXML
    private Slider slider;

    @FXML
    void ApplyOnAction(ActionEvent event) {
        gui.glow(this);
    }

    @FXML
    void slide(MouseEvent event) {

    }

    public void init(GUIController mainGui) {
        this.gui = mainGui;
    }
}
