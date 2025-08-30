package rave.code.repository.stockbase;

import rave.code.entity.stockbase.AbstractStockBaseEntity;
import rave.code.repository.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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
