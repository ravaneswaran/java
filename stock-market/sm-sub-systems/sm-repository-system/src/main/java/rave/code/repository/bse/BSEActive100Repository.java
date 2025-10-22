package rave.code.repository.bse;

import rave.code.entity.bse.BSEActive100Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSEActive100Repository extends StockMarketHistoryEnabledRepository<BSEActive100Entity> {

    public BSEActive100Repository() {
        this(BSEActive100Entity.class);
    }

    public BSEActive100Repository(Class<BSEActive100Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEActive100Entity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSEActive100Entity bseActive100Entity : entities) {
            if (bseActive100Entity.isNewEntity()) {
                entityManager.persist(bseActive100Entity);
            } else {
                entityManager.merge(bseActive100Entity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSEActive100Entity findBy(String primaryKey) {
        BSEActive100Entity bseActive100Entity = super.findBy(primaryKey);
        if (null != bseActive100Entity) {
            bseActive100Entity.setNewEntity(false);
        }
        return bseActive100Entity;
    }
}
