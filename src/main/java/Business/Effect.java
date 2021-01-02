package Business;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface Effect {
    void apply(ImageView img, double val);

    void apply(ImageView img, double val1, double val2);
    void apply(ImageView img, double val1, double val2,double val3, double val4);

}
