package rave.code.java.http.client.nse;

import org.brotli.dec.BrotliInputStream;
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
        String fileName = String.format("downloaded-file-%s.csv", new Date().getTime());
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
            return Files.write(Path.of(fileName), body).toFile();
        }
        return null;
    }

    public HttpRequest buildHttpRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .header("Accept-Encoding", "gzip, deflate, br, zstd")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Referer", "https://www.nseindia.com/")
                .GET()
                .build();
    }

    public String customizeHttpStatus(HttpResponse<?> response) {
        int statusCode = response.statusCode();
        return (200 == statusCode) ? String.format("%s OK", statusCode) : String.format("%s", statusCode);
    }
}

