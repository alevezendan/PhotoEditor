package Presentation;

import Business.ColorParameters.Brightness;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.input.TouchEvent;

public class BRIGHTController {

    private GUIController gui;

    @FXML
    private Slider brightSlider;

    @FXML
    private Spinner<Integer> spinner;

    public void init(GUIController mainGui) {
        this.gui = mainGui;
    }

    public Slider getBrightSlider() {
        return brightSlider;
    }

    @FXML
    void sw(SwipeEvent event) {
        System.out.println(brightSlider.getValue());
       spinner.setPrefSize(-100.0,100.0);
       SpinnerValueFactory<Integer> val= spinner.getValueFactory();

    }

    @FXML
    void applyBtnAction(ActionEvent event) {
        gui.inflateB(this);
    }

    @FXML
    void slider(MouseEvent event) {
        System.out.println((int)brightSlider.getValue());
    }

    /*@FXML
    void spin(MouseEvent event) {
       // spinner.increment();
        //System.out.println(spinner.getValue());
    }*/
}

