package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class REFLController extends Controller {

    private GUIController gui;


    @FXML
    private Slider bottOpSlider;

    @FXML
    private Slider topOpSlider;

    @FXML
    private Slider topOffSlider;

    @FXML
    private Slider frSlider;

    public Slider getBottOpSlider() {
        return bottOpSlider;
    }

    public Slider getTopOpSlider() {
        return topOpSlider;
    }

    public Slider getTopOffSlider() {
        return topOffSlider;
    }

    public Slider getFrSlider() {
        return frSlider;
    }

    public void init(GUIController mainGui) {
        this.gui = mainGui;
    }

    @FXML
    void ApplyOnAction(ActionEvent event) {
        gui.refl(this);
    }

    @FXML
    void bottOpSlide(MouseEvent event) {

    }

    @FXML
    void frSlide(MouseEvent event) {

    }

    @FXML
    void topOpSlide(MouseEvent event) {

    }
}