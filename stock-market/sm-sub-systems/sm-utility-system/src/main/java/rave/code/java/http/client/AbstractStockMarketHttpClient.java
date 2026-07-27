package rave.code.java.http.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractStockMarketHttpClient {

    private static final Logger LOGGER = Logger.getLogger(AbstractStockMarketHttpClient.class.getName());

    protected HttpClient client;

    public AbstractStockMarketHttpClient() {
        this.client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .cookieHandler(new CookieManager())
                .build();
    }

    public HttpResponse<String> stringResponseOf(String url) {
        try {
            HttpRequest request = this.buildHttpRequest(url);
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
            return null;
        }
    }

    public HttpResponse<InputStream> inputStreamResponseOf(String url) {
        HttpRequest request = this.buildHttpRequest(url);
        try {
            return this.client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        } catch (IOException | InterruptedException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
            return null;
        }
    }

    public HttpResponse<Path> pathResponseOf(String url) {
        String fileName = String.format("downloaded-file-%s.csv", new Date().getTime());
        Path destination = Paths.get(fileName);
        HttpRequest request = this.buildHttpRequest(url);
        try {
            return this.client.send(request, HttpResponse.BodyHandlers.ofFile(destination));
        } catch (IOException | InterruptedException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
            return null;
        }
    }

    public HttpResponse<byte[]> byteArrayResponseOf(String url) {
        HttpRequest request = this.buildHttpRequest(url);
        try {
            return this.client.send(request, HttpResponse.BodyHandlers.ofByteArray());
        } catch (IOException | InterruptedException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
            return null;
        }
    }

    public abstract HttpRequest buildHttpRequest(String url);
}
