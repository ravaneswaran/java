package rave.code.quartz.job.stockbase.nse;

import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.java.http.client.nse.NationalStockExchangeHttpClient;
import rave.code.quartz.job.stockbase.AbstractCSVEntityMakerJob;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utilities.file.SimpleFileReader;
import rave.code.utility.log.JavaUtilLogDecor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEPreOpenMarketEntityMakeJob extends AbstractCSVEntityMakerJob<List<String>, List<NSEPreOpenMarketDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEPreOpenMarketEntityMakeJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    public NSEPreOpenMarketEntityMakeJob() {
        this("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
    }

    public NSEPreOpenMarketEntityMakeJob(String url) {
        super(url);
    }

    @Override
    public List<String> getDataFromSource() {
        NationalStockExchangeHttpClient nationalStockExchangeHttpClient = new NationalStockExchangeHttpClient(this.url);
        File downloadedFile = null;
        try {
            downloadedFile = nationalStockExchangeHttpClient.gotoHomePage().gotoDownloadLinkAvailablePage().fileResponseOf("https://www.nseindia.com/api/market-data-pre-open?key=NIFTY&csv=true");
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        } catch (InterruptedException interruptedException) {
            LOGGER.log(Level.SEVERE, interruptedException.getMessage(), interruptedException);
        }
        List<String> lines = new ArrayList<>();
        if(null != downloadedFile) {
            try (InputStream inputStream = new FileInputStream(downloadedFile)) {
                lines = new SimpleFileReader().read(inputStream);
            } catch (FileNotFoundException fileNotFoundException) {
                LOGGER.log(Level.SEVERE, fileNotFoundException.getMessage(), fileNotFoundException);
            } catch (IOException ioException) {
                LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            }
        }
        return lines;
    }

    @Override
    public List<NSEPreOpenMarketDetailEntity> transformSourceData(List<String> sourceData) {
        return null;
    }

    @Override
    public void saveTransformedData(List<NSEPreOpenMarketDetailEntity> transformedData) {

    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketEntityMakeJob nsePreOpenMarketEntityMakeJob = new NSEPreOpenMarketEntityMakeJob();
        nsePreOpenMarketEntityMakeJob.saveTransformedData(nsePreOpenMarketEntityMakeJob.transformSourceData(nsePreOpenMarketEntityMakeJob.getDataFromSource()));
    }
}
