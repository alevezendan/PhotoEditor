package Business.ColorParameters;

import Business.ColorParameter;
import javafx.scene.image.ImageView;
import javafx.scene.effect.ColorAdjust;

public class Brightness implements ColorParameter {

    @Override
    public void apply(ImageView img, Double value) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(value/100);
        img.setEffect(colorAdjust);

    }
}
