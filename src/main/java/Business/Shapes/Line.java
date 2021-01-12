package Business.Shapes;

import Business.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
//import javafx.scene.shape.Line;
public class Line implements Shape {
    @Override
    public void draw(Canvas canvas, Color fillColor, Color borderColor, double widthSize, boolean filled, double x1, double y1, double x2, double y2) {
        GraphicsContext graphics_context =canvas.getGraphicsContext2D();
        graphics_context.setStroke(fillColor);
        graphics_context.setLineWidth(widthSize);
        graphics_context.strokeLine(x1,y1,x2,y2);
    }

}
