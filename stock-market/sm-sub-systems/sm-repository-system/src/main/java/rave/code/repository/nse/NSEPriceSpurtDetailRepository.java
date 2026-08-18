package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;
import rave.code.utility.log.message.JavaUtilLogMessage;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEPriceSpurtDetailRepository extends AbstractNSERepositoryManager<NSEPriceSpurtDetailEntity> {

    private static final Logger LOGGER = Logger.getLogger(NSEPriceSpurtDetailRepository.class.getName());

    public NSEPriceSpurtDetailRepository() {
        super(NSEPriceSpurtDetailEntity.class);
    }

    @Override
    public List<NSEPriceSpurtDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return List.of();
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctNSEPricePriceSpurtDetails() {
        return this.findByDate(new Date());
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctNSEPricePriceSpurtDetailsByOpenPriceRange(int lowerOpenPrice, int upperOpenPrice) {
        return this.findByOpenPriceRangeAndDate(lowerOpenPrice, upperOpenPrice, new Date());
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctNSEPriceSpurtDetailsByPercentageChange(int lowerPercentageChange, int upperPercentageChange) {
        return this.findByPercentageChangeRangeAndDate(lowerPercentageChange, upperPercentageChange, new Date());
    }

    public List<NSEPriceSpurtDetailEntity> findBySymbol(String symbol) {
        return this.findBySymbolAndDate(symbol, new Date());
    }

    /**
     * Method to find list of distinct NSEPriceSpurtDetailEntity on a particular day
     *
     * @param date :- criteria to filter out NSEPriceSpurtDetailEntity on a day from time 00:00:00 - 23:59:00, if the date is null then today will be in effect
     * @return List of NSEPriceSpurtDetailEntity and returns empty list when the criteria based on the parameters does not match
     **/
    public List<NSEPriceSpurtDetailEntity> findByDate(Date date) {
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

    /**
     * Method to find list of distinct NSEPriceSpurtDetailEntity on a particular day that falls between open price range
     *
     * @param lowerOpenPrice :- criteria to filter out NSEPriceSpurtDetailEntity
     * @param upperOpenPrice :- criteria to filter out NSEPriceSpurtDetailEntity
     * @param date           :- criteria to filter out NSEPriceSpurtDetailEntity on a day from time 00:00:00 - 23:59:00, if the date is null then today will be in effect
     * @return List of NSEPriceSpurtDetailEntity and returns empty list when the criteria based on the parameters does not match
     **/
    public List<NSEPriceSpurtDetailEntity> findByOpenPriceRangeAndDate(int lowerOpenPrice, int upperOpenPrice, Date date) {
        date = (date == null) ? new Date() : date;
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
        queryBuilder.append("open_price").append(" ").append("BETWEEN").append(" ").append(lowerOpenPrice).append(" ").append("AND").append(" ").append(upperOpenPrice);
        queryBuilder.append(" ");
        queryBuilder.append("GROUP BY symbol) x ON t.symbol = x.symbol AND t.created_date = x.max_created_date ORDER BY open_price;");

        return this.getEntityManager().createNativeQuery(queryBuilder.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }

    /**
     * Method to find list of distinct NSEPriceSpurtDetailEntity on a particular day that falls between percentage change range
     *
     * @param lowerPercentageChange :- criteria to filter out NSEPriceSpurtDetailEntity
     * @param upperPercentageChange :- criteria to filter out NSEPriceSpurtDetailEntity
     * @param date                  :- criteria to filter out NSEPriceSpurtDetailEntity on a day from time 00:00:00 - 23:59:00, if the date is null then today will be in effect
     * @return List of NSEPriceSpurtDetailEntity and returns empty list when the criteria based on the parameters does not match
     **/
    public List<NSEPriceSpurtDetailEntity> findByPercentageChangeRangeAndDate(int lowerPercentageChange, int upperPercentageChange, Date date) {
        date = (date == null) ? new Date() : date;
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
        queryBuilder.append("percentage_change").append(" ").append("BETWEEN").append(" ").append(lowerPercentageChange).append(" ").append("AND").append(" ").append(upperPercentageChange);
        queryBuilder.append(" ");
        queryBuilder.append("GROUP BY symbol) x ON t.symbol = x.symbol AND t.created_date = x.max_created_date ORDER BY percentage_change;");

        JavaUtilLogMessage javaUtilLogMessage = new JavaUtilLogMessage(queryBuilder.toString());
        LOGGER.info(javaUtilLogMessage.getDecoratedLogMessage());

        return this.getEntityManager().createNativeQuery(queryBuilder.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }


    /**
     * Method to find list of distinct NSEPriceSpurtDetailEntity for a symbol on a particular day and with price difference between
     * LastTradedPrice and OpenPrice
     *
     * @param priceDifference :- criteria to filter out NSEPriceSpurtDetailEntity
     * @param date            :- criteria to filter out NSEPriceSpurtDetailEntity on a day from time 00:00:00 - 23:59:00, if the date is null then today will be in effect
     * @return List of NSEPriceSpurtDetailEntity and returns empty list when the criteria based on the parameters does not match
     **/
    public List<NSEPriceSpurtDetailEntity> findByPriceDifferenceAndDate(int priceDifference, Date date) {
        date = (date == null) ? new Date() : date;
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatWithTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String toDateString = simpleDateFormatWithoutTime.format(date);
        String toDateStartTimeString = String.format("%s %s", toDateString, "00:00:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "23:59:00");
        try {
            Date fromDate = simpleDateFormatWithTime.parse(toDateStartTimeString);
            Date toDate = simpleDateFormatWithTime.parse(toDateEndTimeString);
            CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
            CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
            Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);

            Path<String> id = root.<String>get("id");
            Path<String> symbol = root.<String>get("symbol");
            Path<Double> openPrice = root.<Double>get("openPrice");
            Path<Double> highPrice = root.<Double>get("highPrice");
            Path<Double> lowPrice = root.<Double>get("lowPrice");
            Path<Double> lastTradedPrice = root.<Double>get("lastTradedPrice");
            Path<Double> previousClosePrice = root.<Double>get("previousClosePrice");
            Path<Double> percentageChange = root.<Double>get("percentageChange");
            Path<Integer> volume = root.<Integer>get("volume");
            Path<Date> createdDate = root.<Date>get("createdDate");

            //criteriaQuery.multiselect(id, symbol, openPrice, highPrice, lowPrice, lastTradedPrice, previousClosePrice, percentageChange, volume, criteriaBuilder.greatest(createdDate).alias("maxCreatedDate"));
            criteriaQuery.multiselect(symbol, criteriaBuilder.greatest(createdDate).alias("maxCreatedDate"));
            criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.diff(root.get("lastTradedPrice"), root.get("openPrice")), criteriaBuilder.literal((double) priceDifference)), criteriaBuilder.between(createdDate, fromDate, toDate));
            criteriaQuery.groupBy(symbol);
            return this.getEntityManager().createQuery(criteriaQuery).getResultList();
        } catch (ParseException parseException) {
            LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
            return List.of();
        }

        /*StringBuilder queryBuilder = new StringBuilder();
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

        return this.getEntityManager().createNativeQuery(queryBuilder.toString(), NSEPriceSpurtDetailEntity.class).getResultList();*/
    }

    /**
     * Method to find list of NSEPriceSpurtDetailEntity for a symbol on a particular day
     *
     * @param symbol :- first criteria to filter out NSEPriceSpurtDetailEntity
     * @param date   :- second criteria to filter out NSEPriceSpurtDetailEntity on a day from time 00:00:00 - 23:59:00, if the date is null then today will be in effect
     * @return List of NSEPriceSpurtDetailEntity and returns empty list when the criteria based on the parameters does not match
     **/
    public List<NSEPriceSpurtDetailEntity> findBySymbolAndDate(String symbol, Date date) {
        date = (date == null) ? new Date() : date;
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatWithTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String toDateString = simpleDateFormatWithoutTime.format(date);
        String toDateStartTimeString = String.format("%s %s", toDateString, "00:00:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "23:59:00");
        try {
            Date fromDate = simpleDateFormatWithTime.parse(toDateStartTimeString);
            Date toDate = simpleDateFormatWithTime.parse(toDateEndTimeString);

            CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
            CriteriaQuery<NSEPriceSpurtDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEPriceSpurtDetailEntity.class);
            Root<NSEPriceSpurtDetailEntity> root = criteriaQuery.from(NSEPriceSpurtDetailEntity.class);
            Predicate symbolPredicate = criteriaBuilder.equal(root.get("symbol"), symbol);
            Predicate datePredicate = criteriaBuilder.between(root.get("createdDate"), fromDate, toDate);
            Order symbolOrder = criteriaBuilder.asc(root.get("symbol"));
            Order createDateOrder = criteriaBuilder.desc(root.get("createdDate"));
            criteriaQuery.select(root).where(symbolPredicate, datePredicate).orderBy(symbolOrder, createDateOrder);

            return this.getEntityManager().createQuery(criteriaQuery).getResultList();
        } catch (ParseException parseException) {
            LOGGER.log(Level.SEVERE, parseException.getMessage(), parseException);
            return List.of();
        }
    }
}
