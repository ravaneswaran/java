package rave.code.java.http.client.nse;

import rave.code.utility.log.JavaUtilLogDecor;

import java.io.IOException;

public class NationalStockExchangeHttpClient extends AbstractNationalStockExchangeHttpClient {

    public NationalStockExchangeHttpClient(String downloadLinkAvailablePageUrl) {
        super(downloadLinkAvailablePageUrl);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JavaUtilLogDecor.setupLogDecor();
        NationalStockExchangeHttpClient nationalStockExchangeHttpClient = new NationalStockExchangeHttpClient("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
        nationalStockExchangeHttpClient.gotoHomePage().waitFor(0).gotoDownloadLinkAvailablePage().waitFor(0);

        nationalStockExchangeHttpClient.fileResponseOf("https://www.nseindia.com/api/market-data-pre-open?key=NIFTY&csv=true");

        //byte[] contentInBytes = nationalStockExchangeHttpClient.getResponseContent("https://www.nseindia.com/api/market-data-pre-open?key=ALL");
        //String content = new String(contentInBytes);
        //System.out.println(content);
    }
}
