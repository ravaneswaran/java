package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.utility.log.JavaUtilLogDecor;
import rave.code.utility.log.message.JavaUtilLogMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class NSEPriceSpurtDetailRepository extends AbstractNSERepositoryManager<NSEPriceSpurtDetailEntity> {

    private static final Logger LOGGER = Logger.getLogger(NSEPriceSpurtDetailRepository.class.getName());

    public NSEPriceSpurtDetailRepository() {
        super(NSEPriceSpurtDetailEntity.class);
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctOpenPricePriceSpurtDetails() {
        return this.findDistinctOpenPricePriceSpurtDetailsForADay(new Date());
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return List.of();
    }

    public List<NSEPriceSpurtDetailEntity> findPriceSpurtDetailsForASymbol(String symbol) {
        return this.findPriceSpurtDetailsForASymbolOnAParticularDay(symbol, null);
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctOpenPricePriceSpurtDetails(int lowerOpenPriceLimit, int upperOpenPriceLimit) {
        return this.findDistinctOpenPricePriceSpurtDetailsForADay(new Date(), lowerOpenPriceLimit, upperOpenPriceLimit);
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctPercentageChangePriceSpurtDetails(int lowerPercentageChangeLimit, int upperPercentageChangeLimit) {
        return this.findDistinctPercentageChangePriceSpurtDetailsForADay(new Date(), lowerPercentageChangeLimit, upperPercentageChangeLimit);
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctOpenPricePriceSpurtDetailsForADay(Date date) {
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        String toDateString = simpleDateFormatWithoutTime.format(date);

        String toDateStartTimeString = String.format("%s %s", toDateString, "00:00:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "23:59:00");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT t.* FROM nse_price_spurt_detail t INNER JOIN ( SELECT symbol, MAX(created_date) AS max_created_date FROM nse_price_spurt_detail WHERE created_date BETWEEN");
        queryBuilder.append(" ");
        queryBuilder.append("'").append(toDateStartTimeString).append("'");
        queryBuilder.append(" ").append("AND");
        queryBuilder.append(" ");
        queryBuilder.append("'").append(toDateEndTimeString).append("'");
        queryBuilder.append(" ");
        queryBuilder.append("GROUP BY symbol) x ON t.symbol = x.symbol AND t.created_date = x.max_created_date;");

        return this.getEntityManager().createNativeQuery(queryBuilder.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctOpenPricePriceSpurtDetailsForADay(Date date, int lowerOpenPriceLimit, int upperOpenPriceLimit) {
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        String toDateString = simpleDateFormatWithoutTime.format(date);

        String toDateStartTimeString = String.format("%s %s", toDateString, "00:00:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "23:59:00");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT t.* FROM nse_price_spurt_detail t INNER JOIN ( SELECT symbol, MAX(created_date) AS max_created_date FROM nse_price_spurt_detail WHERE created_date BETWEEN");
        queryBuilder.append(" ");
        queryBuilder.append("'").append(toDateStartTimeString).append("'");
        queryBuilder.append(" ").append("AND");
        queryBuilder.append(" ");
        queryBuilder.append("'").append(toDateEndTimeString).append("'");
        queryBuilder.append(" ").append("AND");
        queryBuilder.append(" ");
        queryBuilder.append("open_price").append(" ").append("BETWEEN").append(" ").append(lowerOpenPriceLimit).append(" ").append("AND").append(" ").append(upperOpenPriceLimit);
        queryBuilder.append(" ");
        queryBuilder.append("GROUP BY symbol) x ON t.symbol = x.symbol AND t.created_date = x.max_created_date ORDER BY open_price;");

        return this.getEntityManager().createNativeQuery(queryBuilder.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctPercentageChangePriceSpurtDetailsForADay(Date date, int lowerPercentageChangeLimit, int upperPercentageChangeLimit) {
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        String toDateString = simpleDateFormatWithoutTime.format(date);

        String toDateStartTimeString = String.format("%s %s", toDateString, "00:00:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "23:59:00");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT t.* FROM nse_price_spurt_detail t INNER JOIN ( SELECT symbol, MAX(created_date) AS max_created_date FROM nse_price_spurt_detail WHERE created_date BETWEEN");
        queryBuilder.append(" ");
        queryBuilder.append("'").append(toDateStartTimeString).append("'");
        queryBuilder.append(" ").append("AND");
        queryBuilder.append(" ");
        queryBuilder.append("'").append(toDateEndTimeString).append("'");
        queryBuilder.append(" ").append("AND");
        queryBuilder.append(" ");
        queryBuilder.append("percentage_change").append(" ").append("BETWEEN").append(" ").append(lowerPercentageChangeLimit).append(" ").append("AND").append(" ").append(upperPercentageChangeLimit);
        queryBuilder.append(" ");
        queryBuilder.append("GROUP BY symbol) x ON t.symbol = x.symbol AND t.created_date = x.max_created_date ORDER BY percentage_change;");

        JavaUtilLogMessage javaUtilLogMessage = new JavaUtilLogMessage(queryBuilder.toString());
        LOGGER.info(javaUtilLogMessage.getDecoratedLogMessage());

        return this.getEntityManager().createNativeQuery(queryBuilder.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctPriceDifferencePriceSpurtDetailsForADay(Date date, int priceDifference) {
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        String toDateString = simpleDateFormatWithoutTime.format(date);

        String toDateStartTimeString = String.format("%s %s", toDateString, "00:00:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "23:59:00");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT t.* FROM nse_price_spurt_detail t INNER JOIN ( SELECT symbol, MAX(created_date) AS max_created_date FROM nse_price_spurt_detail WHERE open_price <= 500 AND created_date BETWEEN");
        queryBuilder.append(" ");
        queryBuilder.append("'").append(toDateStartTimeString).append("'");
        queryBuilder.append(" ").append("AND");
        queryBuilder.append(" ");
        queryBuilder.append("'").append(toDateEndTimeString).append("'");
        queryBuilder.append(" ").append("AND");
        queryBuilder.append(" ");
        queryBuilder.append("(").append("last_traded_price - open_price").append(") >= ").append(priceDifference);
        queryBuilder.append(" ");
        queryBuilder.append("GROUP BY symbol) x ON t.symbol = x.symbol AND t.created_date = x.max_created_date ORDER BY last_traded_price;");

        JavaUtilLogMessage javaUtilLogMessage = new JavaUtilLogMessage(queryBuilder.toString());
        LOGGER.info(javaUtilLogMessage.getDecoratedLogMessage());

        return this.getEntityManager().createNativeQuery(queryBuilder.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }

    public List<NSEPriceSpurtDetailEntity> findPriceSpurtDetailsForASymbolOnAParticularDay(String symbol, Date date) {
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        date = (date == null) ? new Date() : date;
        String toDateString = simpleDateFormatWithoutTime.format(date);

        String toDateStartTimeString = String.format("%s %s", toDateString, "00:00:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "23:59:00");

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT * FROM nse_price_spurt_detail WHERE symbol=").append("'").append(symbol).append("'");
        queryBuilder.append(" ");
        queryBuilder.append("AND");
        queryBuilder.append(" ");
        queryBuilder.append("created_date").append(" ").append(">=").append(" ").append("'").append(toDateStartTimeString).append("'");
        queryBuilder.append(" ").append("AND").append(" ");
        queryBuilder.append("created_date").append(" ").append("<=").append(" ").append("'").append(toDateEndTimeString).append("'");
        queryBuilder.append(" ").append("ORDER BY").append(" ").append("symbol").append(" ").append("ASC").append(",").append(" ");
        queryBuilder.append("created_date").append(" ").append("DESC");

        return this.getEntityManager().createNativeQuery(queryBuilder.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }
}
