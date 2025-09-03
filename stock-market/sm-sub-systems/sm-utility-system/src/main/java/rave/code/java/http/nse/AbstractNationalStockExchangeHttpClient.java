package rave.code.java.http.nse;

import rave.code.java.http.AbstractHttpClient;

import java.io.IOException;
import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractNationalStockExchangeHttpClient extends AbstractHttpClient {

    private String homePageUrl = "https://www.nseindia.com";
    private String downloadPageUrl;
    private HttpClient client;
    private HttpResponse<String> response;

    private static final Logger LOGGER = Logger.getLogger(AbstractNationalStockExchangeHttpClient.class.getName());

    public AbstractNationalStockExchangeHttpClient(String downloadPageUrl) {
        this("https://www.nseindia.com", downloadPageUrl);
    }

    public AbstractNationalStockExchangeHttpClient(String homePageUrl, String downloadPageUrl) {
        this.homePageUrl = homePageUrl;
        this.downloadPageUrl = downloadPageUrl;
        this.client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .cookieHandler(new CookieManager())
                .build();
    }

    public AbstractNationalStockExchangeHttpClient browseHomePage() throws IOException, InterruptedException {
        HttpRequest request = this.buildHttpRequest(this.homePageUrl);
        this.response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        LOGGER.log(Level.INFO, String.format("Http Status : %s (%s)", this.response.statusCode(), this.homePageUrl));
        return this;
    }

    public AbstractNationalStockExchangeHttpClient browseDownloadPage() throws IOException, InterruptedException {
        HttpRequest request = this.buildHttpRequest(this.downloadPageUrl);
        this.response = client.send(request, HttpResponse.BodyHandlers.ofString());
        LOGGER.log(Level.INFO, String.format("Http Status : %s (%s)", this.response.statusCode(), this.downloadPageUrl));
        return this;
    }

    public byte[] getResponseContent(String url) throws IOException, InterruptedException {
        HttpRequest request = this.buildHttpRequest(url);
        this.response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        LOGGER.log(Level.INFO, String.format("Http Status : %s (%s)", this.response.statusCode(), url));
        if (200 == this.response.statusCode()) {
            return this.response.body().getBytes(StandardCharsets.UTF_8);
        } else {
            return new byte[0];
        }
    }

    public AbstractNationalStockExchangeHttpClient writeContentToFile(String url) throws IOException, InterruptedException {
        url = String.format("%s&csv=true", url);
        Path destination = Paths.get(String.format("downloaded-file-%s.csv", new Date().getTime()));
        HttpRequest request = this.buildHttpRequest(url);
        HttpResponse<Path> resp = this.client.send(request, HttpResponse.BodyHandlers.ofFile(destination));
        LOGGER.log(Level.INFO, String.format("Http Status : %s (%s)", this.response.statusCode(), url));
        return this;
    }

    public String[] getCookies(HttpResponse<String> response) {
        if(response!= null){
            Map<String, List<String>> responseHeaderMap = response.headers().map();
            String[] cookieHeaderArray = new String[2];
            for (String key : responseHeaderMap.keySet()) {
                if ("set-cookie".equalsIgnoreCase(key)) {
                    List<String> values = responseHeaderMap.get(key);
                    StringBuffer valueBuffer = new StringBuffer();
                    for (String value : values) {
                        valueBuffer.append(value).append(";");
                    }
                    String valueString = valueBuffer.toString();
                    String value = valueString.substring(0, valueString.length() - 1);
                    cookieHeaderArray[0] = key;
                    cookieHeaderArray[1] = value;
                }
            }
            return cookieHeaderArray;
        } else {
            return null;
        }
    }

    public HttpRequest buildHttpRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .header("Accept-Encoding", "gzip, deflate, br, zstd")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Referer", "https://www.nseindia.com/")
                //.headers(getCookies(this.response))
                .GET()
                .build();
    }

    public HttpRequest buildNoCookieHttpRequest(String url) {
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

