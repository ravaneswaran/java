package rave.code.quartz.jobs.nse.manual;

import rave.code.entity.nse.NSEDayPriceLastRunDetailEntity;
import rave.code.process.SubProcessor;
import rave.code.quartz.jobs.nse.csv.bhavcopy.NSEDayPriceDetailEntityMakerJob;
import rave.code.repository.nse.NSEDayPriceLastRunDetailRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
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

        NSEDayPriceLastRunDetailRepository nseDayPriceLastRunDetailRepository = new NSEDayPriceLastRunDetailRepository();
        NSEDayPriceLastRunDetailEntity nseDayPriceLastRunDetailEntity = nseDayPriceLastRunDetailRepository.find();

        if (null != nseDayPriceLastRunDetailEntity) {
            List<Date> dates = new ArrayList<>();
            Date lastRun = nseDayPriceLastRunDetailEntity.getLastRunAt();

            SimpleDateFormat simpleDateFormatOne = new SimpleDateFormat("yyyy-MM-dd");
            String lastRunWithoutTimeStr = simpleDateFormatOne.format(lastRun);

            SimpleDateFormat simpleDateFormatTwo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date lastRunAt5PM = simpleDateFormatTwo.parse(String.format("%s %s", lastRunWithoutTimeStr, "17:00:00"));
                if (lastRunAt5PM.after(lastRun)) {
                    // include the date last run one in the array list
                    dates.add(lastRun);
                }
            } catch (ParseException exception) {
                LOGGER.log(Level.SEVERE, exception.getMessage());
            }

            LocalDate lastRunLocalDate = LocalDate.parse(lastRunWithoutTimeStr);
            LocalDate now = LocalDate.now();
            Period period = Period.between(lastRunLocalDate, now);
            int noOfDays = period.getDays();
            for (int index = noOfDays; index >= 0; index--) {
                LocalDate pastLocalDate = now.minusDays(index);
                Date pastDate = Date.from(pastLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                String pastDateStr = simpleDateFormatOne.format(pastDate);
                if (!lastRunWithoutTimeStr.equals(pastDateStr)) {
                    dates.add(pastDate);
                }
            }

            runNSEDayPriceDetailEntityMakerJob(dates);

        } else {
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
                runNSEDayPriceDetailEntityMakerJob(subHistoricalDates);
                start = end + 1;
                end = end + subListItemCount;

            } while (end <= noOfDaysInPast);
        }
    }

    public static void runNSEDayPriceDetailEntityMakerJob(List<Date> dates) {
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
    }
}
