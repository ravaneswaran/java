package rave.code.utility.image;

import org.junit.jupiter.api.Test;
import rave.code.utility.image.greyscale.BlackAndWhite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestBlackAndWhite {

    @Test
    public void testMake(){
        String fileFullPath = "/home/ravaneswaran/github/java/utilities/java-image/src/test/resources/test-input-image.jpg";
        BlackAndWhite blackAndWhite = new BlackAndWhite(fileFullPath);
        BufferedImage bufferedImage = blackAndWhite.apply();

        assertNotNull(bufferedImage);

        try {
            File file = new File("output-rectangular-border.png");
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
