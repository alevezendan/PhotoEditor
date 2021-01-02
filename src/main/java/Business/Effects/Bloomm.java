package Business.Effects;

import Business.Effect;
import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bloomm implements Effect {
    @Override
    public void apply(ImageView img, double val) {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(50.0f);
        rectangle.setY(80.0f);
        rectangle.setWidth(500.0f);
        rectangle.setHeight(120.0f);
        rectangle.setFill(Color.TEAL);
        Bloom bloom = new Bloom();
        bloom.setThreshold(val);
       img.setEffect(bloom);
    }

    @Override
    public void apply(ImageView img, double val1, double val2) {

    }

    @Override
    public void apply(ImageView img, double val1, double val2, double val3, double val4) {

    }
}
