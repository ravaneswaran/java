package rave.code.utility.image.border;

import rave.code.utility.image.Applier;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RectangularBorder implements Applier {

    private static final Logger LOGGER = Logger.getLogger(RectangularBorder.class.getName());

    protected String filePath;
    protected int borderWidth;
    protected Color borderColor;

    public RectangularBorder(String filePath, int borderWidth) {
        this.filePath = filePath;
        this.borderWidth = borderWidth;
        this.borderColor = Color.WHITE;
    }

    public RectangularBorder(String filePath, int borderWidth, Color borderColor) {
        this.filePath = filePath;
        this.borderWidth = borderWidth;
        this.borderColor = borderColor;
    }

    @Override
    public BufferedImage apply() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(this.filePath));
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }

        if (null != image) {
            //int border = 5;
            BufferedImage result = new BufferedImage(
                    image.getWidth() + this.borderWidth * 2,
                    image.getHeight() + this.borderWidth * 2,
                    BufferedImage.TYPE_INT_ARGB);

            Graphics2D g = result.createGraphics();

            // Fill border color
            g.setColor(this.borderColor);
            g.fillRect(0, 0, result.getWidth(), result.getHeight());

            // Draw original image
            g.drawImage(image, this.borderWidth, this.borderWidth, null);

            g.dispose();

            return result;
        } else {
            return null;
        }
    }
}
