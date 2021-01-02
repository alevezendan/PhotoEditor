package Business.Filters;

import Business.Filter;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public class Blur implements Filter {

    public Blur(){

    }

    @Override
    public void apply(ImageView source, double val) {
        BoxBlur blur=new BoxBlur();
        blur.setIterations((int)val);
        source.setEffect(blur);
    }

    @Override
    public void apply(ImageView source, double val1, double val2) {

    }
}
