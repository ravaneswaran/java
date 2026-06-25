package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPriceSpurtDetailEntity;

import java.text.SimpleDateFormat;
import java.util.*;

public class NSEPriceSpurtDetailRepository extends AbstractNSERepositoryManager<NSEPriceSpurtDetailEntity> {

    public NSEPriceSpurtDetailRepository() {
        super(NSEPriceSpurtDetailEntity.class);
    }

    public List<NSEPriceSpurtDetailEntity> findTodayDistinctPriceSpurtDetails() {

        SimpleDateFormat simpleDateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");
        String toDateString = simpleDateFormatWithoutTime.format(new Date());

        String toDateStartTimeString = String.format("%s %s", toDateString, "09:15:00");
        String toDateEndTimeString = String.format("%s %s", toDateString, "15:30:00");

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

    @Override
    public List<NSEPriceSpurtDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return List.of();
    }
}
