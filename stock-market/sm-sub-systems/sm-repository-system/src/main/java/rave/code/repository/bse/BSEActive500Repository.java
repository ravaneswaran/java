package rave.code.repository.bse;

import rave.code.entity.bse.BSEActive500Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSEActive500Repository extends StockMarketHistoryEnabledRepository<BSEActive500Entity> {

    public BSEActive500Repository() {
        this(BSEActive500Entity.class);
    }

    public BSEActive500Repository(Class<BSEActive500Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEActive500Entity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSEActive500Entity bseActive500Entity : entities) {
            if (bseActive500Entity.isNewEntity()) {
                entityManager.persist(bseActive500Entity);
            } else {
                entityManager.merge(bseActive500Entity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSEActive500Entity findBy(String primaryKey) {
        BSEActive500Entity bseActive500Entity = super.findBy(primaryKey);
        if (null != bseActive500Entity) {
            bseActive500Entity.setNewEntity(false);
        }
        return bseActive500Entity;
    }
}
