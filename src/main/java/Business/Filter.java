package Business;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public interface Filter extends Serializable {
    Object apply(Object source);

     BufferedImage transform(BufferedImage src, BufferedImage dest);
}
