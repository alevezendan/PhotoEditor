package Business.Shapes;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class Layer {

    private Pane mainPane;
    private ComboBox<Integer> cbLayer;
    public Layer(Pane mainePane, ComboBox<Integer> cbLayer){
        this.cbLayer=cbLayer;
        this.mainPane=mainePane;
    }

    public void layerCount() {
        cbLayer.getItems().clear();
        for(int i = 0; i<mainPane.getChildren().size();i++) {
            cbLayer.getItems().add(i);
        }
    }
}
