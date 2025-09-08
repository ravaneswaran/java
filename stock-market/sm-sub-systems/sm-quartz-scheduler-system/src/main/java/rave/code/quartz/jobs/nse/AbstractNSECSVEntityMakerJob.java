package rave.code.quartz.jobs.nse;

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

public abstract class AbstractNSECSVEntityMakerJob<T> extends AbstractCSVEntityMakerJob<List<CSVRecord>, T> {

    private static final Logger LOGGER = Logger.getLogger(AbstractNSECSVEntityMakerJob.class.getName());

    protected String downloadPageUrl;

    public AbstractNSECSVEntityMakerJob(String csvDownloadUrl){
        super(csvDownloadUrl);
    }

    public File downloadFile() throws IOException, InterruptedException {
        NationalStockExchangeHttpClient nationalStockExchangeHttpClient = new NationalStockExchangeHttpClient();
        nationalStockExchangeHttpClient.gotoHomePage();
        nationalStockExchangeHttpClient.stringResponseOf(this.downloadPageUrl);
        return nationalStockExchangeHttpClient.getFile(this.csvDownloadUrl);
    }

    public List<CSVRecord> listCsvRecords(File downloadedFile) throws IOException {
        ApacheCommonsCSVFileReader apacheCommonsCSVFileReader = new ApacheCommonsCSVFileReader();
        return apacheCommonsCSVFileReader.read(new FileInputStream(downloadedFile));
    }

    @Override
    public List<CSVRecord> getDataFromSource() {
        return this.getDataFromSource(false);
    }

    public List<CSVRecord> getDataFromSource(boolean needHeaderCleansing) {
        File downloadedFile = null;
        try {
            downloadedFile = this.downloadFile();
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        } catch (InterruptedException interruptedException) {
            LOGGER.log(Level.SEVERE, interruptedException.getMessage(), interruptedException);
        }

        List<CSVRecord> csvRecords = new ArrayList<>();
        if (null != downloadedFile) {
            if (needHeaderCleansing) {
                try {
                    this.cleanseCsvHeader(downloadedFile);
                } catch (IOException ioException) {
                    LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
                }
            }

            try {
                csvRecords = this.listCsvRecords(downloadedFile);
            } catch (IOException ioException) {
                LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            }
        }

        return csvRecords;
    }

    public void setDownloadPageUrl(String downloadPageUrl) {
        this.downloadPageUrl = downloadPageUrl;
    }
}
