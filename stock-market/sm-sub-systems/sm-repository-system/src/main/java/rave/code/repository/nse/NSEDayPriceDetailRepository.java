package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEDayPriceDetailEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NSEDayPriceDetailRepository extends AbstractNSERepositoryManager<NSEDayPriceDetailEntity> {

    private static final Logger LOGGER = Logger.getLogger(NSEDayPriceDetailRepository.class.getName());

    public NSEDayPriceDetailRepository() {
        super(NSEDayPriceDetailEntity.class);
    }

    @Override
    public Map<String, NSEDayPriceDetailEntity> getEntityMap() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT nseDayPriceDetailEntity FROM NSEDayPriceDetailEntity nseDayPriceDetailEntity");
        Query query = this.getEntityManager().createQuery(queryBuilder.toString());

        List<NSEDayPriceDetailEntity> nseDayPriceDetailEntities = query.getResultList();
        LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query.toString(), nseDayPriceDetailEntities.size()));

        Map<String, NSEDayPriceDetailEntity> dayPriceDetailEntityMap = new HashMap<>();
        for (NSEDayPriceDetailEntity nseDayPriceDetailEntity : nseDayPriceDetailEntities) {
            String key = String.format("%s:%s:%s", nseDayPriceDetailEntity.getSymbol(), nseDayPriceDetailEntity.getCompanyName(), nseDayPriceDetailEntity.getSeries());
            dayPriceDetailEntityMap.put(key, nseDayPriceDetailEntity);
        }

        return dayPriceDetailEntityMap;
    }

    @Override
    public List<NSEDayPriceDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return new ArrayList<>();
    }

    public void deleteAll() {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Query query = this.getEntityManager().createQuery("DELETE FROM NSEDayPriceDetailEntity nseDayPriceDetailEntity");
        int noOfRowsAffected = query.executeUpdate();
        entityTransaction.commit();
        LOGGER.log(Level.INFO, String.format("%s rows have been deleted from nse_day_price_detail table...", noOfRowsAffected));
    }

    public List<NSEDayPriceDetailEntity> findBySymbolAndSeries(String symbol, String series) {
        /*StringBuffer queryBuffer = new StringBuffer();
        queryBuffer.append("SELECT t.* FROM nse_day_price_detail t INNER JOIN (SELECT DISTINCT symbol, series FROM nse_stock_base) x");
        queryBuffer.append(" ON x.symbol = t.symbol AND x.series = t.series AND t.symbol = '");
        queryBuffer.append(symbol).append("'").append(" ");
        queryBuffer.append("AND").append(" ");
        queryBuffer.append("t.series").append("=").append("'");
        queryBuffer.append(series).append("'").append(" ");
        queryBuffer.append("ORDER BY business_date DESC");
        return this.getEntityManager().createNativeQuery(queryBuffer.toString(), NSEDayPriceDetailEntity.class).getResultList();*/

        /*StringBuffer queryBuffer = new StringBuffer();
        queryBuffer.append("SELECT * FROM nse_day_price_detail WHERE");
        queryBuffer.append(" ");
        queryBuffer.append("symbol").append("=").append("'").append(symbol).append("'");
        queryBuffer.append("AND").append(" ");
        queryBuffer.append("series").append("=").append("'").append(series).append("'");
        queryBuffer.append(" ");
        queryBuffer.append("ORDER BY business_date DESC");
        return this.getEntityManager().createNativeQuery(queryBuffer.toString(), NSEDayPriceDetailEntity.class).getResultList();*/

        CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEDayPriceDetailEntity> criteriaQuery = criteriaBuilder.createQuery(NSEDayPriceDetailEntity.class);
        Root<NSEDayPriceDetailEntity> root = criteriaQuery.from(NSEDayPriceDetailEntity.class);

        Predicate symbolPredicate = criteriaBuilder.equal(root.get("symbol"), symbol);
        Predicate seriesPredicate = criteriaBuilder.equal(root.get("series"), series);

        criteriaQuery.select(root).where(criteriaBuilder.and(symbolPredicate, seriesPredicate));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("businessDate")));

        return this.getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
