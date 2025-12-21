package rave.code.utility.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface QRCode {

    public BufferedImage createImage(String data, String charset, int imageWidth, int imageHeight) throws Exception;

    public String scanImage(BufferedImage bufferedImage) throws Exception;

    public File writeToFile(BufferedImage bufferedImage, Path path) throws IOException;
}
