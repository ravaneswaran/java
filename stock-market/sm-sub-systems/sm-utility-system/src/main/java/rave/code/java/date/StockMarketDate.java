package rave.code.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockMarketDate {

    private static final Logger LOGGER = Logger.getLogger(StockMarketDate.class.getName());
    private static StockMarketDate STOCK_MARKET_DATE_INSTANCE = null;

    private Date businessDate;

    private StockMarketDate() throws ParseException {
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatWitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String toDateString = simpleDateFormatWithoutTime.format(new Date());
        this.businessDate = simpleDateFormatWitTime.parse(String.format("%s 00:00:00", toDateString));
    }

    public static StockMarketDate getInstance() {
        if (null == STOCK_MARKET_DATE_INSTANCE) {
            try {
                STOCK_MARKET_DATE_INSTANCE = new StockMarketDate();
            } catch (ParseException parseException) {
                LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
            }
        }
        return STOCK_MARKET_DATE_INSTANCE;
    }

    public Date getBusinessDate() {
        return this.businessDate;
    }

    public Date now() {
        return new Date();
    }

    public void reset() {
        this.businessDate = this.now();
    }

    public String getTime() {
        SimpleDateFormat simpleDateFormatWithoutDate = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormatWithoutDate.format(this.now());
    }

    public long getNumberOfMinutesElapsedSince_09_15() {
        try {
            SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormatWitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date now = simpleDateFormatWitTime.parse(String.format("%s %s", simpleDateFormatWithoutTime.format(this.businessDate), this.getTime()));
            String dateWithoutTime = simpleDateFormatWithoutTime.format(now);
            Date at0915 = simpleDateFormatWitTime.parse(String.format("%s 09:15:00", dateWithoutTime));
            Date at1330 = simpleDateFormatWitTime.parse(String.format("%s 13:30:00", dateWithoutTime));

            if (now.getTime() >= at0915.getTime() && now.getTime() <= at1330.getTime()) {
                return (now.getTime() - at0915.getTime()) / (60 * 1000);
            } else {
                return (at1330.getTime() - at0915.getTime()) / (60 * 1000);
            }
        } catch (ParseException parseException) {
            LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
            return 0L;
        }
    }

    public void moveNumberOfBusinessDaysInPast(int noOfDays) {
        Date tempDate = new Date(this.businessDate.getTime() - ((long) noOfDays * 24 * 60 * 60 * 1000));
        SimpleDateFormat onlyTime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatWitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = onlyDate.format(tempDate);
        String time = onlyTime.format(this.now());
        String dateAndTime = String.format("%s %s",date, time);
        try{
            this.businessDate = simpleDateFormatWitTime.parse(dateAndTime);
        } catch (ParseException parseException){
            LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
        }
    }

    public static void main(String[] args) {
        StockMarketDate stockMarketDate = StockMarketDate.getInstance();
        SimpleDateFormat simpleDateFormatWitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = stockMarketDate.now();
        System.out.println(simpleDateFormatWitTime.format(now));
        stockMarketDate.moveNumberOfBusinessDaysInPast(3);
        System.out.println(simpleDateFormatWitTime.format(stockMarketDate.getBusinessDate()));

       /*Date now = stockMarketDate.now();
        Date businessDate = stockMarketDate.getBusinessDate();
        Date dateInPast = stockMarketDate.moveNumberOfBusinessDaysInPast(10);
        SimpleDateFormat simpleDateFormatWitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/

        /*System.out.println(stockMarketDate.getNumberOfMinutesElapsedSince_09_15());
        System.out.println(simpleDateFormatWitTime.format(now));
        System.out.println(simpleDateFormatWitTime.format(businessDate));
        System.out.println(simpleDateFormatWitTime.format(dateInPast));*/
    }
}
