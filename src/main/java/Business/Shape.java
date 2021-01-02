package Business;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.awt.*;

public interface Shape {

   void draw(Canvas canvas, Color fillColor,Color borderColor,double widthSize,boolean filled,double x1,double y1, double x2, double y2);
}
