package rave.code.repository;

import rave.code.entity.AbstractEntity;
import rave.code.repository.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Map;

public abstract class AbstractStockBaseRepository<T> extends AbstractRepository<T> {

    public AbstractStockBaseRepository(Class<T> type) {
        super(type);
    }

    @Override
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

    public abstract Map<String, T> getEntityMap();
}
