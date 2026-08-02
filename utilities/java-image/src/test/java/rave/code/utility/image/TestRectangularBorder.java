package rave.code.utility.image;

import org.junit.jupiter.api.Test;
import rave.code.utility.image.border.RectangularBorder;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestRectangularBorder {

    @Test
    public void testApply(){
        String filePath = "/home/ravaneswaran/github/java/utilities/java-image/src/test/resources/test-input-image.jpg";
        RectangularBorder borderMaker = new RectangularBorder(filePath, 10);
        BufferedImage bufferedImage = borderMaker.apply();
        assertNotNull(bufferedImage);
    }
}
