package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;

public class BRIGHTController extends  Controller{

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

    public Spinner<Integer> getSpinner() {
        return spinner;
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
        System.out.println(brightSlider.getValue());

    }

    /*@FXML
    void spin(MouseEvent event) {
       // spinner.increment();
        //System.out.println(spinner.getValue());
    }*/
}

