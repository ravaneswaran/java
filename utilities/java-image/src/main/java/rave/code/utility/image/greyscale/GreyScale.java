package rave.code.utility.image.greyscale;

import rave.code.utility.image.Applier;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GreyScale implements Applier {

    private static final Logger LOGGER = Logger.getLogger(GreyScale.class.getName());

    private final String fileFullPath;

    public GreyScale(String fileFullPath){
        this.fileFullPath = fileFullPath;
    }

    @Override
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
                    BufferedImage.TYPE_BYTE_GRAY);

            Graphics g = result.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();

            return result;
        } else {
            return null;
        }
    }
}
