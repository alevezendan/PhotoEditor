package Business.Shapes;

import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import java.io.File;

public class Imagee {
    public Rectangle image(Color fillColor, Color strokeColor, Double posX, Double posY, Double x, Double y, Double lineSize, Double opacity, Double blur, Double shadow){
        FileChooser fileChooser = new FileChooser();
        javafx.scene.image.Image imagem = null;
        fileChooser.setTitle("Open image");
        //fileChooser.setInitialDirectory(new File("/home"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG File", "*.png"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG File", "*.jpg"));

        try{
            File file = fileChooser.showOpenDialog(new Stage());
            if(file != null){
                imagem = new javafx.scene.image.Image(file.toURI().toString());

                //ImageIO.write(SwingFXUtils.fromFXImage(snapshot,null), "png", selectedFile);
            }
        } catch (Exception e){

        }


        Rectangle rectangle;
        rectangle = new Rectangle(posX, posY, x, y);
        rectangle.setStrokeWidth(lineSize);
        rectangle.setFill(new ImagePattern(imagem));
        rectangle.setStroke(strokeColor);
        rectangle.setOpacity(opacity/100);

        return rectangle;
    }

}
