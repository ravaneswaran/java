package rave.code.entity.quartz.job.manual;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rave.code.entity.quartz.job.AbstractQuartzJob;
import rave.code.entity.quartz.job.stockbase.StockBase10EntityMakerJob;
import rave.code.stockmarket.entity.HolidayEntity;
import rave.code.stockmarket.repository.HolidayRepository;
import rave.code.stockmarket.repository.StockBase10Repository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoricalDailyPriceListDownloadJob extends AbstractQuartzJob {

    private static final Logger LOGGER = Logger.getLogger(HistoricalDailyPriceListDownloadJob.class.getName());

    private int noOfDaysInPast = 1;
    private HolidayRepository holidayRepository = new HolidayRepository();
    private StockBase10Repository stockBaseRepository = new StockBase10Repository();


    public HistoricalDailyPriceListDownloadJob(){
        this(1);
    }

    public HistoricalDailyPriceListDownloadJob(int noOfDaysInPast){
        this.noOfDaysInPast = noOfDaysInPast;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.log(Level.FINE, "Deleting the stock base repository...");
        this.stockBaseRepository.deleteAll();
        List<Date> dates = this.getHistoricalDates(this.noOfDaysInPast);
        for (Date date: dates){
            StockBase10EntityMakerJob stockBaseJob = new StockBase10EntityMakerJob(date);
            stockBaseJob.execute(jobExecutionContext);
        }
    }

    public List<Date> getHistoricalDates(int noOfDaysInPast){
        List<Date> dates = new ArrayList<>();

        LocalDate today = LocalDate.now();
        List<HolidayEntity> holidayEntities =  this.holidayRepository.findAll();

        for (int index = 1; index <= noOfDaysInPast; index++) {
            LocalDate businessDaysBackInTime = today.minusDays(index);
            String dayOfWeek = businessDaysBackInTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            if(dayOfWeek.equalsIgnoreCase("saturday") || dayOfWeek.equalsIgnoreCase("sunday")){
                index++;
                noOfDaysInPast += 2;
                continue;
            }
            Date businessDateInPast = Date.from(businessDaysBackInTime.atStartOfDay(ZoneId.systemDefault()).toInstant());

            // now we need to check the 'businessDateInPast' is a holiday or not...
            boolean holiday = false;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
            for(HolidayEntity holyDayEntity : holidayEntities){
                LocalDate holyLocalDate = LocalDate.parse(holyDayEntity.getHolidate(), formatter);
                Date holyDate = Date.from(holyLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                if(businessDateInPast.equals(holyDate)){
                    holiday = true;
                    noOfDaysInPast += 1;
                    continue;
                }
            }

            if(!holiday) {
                dates.add(businessDateInPast);
            }
        }
        Collections.reverse(dates);

        return dates;
    }

    public static void main(String[] args) throws JobExecutionException {
        JavaUtilLogDecor.setupLogDecor();

        HistoricalDailyPriceListDownloadJob historicalDailyPriceListDownloadJob = new HistoricalDailyPriceListDownloadJob(10);
        historicalDailyPriceListDownloadJob.execute(null);
    }
}
