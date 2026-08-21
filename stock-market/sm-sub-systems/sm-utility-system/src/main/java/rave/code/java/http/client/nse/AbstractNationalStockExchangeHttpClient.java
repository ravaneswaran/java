package rave.code.java.http.client.nse;

import org.brotli.dec.BrotliInputStream;
import rave.code.java.date.StockMarketDate;
import rave.code.java.http.client.AbstractStockMarketHttpClient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

public abstract class AbstractNationalStockExchangeHttpClient extends AbstractStockMarketHttpClient {

    private String homePageUrl = "https://www.nseindia.com";

    private static final Logger LOGGER = Logger.getLogger(AbstractNationalStockExchangeHttpClient.class.getName());

    public AbstractNationalStockExchangeHttpClient() {
        super();
        this.homePageUrl = "https://www.nseindia.com";
    }

    public HttpResponse<String> gotoHomePage() throws IOException, InterruptedException {
        HttpRequest request = this.buildHttpRequest(this.homePageUrl);
        return this.stringResponseOf(this.homePageUrl);
    }

    public File getFile(String url) throws IOException, InterruptedException {
        String fileName = String.format("downloaded-file-%s.csv", StockMarketDate.getInstance().now().getTime());
        HttpResponse<InputStream> response = this.inputStreamResponseOf(url);
        if (response.statusCode() == 200) {
            byte[] body = response.body().readAllBytes();

            // If gzip-encoded, decompress
            String encoding = response.headers().firstValue("Content-Encoding").orElse("");
            if ("gzip".equalsIgnoreCase(encoding)) {
                try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(body))) {
                    body = gis.readAllBytes();
                }
            }
            if ("br".equalsIgnoreCase(encoding)) {
                try (BrotliInputStream bis =
                             new BrotliInputStream(new ByteArrayInputStream(body))) {
                    body = bis.readAllBytes();
                }
            }

            File theFile = Files.write(Path.of(System.getProperty("java.io.tmpdir"), "/", fileName), body).toFile();
            if (null != theFile) {
                LOGGER.log(Level.INFO, String.format("***** downloaded file (%s) *****", theFile.getAbsolutePath()));
                return theFile;
            }
        }

        return null;
    }

    public HttpRequest buildHttpRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                //.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:151.0) Gecko/20100101 Firefox/151.0")
                .header("Accept-Encoding", "gzip, deflate, br, zstd")
                .header("Accept", "application/json,text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Referer", "https://www.nseindia.com/")
                .GET()
                .build();
    }

    public HttpResponse<String> retryDownloadLinkAvailablePage(String url) /*throws IOException, InterruptedException*/ {
        try {
            this.gotoHomePage();
            return this.stringResponseOf(url);
        } catch (IOException | InterruptedException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
            return null;
        }
    }

    public void logHttpErrorMessage(int httpStatusCode, String url) {
        if (!(200 == httpStatusCode)) {
            String message = String.format("ERROR => %s : HTTP[%s]...trying again from the start.", url, httpStatusCode);
            LOGGER.log(Level.SEVERE, message);
        }
    }

    public String customizeHttpStatus200() {
        return String.format("%s OK", 200);
    }
}

