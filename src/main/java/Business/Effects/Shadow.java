package Business.Effects;

import Business.Effect;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Shadow implements Effect {
    @Override
    public void apply(ImageView img, double val) {
        DropShadow shadow=new DropShadow();
       shadow.setBlurType(BlurType.GAUSSIAN);
        shadow.setColor(Color.GRAY);
        shadow.setHeight(img.getFitHeight());
        shadow.setWidth(img.getFitWidth());
        shadow.setOffsetX(val);
        shadow.setOffsetY(val);
        img.setEffect(shadow);
    }

    @Override
    public void apply(ImageView img, double val1, double val2) {

    }

    @Override
    public void apply(ImageView img, double val1, double val2, double val3, double val4) {

    }
}
