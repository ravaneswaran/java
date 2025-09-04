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

    public HttpResponse<String> stringResponseOf(String url) throws IOException, InterruptedException {
        HttpResponse<String> response = super.stringResponseOf(url);
        LOGGER.log(Level.INFO, String.format("%s : HTTP[%s]", url, this.customizeHttpStatus(response)));
        if (!(200 == response.statusCode())) {
            throw new RuntimeException("Hmm just thinking now....");
        }
        return response;
    }

    @Override
    public HttpResponse<Path> pathResponseOf(String url) throws IOException, InterruptedException {
        HttpResponse<Path> response = super.pathResponseOf(url);
        LOGGER.log(Level.INFO, String.format("%s : HTTP[%s]", url, this.customizeHttpStatus(response)));
        if (!(200 == response.statusCode())) {
            throw new RuntimeException("Hmm just thinking now....");
        }
        return response;
    }

    @Override
    public HttpResponse<InputStream> inputStreamResponseOf(String url) throws IOException, InterruptedException {
        HttpResponse<InputStream> response = super.inputStreamResponseOf(url);
        LOGGER.log(Level.INFO, String.format("%s : HTTP[%s]", url, this.customizeHttpStatus(response)));
        if (!(200 == response.statusCode())) {
            throw new RuntimeException("Hmm just thinking now....");
        }
        return response;
    }

    public HttpResponse<byte[]> byteArrayResponseOf(String url) throws IOException, InterruptedException {
        HttpResponse<byte[]> response = super.byteArrayResponseOf(url);
        LOGGER.log(Level.INFO, String.format("%s : HTTP[%s]", url, this.customizeHttpStatus(response)));
        if (!(200 == response.statusCode())) {
            throw new RuntimeException("Hmm just thinking now....");
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
