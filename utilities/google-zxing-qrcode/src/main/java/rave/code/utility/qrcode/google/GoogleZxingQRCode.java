package rave.code.utility.qrcode.google;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import rave.code.utility.qrcode.QRCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

public class GoogleZxingQRCode implements QRCode {

    public BufferedImage createImage(String data, String charset, int imageWidth, int imageHeight) throws Exception {
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, imageWidth, imageHeight);

        return MatrixToImageWriter.toBufferedImage(matrix);
    }

    public String scanImage(BufferedImage bufferedImage) throws Exception {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(bufferedImage)));
        Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
        return qrCodeResult.getText();
    }

    public File writeToFile(BufferedImage bufferedImage, Path path) throws IOException {
        long time = new Date().getTime();
        String fileName = String.format("qr-code-%s.%s", time, "png");
        File outputFile = new File(String.format("%s/%s", path.toFile().getAbsolutePath(), fileName));
        ImageIO.write(bufferedImage, "png", outputFile);
        return outputFile;
    }
}
