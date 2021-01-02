package Business.Effects;

import Business.Effect;
import Business.Filter;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.ImageView;

public class MBlur implements Effect {
    @Override
    public void apply(ImageView source, double val) {

    }

    @Override
    public void apply(ImageView source, double val1, double val2) {
        MotionBlur m=new MotionBlur();
        m.setAngle(val2);
        m.setRadius(val1);
        source.setEffect(m);
    }

    @Override
    public void apply(ImageView img, double val1, double val2, double val3, double val4) {

    }
}
