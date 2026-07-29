package rave.code.java.http.client.nse;

import rave.code.utility.log.JavaUtilLogDecor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NationalStockExchangeHttpClient extends AbstractNationalStockExchangeHttpClient {

    private static final Logger LOGGER = Logger.getLogger(NationalStockExchangeHttpClient.class.getName());

    public NationalStockExchangeHttpClient() {
        super();
    }

    public HttpResponse<String> stringResponseOf(String url) {
        HttpResponse<String> response = super.stringResponseOf(url);
        return (HttpResponse<String>) this.logMessageAndRetry(response, url);
    }

    @Override
    public HttpResponse<Path> pathResponseOf(String url) {
        HttpResponse<Path> response = super.pathResponseOf(url);
        return (HttpResponse<Path>) this.logMessageAndRetry(response, url);
    }

    @Override
    public HttpResponse<InputStream> inputStreamResponseOf(String url) {
        HttpResponse<InputStream> response = super.inputStreamResponseOf(url);
        return (HttpResponse<InputStream>) this.logMessageAndRetry(response, url);
    }

    public HttpResponse<byte[]> byteArrayResponseOf(String url) {
        HttpResponse<byte[]> response = super.byteArrayResponseOf(url);
        return (HttpResponse<byte[]>) this.logMessageAndRetry(response, url);
    }

    public HttpResponse<?> logMessageAndRetry(HttpResponse<?> response, String url) {
        if(null == response){
            LOGGER.log(Level.SEVERE, "response is null...");
            return null;
        }
        int httpStatusCode = response.statusCode();
        if (200 == httpStatusCode) {
            LOGGER.log(Level.INFO, String.format("%s : HTTP[%s]", url, this.customizeHttpStatus200()));
        } else {
            this.logHttpErrorMessage(httpStatusCode, url);
            this.retryDownloadLinkAvailablePage(url);
        }
        return response;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JavaUtilLogDecor.setupLogDecor();

        NationalStockExchangeHttpClient nationalStockExchangeHttpClient = new NationalStockExchangeHttpClient();
        nationalStockExchangeHttpClient.gotoHomePage();
        nationalStockExchangeHttpClient.stringResponseOf("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
        File downloadedFile = nationalStockExchangeHttpClient.getFile("https://www.nseindia.com/api/market-data-pre-open?key=BANKNIFTY&csv=true");
    }
}
