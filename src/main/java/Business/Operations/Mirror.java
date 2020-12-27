package Business.Operations;

import Business.Operation;

import java.awt.image.BufferedImage;

public class Mirror implements Operation {
    @Override
    public Object apply(Object source) {
        BufferedImage simg=(BufferedImage)source;
        int width = simg.getWidth();
        int height = simg.getHeight();
        BufferedImage mimg = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);

        // Create mirror image pixel by pixel
        for (int y = 0; y < height; y++)
        {
            for (int lx = 0, rx = width - 1; lx < width; lx++, rx--)
            {
                // lx starts from the left side of the image
                // rx starts from the right side of the image
                // lx is used since we are getting pixel from left side
                // rx is used to set from right side
                // get source pixel value
                int p = simg.getRGB(lx, y);

                // set mirror image pixel value
                mimg.setRGB(rx, y, p);
            }
        }
        return mimg;
    }
}
