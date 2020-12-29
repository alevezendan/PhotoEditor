package Business.Operations;

import Business.Operation;
import javafx.scene.image.ImageView;

public class RotateClockwise implements Operation {
    @Override
    public void apply(ImageView source) {
        source.setRotate(source.getRotate()+90);
    }
}
