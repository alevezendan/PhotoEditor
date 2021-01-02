package Business;

import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public interface Filter extends Serializable {

    void apply(ImageView source,double val);
    void apply(ImageView source,double val1,double val2);

    // BufferedImage transform(BufferedImage src, BufferedImage dest);
}
