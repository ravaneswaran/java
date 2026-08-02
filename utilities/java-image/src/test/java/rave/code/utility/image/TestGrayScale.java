package rave.code.utility.image;

import org.junit.jupiter.api.Test;
import rave.code.utility.image.greyscale.BlackAndWhite;
import rave.code.utility.image.greyscale.GreyScale;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestGrayScale {

    @Test
    public void testMake(){
        String fileFullPath = "/home/ravaneswaran/github/java/utilities/java-image/src/test/resources/test-input-image.jpg";
        GreyScale greyScale = new GreyScale(fileFullPath);
        BufferedImage bufferedImage = greyScale.apply();
        assertNotNull(bufferedImage);
    }
}
