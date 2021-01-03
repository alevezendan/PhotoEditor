package Business.Shapes;

import Business.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    @Override
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
