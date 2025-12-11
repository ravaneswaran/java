package rave.code.repository.nse;

import rave.code.entity.nse.csv.NSEDayPriceDetailEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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
}
