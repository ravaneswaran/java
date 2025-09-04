package rave.code.quartz.jobs.nse;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.java.http.client.nse.NationalStockExchangeHttpClient;
import rave.code.quartz.job.stockbase.AbstractCSVEntityMakerJob;
import rave.code.repository.nse.NSEPreOpenMarketDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utilities.file.SimpleFileReader;
import rave.code.utility.csv.ApacheCommonsCSVFileReader;
import rave.code.utility.log.JavaUtilLogDecor;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEPreOpenMarketNifty50EntityMakerJob extends AbstractCSVEntityMakerJob<List<CSVRecord>, List<NSEPreOpenMarketDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEPreOpenMarketNifty50EntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPreOpenMarketDetailRepository nsePreOpenMarketDetailRepository = new NSEPreOpenMarketDetailRepository();

    public NSEPreOpenMarketNifty50EntityMakerJob() {
        this("https://www.nseindia.com/market-data/pre-open-market-cm-and-emerge-market");
    }

    public NSEPreOpenMarketNifty50EntityMakerJob(String url) {
        super(url);
    }

    @Override
    public List<CSVRecord> getDataFromSource() {
        File downloadedFile = null;
        NationalStockExchangeHttpClient nationalStockExchangeHttpClient = new NationalStockExchangeHttpClient();
        try {
            nationalStockExchangeHttpClient.gotoHomePage();
            nationalStockExchangeHttpClient.stringResponseOf(this.url);
            downloadedFile = nationalStockExchangeHttpClient.getFile("https://www.nseindia.com/api/market-data-pre-open?key=NIFTY&csv=true");
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
    public List<NSEPreOpenMarketDetailEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEPreOpenMarketDetailEntity> nsePreOpenMarketDetailEntities = new ArrayList<>();
        for (CSVRecord csvRecord : sourceData) {
            NSEPreOpenMarketDetailEntity nsePreOpenMarketDetailEntity = new NSEPreOpenMarketDetailEntity();
            String symbol = csvRecord.get(0);
            nsePreOpenMarketDetailEntity.setSymbol(symbol);
            try {
                nsePreOpenMarketDetailEntity.setPreviousClose(Double.parseDouble(csvRecord.get(1).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PreviousClose of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setPreviousClose(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setIndicativeEquilibriumPrice(Double.parseDouble(csvRecord.get(2).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("IndicativeEquilibriumPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setIndicativeEquilibriumPrice(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setPriceChange(Double.parseDouble(csvRecord.get(3).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("Change of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setPriceChange(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setPricePercentageChange(Double.parseDouble(csvRecord.get(4).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("PercentageChange of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setPricePercentageChange(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setFinalPrice(Double.parseDouble(csvRecord.get(5).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("FinalPrice of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setFinalPrice(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setFinalQuantity(Integer.parseInt(csvRecord.get(6).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("FinalQuantity of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setFinalQuantity(0);
            }
            try {
                nsePreOpenMarketDetailEntity.setValueInCrores(new BigDecimal(csvRecord.get(7).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("ValueInCrores of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setFinalQuantity(0);
            }
            try {
                nsePreOpenMarketDetailEntity.setFreeFloatMarketCapitalization(new BigDecimal(csvRecord.get(8).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("FreeFloatMarketCapitalization of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setFinalQuantity(0);
            }
            try {
                nsePreOpenMarketDetailEntity.setNewMarket52WeekHigh(Double.parseDouble(csvRecord.get(9).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("NewMarket52WeekHigh of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setNewMarket52WeekHigh(0.00);
            }
            try {
                nsePreOpenMarketDetailEntity.setNewMarket52WeekLow(Double.parseDouble(csvRecord.get(10).replaceAll(",", "")));
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, String.format("NewMarket52WeekLow of %s has raised NumberFormatException(%s)", symbol, numberFormatException.getMessage()), numberFormatException);
                nsePreOpenMarketDetailEntity.setNewMarket52WeekLow(0.00);
            }
            nsePreOpenMarketDetailEntities.add(nsePreOpenMarketDetailEntity);
        }
        return nsePreOpenMarketDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEPreOpenMarketDetailEntity> transformedData) {
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.getEntityMapForPreOpenMarketDetails();
        List<NSEPreOpenMarketDetailEntity> properNsePreOpenMarketDetailEntities = new ArrayList<>();

        for (NSEPreOpenMarketDetailEntity nsePreOpenMarketDetailEntity : transformedData) {
            String key = nsePreOpenMarketDetailEntity.getKey();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nsePreOpenMarketDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                properNsePreOpenMarketDetailEntities.add(nsePreOpenMarketDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("%s : stock base entity not for(%s) exists...", key, nsePreOpenMarketDetailEntity.getSymbol()));
            }
        }
        this.nsePreOpenMarketDetailRepository.bulkUpsert(properNsePreOpenMarketDetailEntities);
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        NSEPreOpenMarketNifty50EntityMakerJob nsePreOpenMarketEntityMakeJob = new NSEPreOpenMarketNifty50EntityMakerJob();
        nsePreOpenMarketEntityMakeJob.saveTransformedData(nsePreOpenMarketEntityMakeJob.transformSourceData(nsePreOpenMarketEntityMakeJob.getDataFromSource()));
    }
}
