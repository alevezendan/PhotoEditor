package Business.ColorParameters;

import Business.ColorParameter;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;

public class Contrast implements ColorParameter {
    @Override
    public void apply(ImageView img, Double value) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setContrast(value/100);
        img.setEffect(colorAdjust);
    }
}
