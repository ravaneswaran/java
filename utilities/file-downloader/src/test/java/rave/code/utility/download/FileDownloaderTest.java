package rave.code.utility.download;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class FileDownloaderTest {

    @Test
    public void validTestDownload() throws IOException {
        String url = "https://www.bseindia.com/download/BhavCopy/Equity/BhavCopy_BSE_CM_0_0_0_20250813_F_0000.CSV";
        FileDownloader fileDownload = new FileDownloader();
        InputStream inputStream = fileDownload.downloadFile(url);
        assertTrue(null != inputStream);
    }

    @Test
    public void invalidTestDownload() {
        String url = "https://www.bseindia.com/download/BhavCopy/Equity/resource-not-found";
        FileDownloader fileDownload = new FileDownloader();
        InputStream inputStream = null;
        try {
            inputStream = fileDownload.downloadFile(url);
        } catch (IOException e) {
        }
        assertTrue(null != inputStream);
    }
}
