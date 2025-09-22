package rave.code.repository;

import rave.code.entity.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepositoryManager<T> extends ThreadSafeDatabaseManager<T> {

    public AbstractRepositoryManager(Class<T> type) {
        super(type);
    }

    public void bulkUpsert(List<T> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (T stockBaseEntity : entities) {
            AbstractEntity abstractStockBaseEntity = (AbstractEntity)stockBaseEntity;
            if (abstractStockBaseEntity.isNewEntity()) {
                entityManager.persist(stockBaseEntity);
            } else {
                entityManager.merge(stockBaseEntity);
            }
        }
        entityTransaction.commit();
    }

    public List<T> executeQuery(Query query){
        return query.getResultList();
    }

    public abstract Map<String, T> getEntityMap();
}
