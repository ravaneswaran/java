package rave.code.repository.nse;

import rave.code.entity.nse.technical.NSEExponentialMovingAverageDetailEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class NSEExponentialMovingAverageDetailRepository extends AbstractNSERepositoryManager<NSEExponentialMovingAverageDetailEntity> {

    public NSEExponentialMovingAverageDetailRepository() {
        super(NSEExponentialMovingAverageDetailEntity.class);
    }

    @Override
    public List<NSEExponentialMovingAverageDetailEntity> findLimitedEntitiesBySymbol(String symbol, int limit) {
        return List.of();
    }

    public NSEExponentialMovingAverageDetailEntity findByForeignKey(String foreignKey) {
        CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<NSEExponentialMovingAverageDetailEntity> cq = cb.createQuery(NSEExponentialMovingAverageDetailEntity.class);

        Root<NSEExponentialMovingAverageDetailEntity> nseExponentialMovingAverageDetailEntityRoot = cq.from(NSEExponentialMovingAverageDetailEntity.class);
        cq.where(cb.equal(nseExponentialMovingAverageDetailEntityRoot.get("nseStockBaseEntity").get("id"), foreignKey));

        List<NSEExponentialMovingAverageDetailEntity> nseExponentialMovingAverageDetailEntities = this.getEntityManager().createQuery(cq).getResultList();

        if (nseExponentialMovingAverageDetailEntities.size() == 1) {
            return nseExponentialMovingAverageDetailEntities.get(0);
        } else {
            return null;
        }
    }
}
