package Business.Shapes;

import Business.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.Math.abs;

public class Circle implements Shape {
    @Override
    public void draw(Canvas canvas, Color fillColor, Color borderColor, double widthSize, boolean filled, double x1, double y1, double x2, double y2) {
        GraphicsContext graphics_context =canvas.getGraphicsContext2D();

        //graphics_context.setFill(fillColor);
       // graphics_context.setStroke(borderColor);
        if(filled){
            graphics_context.setFill(fillColor);
            graphics_context.setStroke(borderColor);
            graphics_context.setLineWidth(widthSize);
           // graphics_context.strokeOval(x1, y1, abs(x2-x1),abs(x2-x1) );
            graphics_context.fillOval(x1, y1, abs(x2-x1),abs(x2-x1) );

        }
        else
        {
            graphics_context.setStroke(fillColor);
            graphics_context.strokeOval(x1,y1,abs(x2-x1),abs(x2-x1));
        }
    }
}
