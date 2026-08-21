package rave.code.repository.quartz;

import junit.framework.TestCase;
import rave.code.entity.quartz.QuartzCalendarEntity;
import rave.code.entity.quartz.id.QuartzCalendarId;
import rave.code.java.date.StockMarketDate;

import java.util.Date;

public class TestQuartzCalender extends TestCase {

    private QuartzCalendarRepository quartzCalendarRepository = new QuartzCalendarRepository();

    public void testSave(){
        QuartzCalendarId quartzCalendarId = new QuartzCalendarId();
        quartzCalendarId.setSchedulerName("STOCK_MARKET_SCHEDULER");
        quartzCalendarId.setCalendarName("TEST_CALENDAR_"+ StockMarketDate.getInstance().now().getTime());
        QuartzCalendarEntity quartzCalendarEntity = new QuartzCalendarEntity();
        quartzCalendarEntity.setQuartzCalendarId(quartzCalendarId);
        quartzCalendarEntity.setCalendar("1234".getBytes());

        QuartzCalendarEntity returnVal = quartzCalendarRepository.save(quartzCalendarEntity);

        assertNotNull(returnVal);
    }

}
