package rave.code.quartz.jobs.nse.csv.stockbase;

import org.apache.commons.csv.CSVRecord;
import rave.code.entity.nse.csv.NSEStockBaseEntity;
import rave.code.java.date.StockMarketDate;
import rave.code.quartz.enums.ASCIIColorCodes;
import rave.code.quartz.jobs.nse.csv.AbstractNSECSVEntityMakerJob;
import rave.code.repository.nse.NSEStockBaseRepository;
import rave.code.utility.csv.ApacheCommonsCSVFileReader;
import rave.code.utility.download.FileDownloader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractNSEStockBaseCSVEntityMakerJob extends AbstractNSECSVEntityMakerJob<List<NSEStockBaseEntity>> {

    protected Date toDate = StockMarketDate.getInstance().now();
    protected NSEStockBaseRepository nseStockBaseRepository = new NSEStockBaseRepository();

    private static final Logger LOGGER = Logger.getLogger(AbstractNSEStockBaseCSVEntityMakerJob.class.getName());

    public AbstractNSEStockBaseCSVEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
    }

    @Override
    public List<CSVRecord> getDataFromSource() {
        FileDownloader fileDownloader = new FileDownloader();
        List<CSVRecord> csvRecords = new ArrayList<>();
        try (InputStream inputStream = fileDownloader.downloadFile(this.csvDownloadUrl)) {
            ApacheCommonsCSVFileReader apacheCommonsCSVReader = new ApacheCommonsCSVFileReader();
            csvRecords = apacheCommonsCSVReader.read(inputStream);
        } catch (FileNotFoundException fileNotFoundException) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            LOGGER.log(Level.SEVERE, String.format("Resource(%s) not found...", this.csvDownloadUrl));
            LOGGER.log(Level.SEVERE, "Possibly could be the following reason(s)...");
            LOGGER.log(Level.SEVERE, String.format("the day which the date(%s) referring to could be either HOLIDAY or WEEKEND(SATURDAY or SUNDAY) or...", sdf.format(this.toDate)));
            LOGGER.log(Level.SEVERE, String.format("the system expects the file now but will be made available only after 6:00 PM..", sdf.format(this.toDate)));
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }
        return csvRecords;
    }

    @Override
    public List<NSEStockBaseEntity> transformSourceData(List<CSVRecord> sourceData) {
        List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();
        if(sourceData.size() > 0) {
            CSVRecord header = sourceData.remove(0);
            LOGGER.log(Level.INFO, String.format("Skipping the header[%s]... ", header.toString()));
        }

        for (CSVRecord csvRecord : sourceData) {
            NSEStockBaseEntity nseStockBaseEntity = new NSEStockBaseEntity();

            nseStockBaseEntity.setSymbol(csvRecord.get(0));
            nseStockBaseEntity.setCompanyName(csvRecord.get(1));
            nseStockBaseEntity.setSeries(csvRecord.get(2));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            try {
                Date dateOfListing = simpleDateFormat.parse(csvRecord.get(3));
                nseStockBaseEntity.setDateOfListing(dateOfListing);
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage());
            }
            try {
                int paidUpValue = Integer.parseInt(csvRecord.get(4).trim().replaceAll(",", ""));
                nseStockBaseEntity.setPaidUpValue(paidUpValue);
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage());
            }
            try {
                int marketLot = Integer.parseInt(csvRecord.get(5).trim().replaceAll(",", ""));
                nseStockBaseEntity.setMarketLot(marketLot);
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage());
            }
            nseStockBaseEntity.setISINumber(csvRecord.get(6));
            try {
                int faceValue = Integer.parseInt(csvRecord.get(7).trim().replaceAll(",", ""));
                nseStockBaseEntity.setMarketLot(faceValue);
            } catch (NumberFormatException numberFormatException) {
                LOGGER.log(Level.SEVERE, numberFormatException.getMessage());
            }

            nseStockBaseEntities.add(nseStockBaseEntity);
        }
        return nseStockBaseEntities;
    }

    @Override
    public void saveTransformedData(List<NSEStockBaseEntity> transformedData) {
        if (transformedData.size() <= 0) {
            LOGGER.log(Level.INFO, String.format("Number of NSEStockBaseEntity.... %s", transformedData.size()));
            return;
        }
        Map<String, NSEStockBaseEntity> mappedStockBaseEntities = this.nseStockBaseRepository.getEntityMap();
        if (mappedStockBaseEntities.size() == 0) {
            LOGGER.log(Level.INFO, String.format("%sLoading fresh set of NSE stock base into the repository...", ASCIIColorCodes.WHITE.get()));
            this.nseStockBaseRepository.bulkUpsert(transformedData);
        } else {
            List<NSEStockBaseEntity> nseStockBaseEntities = new ArrayList<>();
            for (NSEStockBaseEntity nseStockBaseEntity : transformedData) {
                if (mappedStockBaseEntities.size() > 0) {
                    String key = String.format("%s:%s:%s:%s", nseStockBaseEntity.getSymbol(), nseStockBaseEntity.getCompanyName(), nseStockBaseEntity.getSeries(), nseStockBaseEntity.getISINumber());
                    NSEStockBaseEntity mappedStockBaseEntity = mappedStockBaseEntities.get(key);
                    if (null != mappedStockBaseEntity) {
                        LOGGER.log(Level.INFO, String.format("[%s] - Stock base entity is already available in the repository... hence updating it.", key));
                        nseStockBaseEntity.setNewEntity(false);
                        nseStockBaseEntities.add(mappedStockBaseEntity);
                    } else {
                        LOGGER.log(Level.INFO, String.format("%s[%s]%s - Stock base entity is not available in the repository...hence creating it.", ASCIIColorCodes.WHITE.get(), key, ASCIIColorCodes.GREEN.get()));
                        nseStockBaseEntities.add(nseStockBaseEntity);
                    }
                }
            }
            this.nseStockBaseRepository.bulkUpsert(nseStockBaseEntities);
        }
    }
}
