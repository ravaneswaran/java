package rave.code.utility.image.greyscale;

import rave.code.utility.image.Applier;
import rave.code.utility.image.border.RectangularBorder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlackAndWhite implements Applier {

    private static final Logger LOGGER = Logger.getLogger(RectangularBorder.class.getName());

    private final String fileFullPath;

    public BlackAndWhite(String fileFullPath){
        this.fileFullPath = fileFullPath;
    }

    public BufferedImage apply() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(this.fileFullPath));
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }

        if (null != image) {
            BufferedImage result = new BufferedImage(
                    image.getWidth(),
                    image.getHeight(),
                    BufferedImage.TYPE_BYTE_BINARY);

            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {

                    Color color = new Color(image.getRGB(x, y));

                    int gray = (color.getRed()
                            + color.getGreen()
                            + color.getBlue()) / 3;

                    if (gray > 128) {
                        result.setRGB(x, y, Color.WHITE.getRGB());
                    } else {
                        result.setRGB(x, y, Color.BLACK.getRGB());
                    }
                }
            }
            return result;
        } else {
            return null;
        }
    }
}
