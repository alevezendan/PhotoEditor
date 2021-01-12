package Business.Shapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;

public class Tools {

    BoxBlur bb = new BoxBlur();
    DropShadow ds = new DropShadow();

    public Rectangle rect(Color fillColor, Color strokeColor, Double posX, Double posY, Double x, Double y, Double lineSize,boolean filled){
        Rectangle rectangle;
        rectangle = new Rectangle(posX, posY, x, y);
        rectangle.setStrokeWidth(lineSize);
        if(filled) {
            rectangle.setFill(fillColor);
            rectangle.setStroke(strokeColor);
        }else {
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(strokeColor);
        }
       // rectangle.setOpacity(opacity/100);

        return rectangle;
    }

    public Rectangle image(Color fillColor, Color strokeColor, Double posX, Double posY, Double x, Double y, Double lineSize, Double opacity, Double blur, Double shadow){
        FileChooser fileChooser = new FileChooser();
        Image imagem = null;
        fileChooser.setTitle("Open image");
        //fileChooser.setInitialDirectory(new File("/home"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG File", "*.png"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG File", "*.jpg"));

        try{
            File file = fileChooser.showOpenDialog(new Stage());
            if(file != null){
                imagem = new Image(file.toURI().toString());

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

    public Rectangle oval(Color fillColor, Color strokeColor, Double posX, Double posY, Double x, Double lineSize,boolean filled){
        Rectangle circle;
        circle = new Rectangle(posX, posY, x, x);
        circle.setStrokeWidth(lineSize);
        if(filled){
            circle.setFill(fillColor);
            circle.setStroke(strokeColor);
        }else{
            circle.setFill(Color.TRANSPARENT);
            circle.setStroke(strokeColor);
        }

        circle.setArcHeight(100000000);
        circle.setArcWidth(100000000);
      //  circle.setOpacity(opacity/100);

        return circle;
    }

    public Line line(Double lineSize, Color strokeColor, Double posX, Double posY, Double p2x, Double p2y){
        Line line = new Line(posX, posY, p2x, p2y);
        line.setStrokeWidth(lineSize);
        line.setStroke(strokeColor);

        return line;
    }

    public Text text(String string, double textSize, Color textColor, String fontName, Double posX, Double posY){
        Text text = new Text(100, 100, string);
        //Double fs = Double.parseDouble(textSize);
        text.setFont(new Font(fontName, textSize));
        text.setFill(textColor);
        text.setX(posX);
        text.setY(posY);



        return text;
    }

    public BoxBlur blurConfig(Double blur){
        bb.setHeight(blur/10);
        bb.setWidth(blur/10);
        bb.setIterations(1);

        return bb;
    }

    public DropShadow dropShadowConfig(Double shadow){
        ds.setHeight(shadow/10);
        ds.setWidth(shadow/10);
        ds.setColor(Color.BLACK);

        return ds;
    }
    public void draw(Canvas canvas, Color fillColor, Color borderColor, double widthSize, boolean filled, double x1, double y1, double x2, double y2) {
        GraphicsContext graphics_context =canvas.getGraphicsContext2D();
        if(filled) {
            graphics_context.setFill(fillColor);
            graphics_context.setStroke(borderColor);
            graphics_context.setLineWidth(widthSize);
            // graphics_context.fillRect(40, 40, 100, 50);
            graphics_context.fillRect(x1,y1,x2-x1,y2-y1);
        }
        else
        {
            graphics_context.setStroke(borderColor);
            graphics_context.setLineWidth(widthSize);
            graphics_context.strokeRect(x1,y1,x2-x1,y2-y1);
        }
    }
}
