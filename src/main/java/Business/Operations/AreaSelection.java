package Business.Operations;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class AreaSelection {

    private Group group;
    private Crop crop;
    private ResizableRectangle selectionRectangle = null;
    private double rectangleStartX;
    private double rectangleStartY;
    private Paint darkAreaColor = Color.color(0,0,0,0.5);


    public ResizableRectangle selectArea(Group group) {
        this.group = group;

        // group.getChildren().get(0) == mainImageView. We assume image view as base container layer
        if (crop.getMainImageView() != null) {
            this.group.getChildren().get(0).addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);
            this.group.getChildren().get(0).addEventHandler(MouseEvent.MOUSE_DRAGGED, onMouseDraggedEventHandler);
            this.group.getChildren().get(0).addEventHandler(MouseEvent.MOUSE_RELEASED, onMouseReleasedEventHandler);
        }

        return selectionRectangle;
    }

    EventHandler<MouseEvent> onMousePressedEventHandler = event -> {
        if (event.isSecondaryButtonDown())
            return;

        rectangleStartX = event.getX();
        rectangleStartY = event.getY();

        crop.clearSelection(group);

        selectionRectangle = new ResizableRectangle(rectangleStartX, rectangleStartY, 0, 0, group);

        darkenOutsideRectangle(selectionRectangle);

    };

    EventHandler<MouseEvent> onMouseDraggedEventHandler = event -> {
        if (event.isSecondaryButtonDown())
            return;

        double offsetX = event.getX() - rectangleStartX;
        double offsetY = event.getY() - rectangleStartY;

        if (offsetX > 0) {
            if (event.getX() > crop.getMainImageView().getImage().getWidth())
                selectionRectangle.setWidth(crop.getMainImageView().getImage().getWidth() - rectangleStartX);
            else
                selectionRectangle.setWidth(offsetX);
        } else {
            if (event.getX() < 0)
                selectionRectangle.setX(0);
            else
                selectionRectangle.setX(event.getX());
            selectionRectangle.setWidth(rectangleStartX - selectionRectangle.getX());
        }

        if (offsetY > 0) {
            if (event.getY() > crop.getMainImageView().getImage().getHeight())
                selectionRectangle.setHeight(crop.getMainImageView().getImage().getHeight() - rectangleStartY);
            else
                selectionRectangle.setHeight(offsetY);
        } else {
            if (event.getY() < 0)
                selectionRectangle.setY(0);
            else
                selectionRectangle.setY(event.getY());
            selectionRectangle.setHeight(rectangleStartY - selectionRectangle.getY());
        }

    };

    EventHandler<MouseEvent> onMouseReleasedEventHandler = event -> {
        if (selectionRectangle != null)
            crop.setAreaSelected(true);
    };


    private void darkenOutsideRectangle(Rectangle rectangle) {
        Rectangle darkAreaTop = new Rectangle(0,0,darkAreaColor);
        Rectangle darkAreaLeft = new Rectangle(0,0,darkAreaColor);
        Rectangle darkAreaRight = new Rectangle(0,0,darkAreaColor);
        Rectangle darkAreaBottom = new Rectangle(0,0,darkAreaColor);

        darkAreaTop.widthProperty().bind(crop.getMainImageView().getImage().widthProperty());
        darkAreaTop.heightProperty().bind(rectangle.yProperty());

        darkAreaLeft.yProperty().bind(rectangle.yProperty());
        darkAreaLeft.widthProperty().bind(rectangle.xProperty());
        darkAreaLeft.heightProperty().bind(rectangle.heightProperty());

        darkAreaRight.xProperty().bind(rectangle.xProperty().add(rectangle.widthProperty()));
        darkAreaRight.yProperty().bind(rectangle.yProperty());
        darkAreaRight.widthProperty().bind(crop.getMainImageView().getImage().widthProperty().subtract(
                rectangle.xProperty().add(rectangle.widthProperty())));
        darkAreaRight.heightProperty().bind(rectangle.heightProperty());

        darkAreaBottom.yProperty().bind(rectangle.yProperty().add(rectangle.heightProperty()));
        darkAreaBottom.widthProperty().bind(crop.getMainImageView().getImage().widthProperty());
        darkAreaBottom.heightProperty().bind(crop.getMainImageView().getImage().heightProperty().subtract(
                rectangle.yProperty().add(rectangle.heightProperty())));

        // adding dark area rectangles before the selectionRectangle. So it can't overlap rectangle
        group.getChildren().add(1,darkAreaTop);
        group.getChildren().add(1,darkAreaLeft);
        group.getChildren().add(1,darkAreaBottom);
        group.getChildren().add(1,darkAreaRight);

        // make dark area container layer as well
        darkAreaTop.addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);
        darkAreaTop.addEventHandler(MouseEvent.MOUSE_DRAGGED, onMouseDraggedEventHandler);
        darkAreaTop.addEventHandler(MouseEvent.MOUSE_RELEASED, onMouseReleasedEventHandler);

        darkAreaLeft.addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);
        darkAreaLeft.addEventHandler(MouseEvent.MOUSE_DRAGGED, onMouseDraggedEventHandler);
        darkAreaLeft.addEventHandler(MouseEvent.MOUSE_RELEASED, onMouseReleasedEventHandler);

        darkAreaRight.addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);
        darkAreaRight.addEventHandler(MouseEvent.MOUSE_DRAGGED, onMouseDraggedEventHandler);
        darkAreaRight.addEventHandler(MouseEvent.MOUSE_RELEASED, onMouseReleasedEventHandler);

        darkAreaBottom.addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);
        darkAreaBottom.addEventHandler(MouseEvent.MOUSE_DRAGGED, onMouseDraggedEventHandler);
        darkAreaBottom.addEventHandler(MouseEvent.MOUSE_RELEASED, onMouseReleasedEventHandler);
    }
}
