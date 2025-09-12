package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEPreOpenMarketDetailEntity;

import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NSEPreOpenMarketDetailRepository extends AbstractNSERepositoryManager<NSEPreOpenMarketDetailEntity> {

    public NSEPreOpenMarketDetailRepository() {
        super(NSEPreOpenMarketDetailEntity.class);
    }

    public Query getQuery(String preOpenType){
        String query = "SELECT * FROM NSEPreOpenMarketDetailEntity openMarketEntity WHERE openMarketEntity.preOpenType = :preOpenType";
        Query preOpenMarketDetailQuery = this.getEntityManager().createQuery(query);
        preOpenMarketDetailQuery.setParameter("preOpenType", preOpenType);

        return preOpenMarketDetailQuery;
    }

    public Query getQuery4EntitiesWithCreatedDateBetween_09_00_AM_And_09_08_AM(String preOpenType) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String toDate = simpleDateFormat.format(new Date());
        String startTimeAsStr = String.format("%s %s", toDate, "09:00:00");
        String endTimeAsStr = String.format("%s %s", toDate, "09:08:00");

        try {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date starTime = simpleDateFormat.parse(startTimeAsStr);
            Date endTime = simpleDateFormat.parse(endTimeAsStr);

            String query = "SELECT * FROM NSEPreOpenMarketDetailEntity openMarketEntity WHERE openMarketEntity.preOpenType = :preOpenType AND openMarketEntity.createdDate >= :startTime AND openMarketEntity.createdDate <= :endTime";
            Query preOpenMarketDetailQuery = this.getEntityManager().createQuery(query);
            preOpenMarketDetailQuery.setParameter("preOpenType", preOpenType);
            preOpenMarketDetailQuery.setParameter("startTime", starTime);
            preOpenMarketDetailQuery.setParameter("endTime", endTime);

            return preOpenMarketDetailQuery;

        } catch (ParseException exception) {
            return null;
        }
    }
}
