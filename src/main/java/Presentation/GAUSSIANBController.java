package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class GAUSSIANBController extends Controller {

    private GUIController gui;
    public Slider getSlider() {
        return slider;
    }

    @FXML
    private Slider slider;

    @FXML
    void ApplyBtnAction(ActionEvent event) {
            gui.gaussBlur(this);
    }

    @FXML
    void slide(MouseEvent event) {
        gui.gaussBlur(this);

    }
    public void init(GUIController mainGui){
        this.gui=mainGui;
    }


}
