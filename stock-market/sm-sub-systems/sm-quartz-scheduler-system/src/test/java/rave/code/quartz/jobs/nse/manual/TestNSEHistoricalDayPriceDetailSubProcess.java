package rave.code.quartz.jobs.nse.manual;

import rave.code.process.SubProcessor;
import rave.code.quartz.jobs.nse.csv.bhavcopy.NSEDayPriceDetailEntityMakerJob;
import rave.code.utility.log.JavaUtilLogDecor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestNSEHistoricalDayPriceDetailSubProcess {

    private static final Logger LOGGER = Logger.getLogger(TestNSEHistoricalDayPriceDetailSubProcess.class.getName());

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        int noOfDaysInPast = 400;
        int subListItemCount = (noOfDaysInPast * 10) / 100;

        LocalDate today = LocalDate.now();
        List<Date> historicalDates = new ArrayList<>();
        for (int index = noOfDaysInPast; index >= 1; index--) {
            LocalDate pastLocalDate = today.minusDays(index);
            Date pastDate = Date.from(pastLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            historicalDates.add(pastDate);
        }

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
    }

    /*public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date one = simpleDateFormat.parse("03-12-2025");
            Date two = simpleDateFormat.parse("04-12-2025");
            List<Date> dates = new ArrayList<>();
            dates.add(one);
            dates.add(two);

            try {
                NSEDayPriceDetailEntityMakerJob subProcess = (NSEDayPriceDetailEntityMakerJob) SubProcessor.createSubProcess(NSEDayPriceDetailEntityMakerJob.class);
                subProcess.setDates(dates);
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

        } catch (ParseException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage());
        }
    }*/
}
