package Business.Filters;

import Business.Filter;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.awt.image.BufferedImage;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class RGBFilter implements Filter {
    @Override
    public void apply(ImageView source, double val) {
        BufferedImage bimage = new BufferedImage((int)source.getImage().getWidth(), (int)source.getImage().getHeight(), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        //bGr.drawImage((Image)source.getImage(), 0, 0, null);
       // bGr.dispose();

        for(int i=0;i<source.getFitWidth();i++){
            for(int j=0;j<source.getFitHeight();j++){
               // int p=getRGB
            }
        }
        PixelReader pixelReader = source.getImage().getPixelReader();
       // System.out.println("Image Width: "+source.getImage().getWidth());
       // System.out.println("Image Height: "+source.getImage().getHeight());
        // Create WritableImage
        WritableImage wImage = new WritableImage(
                (int)source.getImage().getWidth(),
                (int)source.getImage().getHeight());
        PixelWriter pixelWriter = wImage.getPixelWriter();
       /* for (int y = 0; y < source.getImage().getHeight(); y++)
        {
            for (int x = 0; x < source.getImage().getWidth(); x++)
            {
                javafx.scene.paint.Color color = pixelReader.getColor(x, y);
                if (y < 10)
                    color = Color.RED;
                pixelWriter.setColor(x,y,color);
            }
        }
        source.setImage(wImage);*/
       for (int y = 0; y < source.getImage().getHeight(); y++)
        {
            for (int x = 0; x < source.getImage().getWidth(); x++)
            {
                Color color = pixelReader.getColor(x, y);
                double r = color.getRed();
                double g = color.getGreen();
                double b = color.getBlue();
                if ((r < g) && (g < b) && (b*255 < 100))
                {
// Flip the red and the blue
                    r = color.getBlue();
                    b = color.getRed();
                    int red = (int) (r * 255);
                    int green = (int) (g * 255);
                    int blue = (int) (b * 255);
                    color = Color.rgb(red,green,blue);
                }
                pixelWriter.setColor(x,y,color);
            }
        }
        source.setImage(wImage);
        /*for (int y = 0; y < source.getImage().getHeight(); y++)
        {
            for (int x = 0; x < source.getImage().getWidth(); x++)
            {
                Color color = pixelReader.getColor(x, y);
                double r = color.getRed();
                double g = color.getGreen();
                double b = color.getBlue();
                int red = (int) ((r + g + b)/3 * 255);
                int green = (int) ((r + g + b)/3 * 255);
                int blue = (int) ((r + g + b)/3 * 255);
                color = Color.rgb(red,green,blue);
                pixelWriter.setColor(x,y,color);
            }
        }
        source.setImage(wImage);*/

    }

    @Override
    public void apply(ImageView source, double val1, double val2) {

    }
}
