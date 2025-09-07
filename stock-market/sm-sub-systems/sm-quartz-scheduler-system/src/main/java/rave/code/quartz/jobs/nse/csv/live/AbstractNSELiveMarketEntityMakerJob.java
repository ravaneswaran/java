package rave.code.quartz.jobs.nse.csv.live;

import org.apache.commons.csv.CSVRecord;
import rave.code.java.http.client.nse.NationalStockExchangeHttpClient;
import rave.code.quartz.jobs.AbstractCSVEntityMakerJob;
import rave.code.utility.csv.ApacheCommonsCSVFileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractNSELiveMarketEntityMakerJob<T> extends AbstractCSVEntityMakerJob<List<CSVRecord>, T> {

    private static final Logger LOGGER = Logger.getLogger(AbstractNSELiveMarketEntityMakerJob.class.getName());

    protected String downloadPageUrl;

    public AbstractNSELiveMarketEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
        this.downloadPageUrl = "https://www.nseindia.com/market-data/most-active-equities";
    }

    @Override
    public List<CSVRecord> getDataFromSource() {
        File downloadedFile = null;
        NationalStockExchangeHttpClient nationalStockExchangeHttpClient = new NationalStockExchangeHttpClient();
        try {
            nationalStockExchangeHttpClient.gotoHomePage();
            nationalStockExchangeHttpClient.stringResponseOf(this.downloadPageUrl);
            downloadedFile = nationalStockExchangeHttpClient.getFile(this.csvDownloadUrl);
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        } catch (InterruptedException interruptedException) {
            LOGGER.log(Level.SEVERE, interruptedException.getMessage(), interruptedException);
        }

        ApacheCommonsCSVFileReader apacheCommonsCSVFileReader = new ApacheCommonsCSVFileReader();
        List<CSVRecord> records = new ArrayList<>();
        try {
            records = apacheCommonsCSVFileReader.read(new FileInputStream(downloadedFile));
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }

        return records;
    }
}
