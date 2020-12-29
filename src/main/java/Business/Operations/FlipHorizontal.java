package Business.Operations;

import Business.Operation;
import javafx.scene.image.ImageView;

public class FlipHorizontal implements Operation {
    @Override
    public void apply(ImageView source) {
        source.scaleYProperty().set(-source.getScaleY());
    }
}
