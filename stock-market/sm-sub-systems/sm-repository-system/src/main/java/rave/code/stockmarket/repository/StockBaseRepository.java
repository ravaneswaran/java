package rave.code.stockmarket.repository;

import rave.code.stockmarket.entity.BSEStockBaseEntity;
import rave.code.stockmarket.entity.NSEStockBaseEntity;
import rave.code.stockmarket.entity.StockBaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockBaseRepository extends StockMarketRepository<StockBaseEntity> {

    private static final Logger LOGGER = Logger.getLogger(StockBaseRepository.class.getName());

    public StockBaseRepository() {
        this(StockBaseEntity.class);
    }

    public StockBaseRepository(Class<StockBaseEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<StockBaseEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (StockBaseEntity stockBaseEntity : entities) {
            if (stockBaseEntity.isNewEntity()) {
                entityManager.persist(stockBaseEntity);
            } else {
                entityManager.merge(stockBaseEntity);
            }
        }
        entityTransaction.commit();
    }

    public Map<String, StockBaseEntity> findBySource(String source) {
        Class sourceType = null;
        switch (source) {
            case "NSE":
                sourceType = NSEStockBaseEntity.class;
                break;
            case "BSE":
                sourceType = BSEStockBaseEntity.class;
                break;
        }
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT stockBaseEntity FROM StockBaseEntity stockBaseEntity").append(" ");
        queryBuilder.append("WHERE").append(" ");
        queryBuilder.append("type(stockBaseEntity)").append("=").append(":source");
        Query query = this.getEntityManager().createQuery(queryBuilder.toString());
        query.setParameter("source", sourceType);

        List<StockBaseEntity> stockBaseEntities = query.getResultList();
        LOGGER.log(Level.INFO, String.format("the query(<<< %s >>>) did find %s item(s) in the repository...", query.toString(), stockBaseEntities.size()));

        Map<String, StockBaseEntity> mappedStockBaseEntity = new HashMap<>();
        for (StockBaseEntity stockBaseEntity : stockBaseEntities) {
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