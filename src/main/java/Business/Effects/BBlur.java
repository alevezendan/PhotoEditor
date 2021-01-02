package Business.Effects;

import Business.Effect;
import Business.Filter;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.awt.image.BufferedImage;

public class BBlur implements Effect {

    @Override
    public void apply(ImageView source, double val) {
        /*BoxBlur blur=new BoxBlur();
        blur.setIterations((int)val);
        source.setEffect(blur);*/
        //Circle circle = new Circle();

        //Setting the centre of the circle
       // circle.setCenterX(300.0f);
        //circle.setCenterY(160.0f);

        //Setting the radius of the circle
        //circle.setRadius(100.0f);

        //Instantiating the Shadow class
       // DropShadow dropShadow = new DropShadow();
        //Shadow s=new Shadow();
        InnerShadow s=new InnerShadow();
        //setting the type of blur for the shadow
        //dropShadow.setBlurType(BlurType.GAUSSIAN);

        //Setting color for the shadow
       // dropShadow.setColor(Color.GRAY);
        s.setColor(Color.GRAY);
        //Setting the height of the shadow
        //dropShadow.setHeight(5);

        //Setting the width of the shadow
       // dropShadow.setWidth(5);

        //Setting the radius of the shadow
        //dropShadow.setRadius(5);

        //setting the offset of the shadow
        s.setOffsetX(10.0);
        s.setOffsetY(10.0);
        //s.setRadius(val);
        //Setting the spread of the shadow
        //dropShadow.setSpread(12);

        //Applying shadow effect to the text
        source.setEffect(s);

        //Applying shadow effect to the circle
        //circle.setEffect(dropShadow);

    }

    @Override
    public void apply(ImageView source, double val1, double val2) {

    }

    @Override
    public void apply(ImageView img, double val1, double val2, double val3, double val4) {

    }
}
