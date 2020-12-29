package Business.Operations;

import Business.Operation;
import javafx.scene.image.ImageView;

public class FlipVertical implements Operation {
    @Override
    public  void apply(ImageView source) {
        source.scaleXProperty().set(-source.getScaleX());
       // return source;
    }
}
