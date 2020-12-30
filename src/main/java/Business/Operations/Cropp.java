package Business.Operations;

import Business.Operation;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ContextMenu;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Cropp implements Operation {


    RubberBandSelection rubberBandSelection;
    Group imageLayer ;
    ContextMenu contextMenu ;
    Bounds selectionBounds;
    ScrollPane scrollPane;

    public Bounds getSelectionBounds() {
        return selectionBounds;
    }

    public RubberBandSelection getRubberBandSelection() {
        return rubberBandSelection;
    }

    public Cropp(ImageView img){
        imageLayer=new Group();
        contextMenu=new ContextMenu();
        scrollPane=new ScrollPane();
       // selectionBounds = rubberBandSelection.getBounds();
        imageLayer.getChildren().add(img);
       // scrollPane.se

        imageLayer.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isSecondaryButtonDown()) {
                    contextMenu.show(imageLayer, event.getScreenX(), event.getScreenY());
                }
            }
        });
        rubberBandSelection = new RubberBandSelection(imageLayer);
    }
    @Override
    public void apply(ImageView source) {
        //imageLayer.setAutoSizeChildren(false);


       // rubberBandSelection = new RubberBandSelection(imageLayer);
        Bounds selectionBounds = rubberBandSelection.getBounds();
        crop(selectionBounds,source);

        //crop(source);
    }

    public void init(ImageView source){
        imageLayer.getChildren().add(source);
        imageLayer.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isSecondaryButtonDown()) {
                    contextMenu.show(imageLayer, event.getScreenX(), event.getScreenY());
                }
            }
        });

        rubberBandSelection = new RubberBandSelection(imageLayer);
    }
    /*public void crop(ImageView img){
        img.setOnMouseClicked(this::handleClick);
        PixelReader pixelReader = img.getPixelReader();
        buffer = new byte[width * height * 4];
        pixelReader.getPixels(0, 0,
                width, height,
                PixelFormat.getByteBgraInstance(),
                buffer,
                0,
                4*width);

        WritableImage writableImage = new WritableImage(width, height);
        pixelWriter = writableImage.getPixelWriter();
        offset = 4*(ulx+width*uly);
        drawImage();

        VBox vbox = new VBox(new ImageView(writableImage));
    }*/
    public ImageView crop(Bounds bounds,ImageView source) {
        //init(source);
        System.out.println( "Selected area: " + selectionBounds);
        ImageView imageView = new ImageView();
        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        parameters.setViewport(new Rectangle2D(bounds.getMinX(), bounds.getMinY(), width, height));

        WritableImage wi = new WritableImage(width, height);
        imageView.snapshot(parameters, wi);
        return imageView;

    }
}
       /* BufferedImage bufImageARGB = SwingFXUtils.fromFXImage(wi, null);
        BufferedImage bufImageRGB = new BufferedImage(bufImageARGB.getWidth(), bufImageARGB.getHeight(), BufferedImage.OPAQUE);

        Graphics2D graphics = bufImageRGB.createGraphics();
        graphics.drawImage(bufImageARGB, 0, 0, null);

        try {

            ImageIO.write(bufImageRGB, "jpg", file);

            System.out.println( "Image saved to " + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        graphics.dispose();*/






