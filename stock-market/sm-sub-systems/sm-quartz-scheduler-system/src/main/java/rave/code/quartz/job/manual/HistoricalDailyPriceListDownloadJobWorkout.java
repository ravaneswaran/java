package rave.code.quartz.job.manual;

import rave.code.stockmarket.entity.HolidayEntity;
import rave.code.stockmarket.repository.HolidayRepository;
import rave.code.utility.log.JavaUtilLogDecor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

public class HistoricalDailyPriceListDownloadJobWorkout {

    public static HolidayRepository holidayRepository = new HolidayRepository();

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();
        int noOfDaysInPast = 1;
        List<Date> dates = new ArrayList<>();

        LocalDate today = LocalDate.now();
        List<HolidayEntity> holidayEntities =  holidayRepository.findAll();


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

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for(Date date : dates){
            System.out.println("--------->>>>>> "+simpleDateFormat.format(date));
        }
        System.out.println("==========>>>>> "+dates.size());
    }
}
