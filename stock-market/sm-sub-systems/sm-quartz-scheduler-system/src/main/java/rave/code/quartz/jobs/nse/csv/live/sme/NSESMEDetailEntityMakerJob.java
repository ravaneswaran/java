package rave.code.quartz.jobs.nse.csv.live.sme;

import org.apache.commons.csv.CSVRecord;
import org.quartz.JobExecutionException;
import rave.code.entity.nse.csv.NSESMEDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.java.http.client.nse.NationalStockExchangeHttpClient;
import rave.code.quartz.jobs.nse.csv.live.AbstractNSELiveMarketEntityMakerJob;
import rave.code.repository.nse.NSESMEDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utilities.file.SimpleFileReader;
import rave.code.utility.csv.ApacheCommonsCSVFileReader;
import rave.code.utility.log.JavaUtilLogDecor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSESMEDetailEntityMakerJob extends AbstractNSELiveMarketEntityMakerJob<List<NSESMEDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSESMEDetailEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSESMEDetailRepository nseSmeDetailRepository = new NSESMEDetailRepository();

    public NSESMEDetailEntityMakerJob() {
        super("https://www.nseindia.com/api/live-analysis-most-active-sme-csv?index=volume&csv=true");
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

        List<String> lines = new ArrayList<>();
        if (null != downloadedFile) {
            try (InputStream inputStream = new FileInputStream(downloadedFile)) {
                lines = new SimpleFileReader().read(inputStream);
            } catch (FileNotFoundException fileNotFoundException) {
                LOGGER.log(Level.SEVERE, fileNotFoundException.getMessage(), fileNotFoundException);
            } catch (IOException ioException) {
                LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
            }
        }

        int size = lines.size();
        StringBuffer lineBuffer = new StringBuffer();
        for (int index = 10; index < size; index++) {
            lineBuffer.append(lines.get(index)).append("\n");
        }

        ApacheCommonsCSVFileReader apacheCommonsCSVFileReader = new ApacheCommonsCSVFileReader();
        List<CSVRecord> records = new ArrayList<>();
        try {
            records = apacheCommonsCSVFileReader.read(new ByteArrayInputStream(lineBuffer.toString().getBytes(StandardCharsets.UTF_8)));
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }

        return records;
    }


    @Override
    public List<NSESMEDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSESMEDetailEntity> nseSmeDetailEntities = new ArrayList<>();
        int lineNumber = 1;

        for (CSVRecord csvRecord : sourceData) {
            if (1 == lineNumber) {
                LOGGER.log(Level.INFO, "Skipping the header... ");
                lineNumber = lineNumber + 1;
                continue;
            }

            NSESMEDetailEntity nseSmeDetailEntity = new NSESMEDetailEntity();
            String symbol = csvRecord.get(0).trim();
            nseSmeDetailEntity.setSymbol(symbol);
            try {
                nseSmeDetailEntity.setOpenPrice(Double.parseDouble(csvRecord.get(1).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("OpenPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setHighPrice(Double.parseDouble(csvRecord.get(2).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("HighPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setLowPrice(Double.parseDouble(csvRecord.get(3).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LowPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setPreviousClosePrice(Double.parseDouble(csvRecord.get(4).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PreviousClosePrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setLastTradedPrice(Double.parseDouble(csvRecord.get(5).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("LastTradedPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setPercentageChange(Double.parseDouble(csvRecord.get(6).trim()));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PercentageChange of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setVolume(Integer.parseInt(csvRecord.get(7).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("Volume of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }
            try {
                nseSmeDetailEntity.setValueInLakhs(Double.parseDouble(csvRecord.get(8).trim().replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("ValueInLakhs of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
            }

            nseSmeDetailEntities.add(nseSmeDetailEntity);
        }

        return nseSmeDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSESMEDetailEntity> transformedData) {
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();
        List<NSESMEDetailEntity> nseSmeDetailEntities = new ArrayList<>();

        for (NSESMEDetailEntity nseSmeDetailEntity : transformedData) {
            String key = nseSmeDetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nseSmeDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nseSmeDetailEntities.add(nseSmeDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity not for(%s) exists...", key, nseSmeDetailEntity.getSymbol()));
            }
        }
        this.nseSmeDetailRepository.bulkUpsert(nseSmeDetailEntities);
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        NSESMEDetailEntityMakerJob nseSmeDetailEntityMakerJob = new NSESMEDetailEntityMakerJob();
        nseSmeDetailEntityMakerJob.saveTransformedData(nseSmeDetailEntityMakerJob.transformSourceData(nseSmeDetailEntityMakerJob.getDataFromSource()));
    }
}
