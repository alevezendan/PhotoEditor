package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class MOTIONBController extends Controller {

    private GUIController gui;

    @FXML
    private Slider radiusSlider;

    @FXML
    private Slider angleSlider;

    public Slider getRadiusSlider() {
        return radiusSlider;
    }

    public Slider getAngleSlider() {
        return angleSlider;
    }

    @FXML
    void angleSlide(MouseEvent event) {

    }

    @FXML
    void radiusSlide(MouseEvent event) {

    }

    @FXML
    void ApplyOnAction(ActionEvent event) {
        gui.motionBlur(this);
    }

    public void init(GUIController mainGui){
        this.gui=mainGui;
    }
}
