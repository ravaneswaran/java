package rave.code.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockMarketDate {

    private static final Logger LOGGER = Logger.getLogger(StockMarketDate.class.getName());
    private static StockMarketDate STOCK_MARKET_DATE_INSTANCE = null;

    private final long regularSessionInMinutes;
    private Date businessDate;

    private StockMarketDate() throws ParseException {
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatWitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String toDateString = simpleDateFormatWithoutTime.format(new Date());
        this.businessDate = simpleDateFormatWitTime.parse(String.format("%s 00:00:00", toDateString));
        String dateString = simpleDateFormatWithoutTime.format(this.businessDate);
        Date startDate = simpleDateFormatWitTime.parse(String.format("%s 09:15:00", dateString));
        Date endDate = simpleDateFormatWitTime.parse(String.format("%s 13:30:00", dateString));
        long differenceMillis = endDate.getTime() - startDate.getTime();
        this.regularSessionInMinutes = differenceMillis / (60 * 1000);
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

    public long getRegularSessionInMinutes() {
        return this.regularSessionInMinutes;
    }

    public Date getBusinessDate() {
        return this.businessDate;
    }

    public Date now() {
        return new Date();
    }

    public Date moveNumberOfBusinessDaysInPast(int noOfDays) {
        this.businessDate = new Date(this.businessDate.getTime() - ((long) noOfDays * 24 * 60 * 60 * 1000));
        return this.businessDate;
    }

    public static void main(String[] args) {
        StockMarketDate stockMarketDate = StockMarketDate.getInstance();
        long noOfMinutes = stockMarketDate.getRegularSessionInMinutes();
        Date now = stockMarketDate.now();
        Date businessDate = stockMarketDate.getBusinessDate();
        Date dateInPast = stockMarketDate.moveNumberOfBusinessDaysInPast(10);
        SimpleDateFormat simpleDateFormatWitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(noOfMinutes);
        System.out.println(simpleDateFormatWitTime.format(now));
        System.out.println(simpleDateFormatWitTime.format(businessDate));
        System.out.println(simpleDateFormatWitTime.format(dateInPast));
    }
}
