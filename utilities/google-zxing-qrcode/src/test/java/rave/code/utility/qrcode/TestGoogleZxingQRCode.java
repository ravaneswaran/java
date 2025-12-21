package rave.code.utility.qrcode;

import org.junit.jupiter.api.Test;
import rave.code.utility.qrcode.google.GoogleZxingQRCode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGoogleZxingQRCode {

    @Test
    public void testCreateImage() throws Exception {
        String data = "test";
        String charset = Charset.defaultCharset().toString();
        int imageWidth = 450;
        int imageHeight = 450;

        GoogleZxingQRCode googleZxingQRCode = new GoogleZxingQRCode();
        BufferedImage bufferedImage = googleZxingQRCode.createImage(data, charset, imageWidth, imageHeight);

        assertNotNull(bufferedImage);
    }

    @Test
    public void testScanImage() throws Exception {
        String data = "test";
        String charset = Charset.defaultCharset().toString();
        int imageWidth = 450;
        int imageHeight = 450;
        GoogleZxingQRCode googleZxingQRCode = new GoogleZxingQRCode();
        BufferedImage bufferedImage = googleZxingQRCode.createImage(data, charset, imageWidth, imageHeight);

        String dataContent = googleZxingQRCode.scanImage(bufferedImage);

        assertNotNull(dataContent);
        assertTrue(!"".equals(dataContent));
        assertTrue("test".equals(dataContent));
    }

    @Test
    public void testWriteToFile() throws Exception {
        String data = "test";
        String charset = Charset.defaultCharset().toString();
        int imageWidth = 450;
        int imageHeight = 450;
        GoogleZxingQRCode googleZxingQRCode = new GoogleZxingQRCode();
        BufferedImage bufferedImage = googleZxingQRCode.createImage(data, charset, imageWidth, imageHeight);
        Path path = Paths.get("/home/ravaneswaran/Pictures");

        File outFile = googleZxingQRCode.writeToFile(bufferedImage, path);

        assertNotNull(outFile);
    }
}
