package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NSEPriceSpurtDetailRepository extends AbstractNSERepositoryManager<NSEPriceSpurtDetailEntity> {

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

        StringBuffer queryBuffer = new StringBuffer();
        queryBuffer.append("SELECT t.* FROM nse_price_spurt_detail t INNER JOIN ( SELECT symbol, MAX(created_date) AS max_created_date FROM nse_price_spurt_detail WHERE created_date BETWEEN");
        queryBuffer.append(" ");
        queryBuffer.append("'").append(toDateStartTimeString).append("'");
        queryBuffer.append(" ").append("AND");
        queryBuffer.append(" ");
        queryBuffer.append("'").append(toDateEndTimeString).append("'");
        queryBuffer.append(" ");
        queryBuffer.append("GROUP BY symbol) x ON t.symbol = x.symbol AND t.created_date = x.max_created_date;");

        return this.getEntityManager().createNativeQuery(queryBuffer.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctOpenPricePriceSpurtDetailsForADay(Date date, int lowerOpenPriceLimit, int upperOpenPriceLimit) {
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        String toDateString = simpleDateFormatWithoutTime.format(date);

        String toDateStartTimeString = String.format("%s %s", toDateString, "00:00:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "23:59:00");

        StringBuffer queryBuffer = new StringBuffer();
        queryBuffer.append("SELECT t.* FROM nse_price_spurt_detail t INNER JOIN ( SELECT symbol, MAX(created_date) AS max_created_date FROM nse_price_spurt_detail WHERE created_date BETWEEN");
        queryBuffer.append(" ");
        queryBuffer.append("'").append(toDateStartTimeString).append("'");
        queryBuffer.append(" ").append("AND");
        queryBuffer.append(" ");
        queryBuffer.append("'").append(toDateEndTimeString).append("'");
        queryBuffer.append(" ").append("AND");
        queryBuffer.append(" ");
        queryBuffer.append("open_price").append(" ").append("BETWEEN").append(" ").append(lowerOpenPriceLimit).append(" ").append("AND").append(" ").append(upperOpenPriceLimit);
        queryBuffer.append(" ");
        queryBuffer.append("GROUP BY symbol) x ON t.symbol = x.symbol AND t.created_date = x.max_created_date ORDER BY open_price;");

        return this.getEntityManager().createNativeQuery(queryBuffer.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }

    public List<NSEPriceSpurtDetailEntity> findDistinctPercentageChangePriceSpurtDetailsForADay(Date date, int lowerPercentageChangeLimit, int upperPercentageChangeLimit) {
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        String toDateString = simpleDateFormatWithoutTime.format(date);

        String toDateStartTimeString = String.format("%s %s", toDateString, "00:00:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "23:59:00");

        StringBuffer queryBuffer = new StringBuffer();
        queryBuffer.append("SELECT t.* FROM nse_price_spurt_detail t INNER JOIN ( SELECT symbol, MAX(created_date) AS max_created_date FROM nse_price_spurt_detail WHERE created_date BETWEEN");
        queryBuffer.append(" ");
        queryBuffer.append("'").append(toDateStartTimeString).append("'");
        queryBuffer.append(" ").append("AND");
        queryBuffer.append(" ");
        queryBuffer.append("'").append(toDateEndTimeString).append("'");
        queryBuffer.append(" ").append("AND");
        queryBuffer.append(" ");
        queryBuffer.append("percentage_change").append(" ").append("BETWEEN").append(" ").append(lowerPercentageChangeLimit).append(" ").append("AND").append(" ").append(upperPercentageChangeLimit);
        queryBuffer.append(" ");
        queryBuffer.append("GROUP BY symbol) x ON t.symbol = x.symbol AND t.created_date = x.max_created_date ORDER BY percentage_change;");

        return this.getEntityManager().createNativeQuery(queryBuffer.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }

    public List<NSEPriceSpurtDetailEntity> findPriceSpurtDetailsForASymbolOnAParticularDay(String symbol, Date date) {
        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        date = (date == null) ? new Date() : date;
        String toDateString = simpleDateFormatWithoutTime.format(date);

        String toDateStartTimeString = String.format("%s %s", toDateString, "00:00:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "23:59:00");

        StringBuffer queryBuffer = new StringBuffer();
        queryBuffer.append("SELECT * FROM nse_price_spurt_detail WHERE symbol=").append("'").append(symbol).append("'");
        queryBuffer.append(" ");
        queryBuffer.append("AND");
        queryBuffer.append(" ");
        queryBuffer.append("created_date").append(" ").append(">=").append(" ").append("'").append(toDateStartTimeString).append("'");
        queryBuffer.append(" ").append("AND").append(" ");
        queryBuffer.append("created_date").append(" ").append("<=").append(" ").append("'").append(toDateEndTimeString).append("'");
        queryBuffer.append(" ").append("ORDER BY").append(" ").append("symbol").append(" ").append("ASC").append(",").append(" ");
        queryBuffer.append("created_date").append(" ").append("DESC");

        return this.getEntityManager().createNativeQuery(queryBuffer.toString(), NSEPriceSpurtDetailEntity.class).getResultList();
    }
}
