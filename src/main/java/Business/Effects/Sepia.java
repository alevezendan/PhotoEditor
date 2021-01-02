package Business.Effects;

import Business.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.effect.SepiaTone;
public class Sepia implements Effect {
    @Override
    public void apply(ImageView img, double val) {
        SepiaTone s=new SepiaTone();
        s.setLevel(val);
        img.setEffect(s);
    }

    @Override
    public void apply(ImageView img, double val1, double val2) {

    }

    @Override
    public void apply(ImageView img, double val1, double val2, double val3, double val4) {

    }
}
