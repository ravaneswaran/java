package rave.code.repository.bse;

import rave.code.entity.bse.BSEActive200Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.logging.Logger;

public class BSEActive200Repository extends StockMarketHistoryEnabledRepository<BSEActive200Entity> {

    private static final Logger LOGGER = Logger.getLogger(BSEActive200Repository.class.getName());

    public BSEActive200Repository() {
        this(BSEActive200Entity.class);
    }

    public BSEActive200Repository(Class<BSEActive200Entity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSEActive200Entity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSEActive200Entity bseActive200Entity : entities) {
            if (bseActive200Entity.isNewEntity()) {
                entityManager.persist(bseActive200Entity);
            } else {
                entityManager.merge(bseActive200Entity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSEActive200Entity findBy(String primaryKey) {
        BSEActive200Entity bseActive200Entity = super.findBy(primaryKey);
        if (null != bseActive200Entity) {
            bseActive200Entity.setNewEntity(false);
        }
        return bseActive200Entity;
    }
}
