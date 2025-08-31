package rave.code.repository.nse;

import rave.code.entity.AbstractEntity;
import rave.code.repository.stockbase.AbstractStockBaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class AbstractNSERepository<T> extends AbstractStockBaseRepository<T> {

    public AbstractNSERepository(Class<T> type) {
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
}
