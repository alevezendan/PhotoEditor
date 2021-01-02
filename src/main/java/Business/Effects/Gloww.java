package Business.Effects;

import Business.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.effect.Glow;

public class Gloww implements Effect {
    @Override
    public void apply(ImageView img, double val) {
            Glow g=new Glow();
            g.setLevel(val);
            img.setEffect(g);
    }

    @Override
    public void apply(ImageView img, double val1, double val2) {

    }

    @Override
    public void apply(ImageView img, double val1, double val2, double val3, double val4) {

    }
}
