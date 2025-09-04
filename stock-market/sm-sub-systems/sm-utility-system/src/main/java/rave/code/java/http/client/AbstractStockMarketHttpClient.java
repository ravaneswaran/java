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

public abstract class AbstractStockMarketHttpClient {

    protected HttpClient client;

    public AbstractStockMarketHttpClient() {
        this.client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .cookieHandler(new CookieManager())
                .build();
    }

    public HttpResponse<String> stringResponseOf(String url) throws IOException, InterruptedException {
        HttpRequest request = this.buildHttpRequest(url);
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<InputStream> inputStreamResponseOf(String url) throws IOException, InterruptedException {
        HttpRequest request = this.buildHttpRequest(url);
        return this.client.send(request, HttpResponse.BodyHandlers.ofInputStream());
    }

    public HttpResponse<Path> pathResponseOf(String url) throws IOException, InterruptedException {
        String fileName = String.format("downloaded-file-%s.csv", new Date().getTime());
        Path destination = Paths.get(fileName);
        HttpRequest request = this.buildHttpRequest(url);
        return this.client.send(request, HttpResponse.BodyHandlers.ofFile(destination));
    }

    public HttpResponse<byte[]> byteArrayResponseOf(String url) throws IOException, InterruptedException {
        HttpRequest request = this.buildHttpRequest(url);
        return this.client.send(request, HttpResponse.BodyHandlers.ofByteArray());
    }

    public String customizeHttpStatus(HttpResponse<?> response) {
        int statusCode = response.statusCode();
        return (200 == statusCode) ? String.format("%s OK", statusCode) : String.format("%s", statusCode);
    }

    public abstract HttpRequest buildHttpRequest(String url);
}
