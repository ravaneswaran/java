package rave.code.utility.image;

import org.junit.jupiter.api.Test;
import rave.code.utility.image.border.RoundedBorder;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestRoundedBorder {

    @Test
    public void testApply(){
        String filePath = "/home/ravaneswaran/github/java/utilities/java-image/src/test/resources/test-input-image.jpg";
        Color broderColor = new Color(128, 0, 32);
        RoundedBorder roundedBorder = new RoundedBorder(filePath, 5, broderColor);
        BufferedImage bufferedImage = roundedBorder.apply();
        assertNotNull(bufferedImage);
    }

}
