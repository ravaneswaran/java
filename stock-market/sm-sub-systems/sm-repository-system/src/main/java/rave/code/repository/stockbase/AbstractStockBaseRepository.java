package rave.code.repository.stockbase;

import rave.code.entity.stockbase.AbstractStockBaseEntity;
import rave.code.repository.AbstractRepository;
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

public abstract class AbstractStockBaseRepository<T> extends AbstractRepository<T> {

    public AbstractStockBaseRepository(Class<T> type) {
        super(type);
    }

    public abstract Map<String, T> getEntityMap();

    @Override
    public void bulkUpsert(List<T> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (T stockBaseEntity : entities) {
            AbstractStockBaseEntity abstractStockBaseEntity = (AbstractStockBaseEntity)stockBaseEntity;
            if (abstractStockBaseEntity.isNewEntity()) {
                entityManager.persist(stockBaseEntity);
            } else {
                entityManager.merge(stockBaseEntity);
            }
        }
        entityTransaction.commit();
    }
}
