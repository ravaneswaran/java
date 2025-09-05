package rave.code.quartz.jobs.bse.csv.stockbase;

import rave.code.entity.bse.csv.BSEStockBaseEntity;
import rave.code.quartz.enums.ASCIIColorCodes;
import rave.code.quartz.jobs.AbstractCSVEntityMakerJob;
import rave.code.repository.bse.BSEStockBaseRepository;
import rave.code.utilities.file.SimpleFileReader;
import rave.code.utility.download.FileDownloader;
import rave.code.utility.zip.ZipFileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractBSEStockBaseCSVEntityMakerJob extends AbstractCSVEntityMakerJob<List<String>, List<BSEStockBaseEntity>> {

    protected BSEStockBaseRepository bseStockBaseRepository = new BSEStockBaseRepository();
    protected Date toDate = new Date();

    private static final Logger LOGGER = Logger.getLogger(AbstractBSEStockBaseCSVEntityMakerJob.class.getName());

    public AbstractBSEStockBaseCSVEntityMakerJob(String csvDownloadUrl) {
        super(csvDownloadUrl);
    }

    @Override
    public List<String> getDataFromSource() {
        LOGGER.log(Level.INFO, String.format("Downloading file... %s", this.csvDownloadUrl));
        FileDownloader fileDownloader = new FileDownloader();
        String zipEntryFileName = "EQ_ISINCODE_310118.CSV";
        List<String> lines = new ArrayList<>();
        try (InputStream inputStream = fileDownloader.downloadFile(this.csvDownloadUrl);
             InputStream csvFileInputStream = new ZipFileReader().read(inputStream, zipEntryFileName);) {
            lines = new SimpleFileReader().read(csvFileInputStream);
        } catch (FileNotFoundException ioException) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            LOGGER.log(Level.SEVERE, String.format("Resource(%s) not found...", this.csvDownloadUrl));
            LOGGER.log(Level.SEVERE, "Possibly could be the following reason(s)...");
            LOGGER.log(Level.SEVERE, String.format("the day the date(%s) referring to could be either HOLIDAY or WEEKEND(SATURDAY or SUNDAY)", sdf.format(this.toDate)));
            LOGGER.log(Level.SEVERE, String.format("the system expects the file now but will be made available only after 6:00 PM..", sdf.format(this.toDate)));
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, ioException.getMessage(), ioException);
        }
        return lines;
    }

    @Override
    public List<BSEStockBaseEntity> transformSourceData(List<String> sourceData) {
        List<BSEStockBaseEntity> bseStockBaseEntities = new ArrayList<>();
        int lineNumber = 1;

        for (String line : sourceData) {
            String[] lineDetails = line.split(",");

            if (1 == lineNumber) {
                LOGGER.log(Level.INFO, "skipping the header... ");
                lineNumber = lineNumber + 1;
                continue;
            }

            BSEStockBaseEntity bseStockBaseEntity = new BSEStockBaseEntity();
            bseStockBaseEntity.setScripCode(lineDetails[0].trim());
            bseStockBaseEntity.setScripName(lineDetails[1].trim());
            bseStockBaseEntity.setScripGroup(lineDetails[2].trim());
            bseStockBaseEntity.setScripType(lineDetails[3].trim());
            bseStockBaseEntity.setISINumber(lineDetails[14].trim());

            bseStockBaseEntities.add(bseStockBaseEntity);
        }

        return bseStockBaseEntities;
    }

    @Override
    public void saveTransformedData(List<BSEStockBaseEntity> transformedData) {
        Map<String, BSEStockBaseEntity> mappedStockBaseEntities = this.bseStockBaseRepository.getEntityMap();

        if (mappedStockBaseEntities.size() == 0) {
            LOGGER.log(Level.INFO, String.format("%sLoading fresh set of NSE stock base into the repository...", ASCIIColorCodes.WHITE.get()));
            this.bseStockBaseRepository.bulkUpsert(transformedData);
        } else {
            List<BSEStockBaseEntity> bseStockBaseEntities = new ArrayList<>();
            for (BSEStockBaseEntity bseStockBaseEntity : transformedData) {
                if (mappedStockBaseEntities.size() > 0) {
                    String key = bseStockBaseEntity.getISINumber();
                    BSEStockBaseEntity mappedStockBaseEntity = mappedStockBaseEntities.get(bseStockBaseEntity.getISINumber());
                    if (null != mappedStockBaseEntity) {
                        LOGGER.log(Level.INFO, String.format("[%s] - Stock entry is already available in the repository hence updating it...", key));
                        bseStockBaseEntity.setNewEntity(false);
                        bseStockBaseEntities.add(mappedStockBaseEntity);
                    } else {
                        LOGGER.log(Level.INFO, String.format("%s[%s]%s - Stock entry is not available in the repository hence creating it...", ASCIIColorCodes.WHITE.get(), key, ASCIIColorCodes.GREEN.get()));
                        bseStockBaseEntities.add(bseStockBaseEntity);
                    }
                }
            }
            this.bseStockBaseRepository.bulkUpsert(bseStockBaseEntities);
        }
    }
}
