package rave.code.java.http.nse;

import rave.code.utility.log.JavaUtilLogDecor;

import java.io.IOException;

public class NationalStockExchangeHttpClient extends AbstractNationalStockExchangeHttpClient {

    public NationalStockExchangeHttpClient(String downloadPageUrl) {
        super(downloadPageUrl);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JavaUtilLogDecor.setupLogDecor();
        NationalStockExchangeHttpClient nationalStockExchangeHttpClient = new NationalStockExchangeHttpClient("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
        nationalStockExchangeHttpClient.browseHomePage().waitFor(0).browseDownloadPage().waitFor(0);

        nationalStockExchangeHttpClient.writeContentToFile("https://www.nseindia.com/api/market-data-pre-open?key=NIFTY");

        //byte[] contentInBytes = nationalStockExchangeHttpClient.getResponseContent("https://www.nseindia.com/api/market-data-pre-open?key=ALL");
        //String content = new String(contentInBytes);
        //System.out.println(content);
    }
}
