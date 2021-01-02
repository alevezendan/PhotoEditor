package Business.Effects;

import Business.Effect;
import Business.Filter;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;

public class GBlur implements Effect {
    @Override
    public void apply(ImageView source, double val) {
        GaussianBlur g=new GaussianBlur();
        g.setRadius(val);
        source.setEffect(g);
    }

    @Override
    public void apply(ImageView source, double val1, double val2) {

    }

    @Override
    public void apply(ImageView img, double val1, double val2, double val3, double val4) {

    }
}
