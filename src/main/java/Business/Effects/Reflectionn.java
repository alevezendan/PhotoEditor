package Business.Effects;

import Business.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.effect.Reflection;

public class Reflectionn implements Effect {
    @Override
    public void apply(ImageView img, double val) {

    }

    @Override
    public void apply(ImageView img, double val1, double val2) {

    }

    @Override
    public void apply(ImageView img, double val1, double val2, double val3, double val4) {
        Reflection r=new Reflection();
        r.setBottomOpacity(val1);
        r.setTopOpacity(val2);
        r.setTopOffset(val3);
        r.setFraction(val4);
        img.setEffect(r);

    }
}
