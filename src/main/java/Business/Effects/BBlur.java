package Business.Effects;

import Business.Effect;
import Business.Filter;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.awt.image.BufferedImage;

public class BBlur implements Effect {

    @Override
    public void apply(ImageView source, double val) {
        BoxBlur blur=new BoxBlur();
        blur.setIterations((int)val);
        source.setEffect(blur);

    }

    @Override
    public void apply(ImageView source, double val1, double val2) {

    }

    @Override
    public void apply(ImageView img, double val1, double val2, double val3, double val4) {

    }
}
