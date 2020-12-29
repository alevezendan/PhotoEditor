package Business.Operations;

import Business.Operation;
import javafx.scene.image.ImageView;

public class ZoomOut implements Operation {
    @Override
    public void apply(ImageView source) {
        source.setFitWidth( source.getFitWidth()-2);
        source.setFitHeight( source.getFitHeight()-2);
    }
}
