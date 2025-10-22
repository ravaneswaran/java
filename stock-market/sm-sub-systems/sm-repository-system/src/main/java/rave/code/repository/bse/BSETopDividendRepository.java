package rave.code.repository.bse;

import rave.code.entity.bse.BSETopDividendEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BSETopDividendRepository extends StockMarketHistoryEnabledRepository<BSETopDividendEntity> {

    public BSETopDividendRepository() {
        this(BSETopDividendEntity.class);
    }

    public BSETopDividendRepository(Class<BSETopDividendEntity> type) {
        super(type);
    }

    @Override
    public void bulkUpsert(List<BSETopDividendEntity> entities) {
        EntityManager entityManager = this.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        for (BSETopDividendEntity bseTopDividendEntity : entities) {
            //BSETopDividendEntity fromDB = this.findBy(bseTopDividendEntity.getCompanyName());
            if (bseTopDividendEntity.isNewEntity()) {
                //String priceMovement = String.format("%s->%s", fromDB.getLastPrice(), bseTopDividendEntity.getLastPrice());
                entityManager.persist(bseTopDividendEntity);
            } else {
                entityManager.merge(bseTopDividendEntity);
            }
        }
        entityTransaction.commit();
    }

    @Override
    public BSETopDividendEntity findBy(String primaryKey) {
        BSETopDividendEntity bseTopDividendEntity = super.findBy(primaryKey);
        if (null != bseTopDividendEntity) {
            bseTopDividendEntity.setNewEntity(false);
        }
        return bseTopDividendEntity;
    }

}
