package rave.code.utility.image.border;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoundedBorder extends RectangularBorder{

    private static final Logger LOGGER = Logger.getLogger(RoundedBorder.class.getName());

    public RoundedBorder(String filePath, int borderWidth) {
        super(filePath, borderWidth);
    }

    public RoundedBorder(String filePath, int borderWidth, Color borderColor) {
        super(filePath, borderWidth, borderColor);
    }

    public BufferedImage apply() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(this.filePath));
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }

        if (null != image) {
            BufferedImage result = new BufferedImage(
                    image.getWidth() + this.borderWidth * 2,
                    image.getHeight() + this.borderWidth * 2,
                    BufferedImage.TYPE_INT_ARGB);

            Graphics2D g = result.createGraphics();

            g.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(10));
            g.drawImage(image, this.borderWidth, this.borderWidth, null);

            g.drawRoundRect(5, 5, image.getWidth(), image.getHeight(), 5, 5);

            g.dispose();

            return result;
        } else {
            return null;
        }
    }
}
