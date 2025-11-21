package rave.code.quartz.jobs.nse.csv.ratios;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEPriceToEarningRatioDetailEntity;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.process.SubProcess;
import rave.code.quartz.jobs.nse.csv.AbstractNSECSVEntityMakerJob;
import rave.code.repository.nse.NSEPriceToEarningRatioDetailRepository;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEPriceToEarningRatioEntityMakerJob extends AbstractNSECSVEntityMakerJob<List<NSEPriceToEarningRatioDetailEntity>> {

    private static final Logger LOGGER = Logger.getLogger(NSEPriceToEarningRatioEntityMakerJob.class.getName());

    private NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();
    private NSEPriceToEarningRatioDetailRepository nsePriceToEarningRatioDetailRepository = new NSEPriceToEarningRatioDetailRepository();

    private Date date;

    public NSEPriceToEarningRatioEntityMakerJob() {
        super("");
        this.setDownloadPageUrl("https://www.nseindia.com/all-reports");
        this.initialize(new Date());
    }

    private void initialize(Date date) {
        this.date = date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
        String formattedDate = simpleDateFormat.format(this.date);
        this.setCsvDownloadUrl(String.format("https://nsearchives.nseindia.com/content/equities/peDetail/PE_%s.csv", formattedDate));
    }

    @Override
    public List<NSEPriceToEarningRatioDetailEntity> transformSourceData(List<CSVRecord> sourceData) {

        List<NSEPriceToEarningRatioDetailEntity> nsePriceToEarningRatioDetailEntities = new ArrayList<>();
        Map<String, NSEPriceToEarningRatioDetailEntity> entityMap = this.nsePriceToEarningRatioDetailRepository.getEntityMap();

        if (sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }
        for (CSVRecord csvRecord : sourceData) {
            int recordSize = csvRecord.size();
            if (recordSize >= 3) {
                String symbol = csvRecord.get(0);
                String symbolPE = csvRecord.get(1);
                String adjustedPE = csvRecord.get(2);

                if (null == symbolPE || "".equals(symbolPE.trim())) {
                    symbolPE = "0.0";
                }
                if (null == adjustedPE || "".equals(adjustedPE.trim())) {
                    adjustedPE = symbolPE;
                }

                NSEPriceToEarningRatioDetailEntity nsePriceToEarningRatioDetailEntity = entityMap.get(symbol);
                if(null == nsePriceToEarningRatioDetailEntity){
                    LOGGER.info(String.format("NSEPriceToEarningRatioDetailEntity for symbol %s does now exist...hence creating new one.", symbol));
                    nsePriceToEarningRatioDetailEntity = new NSEPriceToEarningRatioDetailEntity();
                } else {
                    LOGGER.info(String.format("NSEPriceToEarningRatioDetailEntity for symbol %s does exist...using the existing one.", symbol));
                }

                nsePriceToEarningRatioDetailEntity.setSymbol(symbol);
                try {
                    nsePriceToEarningRatioDetailEntity.setSymbolPE(Double.parseDouble(symbolPE));
                } catch (NumberFormatException exception) {
                    LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
                }
                try {
                    nsePriceToEarningRatioDetailEntity.setAdjustedPE(Double.parseDouble(adjustedPE));
                } catch (NumberFormatException exception) {
                    LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
                }

                nsePriceToEarningRatioDetailEntities.add(nsePriceToEarningRatioDetailEntity);
            }
        }
        return nsePriceToEarningRatioDetailEntities;
    }

    @Override
    public void saveTransformedData(List<NSEPriceToEarningRatioDetailEntity> transformedData) {
        if (transformedData.size() <= 0) {
            LOGGER.log(Level.INFO, String.format("Number of NSEPriceToEarningRatioDetailEntity.... %s", transformedData.size()));
            return;
        }
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.mapSymbolToStockBaseEntities();

        List<NSEPriceToEarningRatioDetailEntity> nsePriceToEarningRatioDetailEntities = new ArrayList<>();
        List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();

        for (NSEPriceToEarningRatioDetailEntity nsePriceToEarningRatioDetailEntity : transformedData) {
            String key = nsePriceToEarningRatioDetailEntity.getSymbol();
            NSEStockBaseEntity nseStockBaseEntity = mappedStockBaseEntities.get(key);
            if (null != nseStockBaseEntity) {
                LOGGER.log(Level.INFO, String.format("%s : stock base entity exists...", key));
                nsePriceToEarningRatioDetailEntity.setNseStockBaseEntity(nseStockBaseEntity);
                nsePriceToEarningRatioDetailEntities.add(nsePriceToEarningRatioDetailEntity);
            } else {
                LOGGER.log(Level.SEVERE, String.format("stock base entity for(%s) does not exists...hence creating it.", key, nsePriceToEarningRatioDetailEntity.getSymbol()));
                NSEStockBaseEntity nseStockBaseEntityToCreate = NSEStockBaseEntity.newInstance(nsePriceToEarningRatioDetailEntity.getSymbol(), null, null, null, -1, -1, -1);
                nseStockBaseEntities.add(nseStockBaseEntityToCreate);
            }
        }

        this.nseStockBaseRepository.bulkUpsert(nseStockBaseEntities);
        this.nsePriceToEarningRatioDetailRepository.bulkUpsert(nsePriceToEarningRatioDetailEntities);
    }

    @Override
    public SubProcess action() throws IOException {
        this.saveTransformedData(this.transformSourceData(this.getDataFromSource()));
        return this;
    }

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();
        /*try {
            new NSEPriceToEarningRatioEntityMakerJob().action();
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }*/
    }
}
