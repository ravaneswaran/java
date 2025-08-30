package rave.code.stockmarket.repository;

import rave.code.stockmarket.entity.BSEStockBase10Entity;
import rave.code.stockmarket.entity.NSEStockBase10Entity;
import rave.code.stockmarket.entity.StockBase10Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockBase10Repository extends StockMarketRepository<StockBase10Entity> {

    private static final Logger LOGGER = Logger.getLogger(StockBase10Repository.class.getName());

    public StockBase10Repository() {
        this(StockBase10Entity.class);
    }

    public StockBase10Repository(Class<StockBase10Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<StockBase10Entity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (StockBase10Entity stockBaseEntity : entities) {
            if (stockBaseEntity.isNewEntity()) {
                entityManager.persist(stockBaseEntity);
            } else {
                entityManager.merge(stockBaseEntity);
            }
        }
        entityTransaction.commit();
    }

    public Map<String, StockBase10Entity> findBySource(String source) {
        Class sourceType = null;
        switch (source) {
            case "NSE":
                sourceType = NSEStockBase10Entity.class;
                break;
            case "BSE":
                sourceType = BSEStockBase10Entity.class;
                break;
        }
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT stockBaseEntity FROM StockBaseEntity stockBaseEntity").append(" ");
        queryBuilder.append("WHERE").append(" ");
        queryBuilder.append("type(stockBaseEntity)").append("=").append(":source");
        Query query = this.getEntityManager().createQuery(queryBuilder.toString());
        query.setParameter("source", sourceType);

        List<StockBase10Entity> stockBaseEntities = query.getResultList();
        LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query.toString(), stockBaseEntities.size()));

        Map<String, StockBase10Entity> mappedStockBaseEntity = new HashMap<>();
        for (StockBase10Entity stockBaseEntity : stockBaseEntities) {
            String key = null;
            if ("NSE".equals(source)) {
                key = String.format("%s:%s:%s:%s:%s", source, stockBaseEntity.getMkt(), stockBaseEntity.getSeries(), stockBaseEntity.getStockSymbol(), stockBaseEntity.getStockName());
            } else {
                key = String.format("%s:%s:%s:%s:%s", source, stockBaseEntity.getISIN(), stockBaseEntity.getSeries(), stockBaseEntity.getStockSymbol(), stockBaseEntity.getStockName());
            }
            mappedStockBaseEntity.put(key, stockBaseEntity);
        }

        return mappedStockBaseEntity;
    }

    public void deleteAll() {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Query query = this.getEntityManager().createQuery("DELETE FROM StockBaseEntity stockBaseEntity");
        int noOfRowsAffected = query.executeUpdate();
        entityTransaction.commit();
        LOGGER.log(Level.INFO, String.format("%s rows have been deleted from StockBaseEntity table...", noOfRowsAffected));
    }
}