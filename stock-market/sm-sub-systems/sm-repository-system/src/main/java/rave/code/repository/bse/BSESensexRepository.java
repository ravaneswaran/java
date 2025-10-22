package rave.code.repository.bse;

import rave.code.entity.bse.BSESensexEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSESensexRepository extends StockMarketHistoryEnabledRepository<BSESensexEntity> {

    public BSESensexRepository() {
        this(BSESensexEntity.class);
    }

    public BSESensexRepository(Class<BSESensexEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSESensexEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSESensexEntity bseSensexEntity : entities) {
            //BSEActive100Entity fromDB = this.findBy(bseActive100Entity.getCompanyName());
            if (bseSensexEntity.isNewEntity()) {
                entityManager.persist(bseSensexEntity);
            } else {
                entityManager.merge(bseSensexEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSESensexEntity findBy(String primaryKey) {
        BSESensexEntity bseSensexEntity = super.findBy(primaryKey);
        if (null != bseSensexEntity) {
            bseSensexEntity.setNewEntity(false);
        }
        return bseSensexEntity;
    }
}
