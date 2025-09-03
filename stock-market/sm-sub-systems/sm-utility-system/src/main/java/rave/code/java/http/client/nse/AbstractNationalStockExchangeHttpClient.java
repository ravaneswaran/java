package rave.code.java.http.client.nse;

import rave.code.java.http.client.AbstractHttpClient;

import java.io.File;
import java.io.IOException;
import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractNationalStockExchangeHttpClient extends AbstractHttpClient {

    private String homePageUrl = "https://www.nseindia.com";
    private String downloadLinkAvailablePageUrl;
    private HttpClient client;
    private HttpResponse<String> response;

    private static final Logger LOGGER = Logger.getLogger(AbstractNationalStockExchangeHttpClient.class.getName());

    public AbstractNationalStockExchangeHttpClient(String downloadLinkAvailablePageUrl) {
        this("https://www.nseindia.com", downloadLinkAvailablePageUrl);
    }

    public AbstractNationalStockExchangeHttpClient(String homePageUrl, String downloadLinkAvailablePageUrl) {
        this.homePageUrl = homePageUrl;
        this.downloadLinkAvailablePageUrl = downloadLinkAvailablePageUrl;
        this.client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .cookieHandler(new CookieManager())
                .build();
    }

    public AbstractNationalStockExchangeHttpClient gotoHomePage() throws IOException, InterruptedException {
        HttpRequest request = this.buildHttpRequest(this.homePageUrl);
        this.response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        LOGGER.log(Level.INFO, String.format("Http Status : %s (%s)", this.response.statusCode(), this.homePageUrl));
        return this;
    }

    public AbstractNationalStockExchangeHttpClient gotoDownloadLinkAvailablePage() throws IOException, InterruptedException {
        HttpRequest request = this.buildHttpRequest(this.downloadLinkAvailablePageUrl);
        this.response = client.send(request, HttpResponse.BodyHandlers.ofString());
        LOGGER.log(Level.INFO, String.format("Http Status : %s (%s)", this.response.statusCode(), this.downloadLinkAvailablePageUrl));
        return this;
    }

    public byte[] byteArrayResponseOf(String url) throws IOException, InterruptedException {
        HttpRequest request = this.buildHttpRequest(url);
        this.response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        LOGGER.log(Level.INFO, String.format("Http Status : %s (%s)", this.response.statusCode(), url));
        if (200 == this.response.statusCode()) {
            return this.response.body().getBytes();
        } else {
            return new byte[0];
        }
    }

    public File fileResponseOf(String url) throws IOException, InterruptedException {
        String fileAbsolutePath = String.format("downloaded-file-%s.csv", new Date().getTime());
        Path destination = Paths.get(fileAbsolutePath);

        HttpRequest request = this.buildHttpRequest(url);
        HttpResponse<Path> resp = this.client.send(request, HttpResponse.BodyHandlers.ofFile(destination));
        LOGGER.log(Level.INFO, String.format("Http Status : %s (%s)", resp.statusCode(), url));
        return resp.body().getFileName().toFile();
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

    public HttpResponse<String> getResponse() {
        return this.response;
    }

    public AbstractNationalStockExchangeHttpClient waitFor(int noOfSeconds) throws InterruptedException {
        Thread.sleep(noOfSeconds * 1000);
        return this;
    }
}

