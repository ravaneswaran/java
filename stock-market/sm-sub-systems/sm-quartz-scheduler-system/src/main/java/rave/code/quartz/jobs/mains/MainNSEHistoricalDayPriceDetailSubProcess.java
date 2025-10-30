package rave.code.quartz.jobs.mains;

import rave.code.entity.nse.NSEDayPriceLastRunDetailEntity;
import rave.code.process.SubProcessor;
import rave.code.quartz.jobs.nse.csv.bhavcopy.NSEDayPriceDetailEntityMakerJob;
import rave.code.repository.nse.NSEDayPriceLastRunDetailRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainNSEHistoricalDayPriceDetailSubProcess {

    private static final Logger LOGGER = Logger.getLogger(MainNSEHistoricalDayPriceDetailSubProcess.class.getName());

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        int noOfDaysInPast = 365;
        int subListItemCount = (noOfDaysInPast * 10) / 100;

        LocalDate today = LocalDate.now();
        List<Date> historicalDates = new ArrayList<>();
        for (int index = noOfDaysInPast; index >= 1; index--) {
            LocalDate pastLocalDate = today.minusDays(index);
            Date pastDate = Date.from(pastLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            historicalDates.add(pastDate);
        }
        //Collections.reverse(historicalDates);

        int end = subListItemCount;
        int start = 1;

        do {
            List<Date> subHistoricalDates = historicalDates.subList(start - 1, end - 1);
            try {
                NSEDayPriceDetailEntityMakerJob subProcess = (NSEDayPriceDetailEntityMakerJob) SubProcessor.createSubProcess(NSEDayPriceDetailEntityMakerJob.class);
                subProcess.setDates(subHistoricalDates);
                subProcess.setUp().start().action().exit();
            } catch (InterruptedException exception) {
                LOGGER.log(Level.SEVERE, exception.getMessage());
            } catch (IOException exception) {
                LOGGER.log(Level.SEVERE, exception.getMessage());
            } catch (NoSuchMethodException exception) {
                LOGGER.log(Level.SEVERE, exception.getMessage());
            } catch (InvocationTargetException exception) {
                LOGGER.log(Level.SEVERE, exception.getMessage());
            } catch (InstantiationException exception) {
                LOGGER.log(Level.SEVERE, exception.getMessage());
            } catch (IllegalAccessException exception) {
                LOGGER.log(Level.SEVERE, exception.getMessage());
            }
            start = end + 1;
            end = end + subListItemCount;

        } while (end <= noOfDaysInPast);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date now = new Date();
        String nowAsString = simpleDateFormat.format(now);
        NSEDayPriceLastRunDetailRepository nseDayPriceLastRunDetailRepository = new NSEDayPriceLastRunDetailRepository();
        NSEDayPriceLastRunDetailEntity nseDayPriceLastRunDetailEntity = nseDayPriceLastRunDetailRepository.find();
        if (null == nseDayPriceLastRunDetailEntity) {
            nseDayPriceLastRunDetailEntity = new NSEDayPriceLastRunDetailEntity();
        }
        nseDayPriceLastRunDetailEntity.setLastRunAt(now);
        nseDayPriceLastRunDetailEntity.setLastRunAtStr(nowAsString);
        nseDayPriceLastRunDetailRepository.upsert(nseDayPriceLastRunDetailEntity);
        LOGGER.info(String.format("NSEHistoricalDayPriceDetailSubProcess made its last run at %s.", simpleDateFormat.format(now)));
    }
}
