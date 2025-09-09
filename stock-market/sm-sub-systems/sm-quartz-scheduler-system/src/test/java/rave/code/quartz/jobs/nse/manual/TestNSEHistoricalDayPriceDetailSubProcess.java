package rave.code.quartz.jobs.nse.manual;

import rave.code.process.SubProcessor;
import rave.code.quartz.jobs.nse.csv.bhavcopy.NSEDayPriceDetailEntityMakerJob;
import rave.code.utility.log.JavaUtilLogDecor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TestNSEHistoricalDayPriceDetailSubProcess {

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();

        int noOfDaysInPast = 100;
        int subListItemCount = (noOfDaysInPast * 10) / 100;

        LocalDate today = LocalDate.now();
        List<Date> historicalDates = new ArrayList<>();
        for (int index = noOfDaysInPast; index >= 1; index--) {
            LocalDate pastLocalDate = today.minusDays(index);
            Date pastDate = Date.from(pastLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            historicalDates.add(pastDate);
        }
        Collections.reverse(historicalDates);

        int end = subListItemCount;
        int start = 1;

        do {
            List<Date> subHistoricalDates = historicalDates.subList(start - 1, end - 1);
            try {
                NSEDayPriceDetailEntityMakerJob subProcess = (NSEDayPriceDetailEntityMakerJob) SubProcessor.createSubProcess(NSEDayPriceDetailEntityMakerJob.class);
                subProcess.setDates(subHistoricalDates);
                subProcess.setUp().start().action().exit();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            start = end + 1;
            end = end + subListItemCount;

        } while (end <= noOfDaysInPast);
    }
}
