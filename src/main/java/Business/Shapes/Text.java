package Business.Shapes;

import Business.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;

public class Text  implements Shape {
    @Override
    public void draw(Canvas canvas, Color fillColor, Color borderColor, double widthSize, boolean filled, double x1, double y1, double x2, double y2) {

    }
    public void setText(Canvas canvas,String text,String font,double size, Color textColor,double posX, double posY){
        GraphicsContext graphics_context =canvas.getGraphicsContext2D();

        javafx.scene.text.Text t=new javafx.scene.text.Text();
       // t.setText(text);
       // t.setFont(new Font(font,size));
        //t.setFill(textColor);
        graphics_context.setFont(new Font(font,size));

        graphics_context.setFill(textColor);
        graphics_context.fillText(text,posX,posY);

    }

    public void clear(Canvas canvas,String oldText,String newText,String font,double size, Color textColor,Color bgColor,double posX, double posY){
        GraphicsContext graphics_context =canvas.getGraphicsContext2D();
        graphics_context.setFill(bgColor);
        graphics_context.fillText(oldText,posX,posY);
        graphics_context.setFont(new Font(font,size));
        graphics_context.setFill(textColor);
        graphics_context.fillText(newText,posX,posY);

    }
}
