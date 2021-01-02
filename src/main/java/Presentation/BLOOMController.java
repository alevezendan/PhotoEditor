package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class BLOOMController extends  Controller{

    private GUIController gui;

    public Slider getThresholdSlider() {
        return thresholdSlider;
    }

    @FXML
    private Slider thresholdSlider;

    @FXML
    void ApplyOnAction(ActionEvent event) {
        gui.bloom(this);
    }

    public void init(GUIController mainGui){
        this.gui=mainGui;
    }

}
